/******************************************************************
 * Program 3: Hangman
 *
 *
 ******************************************************************/


import javax.swing.*; 		// needed for JFrame
import java.awt.*;    		// needed for Container
import java.awt.event.*;  	// needed for ActionListener
import java.io.*;

public class HangmanGUI extends JFrame
									   implements ActionListener
{
	// title and size constants
	private final static String TITLE = "Hangman";
	private final static int WIDTH = 700;
	private final static int HEIGHT = 600;

	// MEMBER VARIABLES

	// LETTER INFORMATION
	JButton letterButtons[];
	boolean letterChosen[];

	// IMAGE INFORMATION
	private ImageIcon[] hangImages;
	private int currentImage;
	private JLabel imageLabel;

	// LABEL FOR THE GAME
	private JTextArea gameLabel;

	// NEW GAME BUTTON
	JButton newGameButton;

	Hangman game;
	boolean hung = false;
	boolean won = false;

	// constructor
	public HangmanGUI()
	{
		try{
			game = new Hangman();
		}
		catch( FileNotFoundException f ){}
		catch( IOException io ){}

		// set title and height
		setTitle(TITLE);
		setSize(WIDTH,HEIGHT);

		// get access to content pane
		Container content = getContentPane();
		content.setLayout (new BorderLayout());		  // set Layout to BorderLayout
		content.setBackground(Color.green.darker().darker());		// change the color

		/////////// LETTERS /////////////////
		// Create placement for alphabet buttons in grid format
		JPanel letterPanel = new JPanel();
		letterPanel.setLayout(new GridLayout(2, 18));

		letterChosen = new boolean[26];
		letterButtons = new JButton[26];
		for(int i=0; i<letterButtons.length; i++){
			letterButtons[i] = new JButton();
			letterButtons[i].addActionListener(this);
		}
		initializeLetters();

		// Add Buttons to the grid container
		for(int i=0; i<letterButtons.length; i++){
			letterPanel.add(letterButtons[i]);
		}

		// Add panel of letter buttons to the screen
		content.add(letterPanel, BorderLayout.SOUTH);


		/////////// IMAGES /////////////////
		imageLabel = new JLabel ("", SwingConstants.CENTER);
		initializeImages();
		imageLabel.setIcon( hangImages[ currentImage ] );


		/////////// TEXT (GAME) /////////////////
		JPanel gamePanel = new JPanel(new GridLayout(3,1));
		gameLabel = new JTextArea(game.getDisplay());
		gameLabel.setFont(new Font("Serif", Font.BOLD, 30));
		gameLabel.setLineWrap(true);
		gameLabel.setWrapStyleWord(true);
		gameLabel.setEditable(false);
		gameLabel.setBackground(Color.green.darker().darker());
		gamePanel.add( new JLabel("") );
		gamePanel.add( gameLabel );
		gamePanel.setBackground(Color.green.darker().darker());


		/////////// GAME CONTAINER /////////////////
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 2));
		mainPanel.setBackground( Color.green.darker().darker());
		mainPanel.add( gamePanel );
		mainPanel.add( imageLabel );


		// Add panel of Text and Images to center
		content.add(mainPanel, BorderLayout.CENTER);

		/////////// NEW GAME BUTTON /////////////////
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(this);
		newGameButton.setBackground(Color.white);

		JPanel newGamePanel = new JPanel();
		newGamePanel.setBackground(Color.green.darker().darker());
		newGamePanel.add( newGameButton );
		content.add(newGamePanel, BorderLayout.NORTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}



  /***************************************************************
   * initializeImages
   *
   * Initializes the hangImages array and the currentImage
	* variable to 0.  This method should only be called once in
	* constructor method.
   ***************************************************************/
  	public void initializeImages(){
		hangImages = new ImageIcon[9];
		currentImage = 0;

		for(int i=0; i<hangImages.length; i++){
			hangImages[i] = new ImageIcon("hangman" + i + ".jpg");
		}
	}// end initializeImages method



  /***************************************************************
   * updateImage
   *
   * Increment currentImage variable.  If currentImage is larger
	* than the size of the hangImages array, then the method returns.
	* Otherwise, the imageLabel is updated.
   ***************************************************************/
	public void updateImage(int numErrors){

		if( numErrors >= hangImages.length ){
			System.out.println("ERROR: in updateImage() state cannot be larger than " + numErrors);
			return;
		}
		imageLabel.setIcon( hangImages[ numErrors ] );
	}



  /***************************************************************
   * initializeLetters
   *
   * Initializes the letterButtons and letterChosen arrays.
	* - labels on the buttons are set to their respective character value
	* - color of each button is set to yellow
	* - letterChosen is set to false for each letter
   ***************************************************************/
	public void initializeLetters(){

		for(int i=0; i<letterButtons.length; i++){
			char label = (char)('A' + i);
			letterButtons[i].setText( label + "" );
			letterButtons[i].setBackground(Color.yellow);

			letterChosen[i] = false;
		}
	}// end initializeLetters method



  /***************************************************************
   * startNewGame
   *
   * Sets up a new game.
	* - letters are reinitialized
	* - images are reinitialized
	* - gets new game from Hangman object
   ***************************************************************/
	public void startNewGame()
	{
		// RESET LETTERS
		initializeLetters();

		// RESET IMAGES TO START
		currentImage = 0;
		imageLabel.setIcon( hangImages[ currentImage ] );

		game.startNewGame();
		gameLabel.setText( game.getDisplay() );

		hung = false;
		won = false;
	}


  /***************************************************************
   * actionPerformed
   *
   * Performs an action based on which button was clicked by the
	* user.
	* - If a letter button is pushed, the letter is sent to the
	* 		game object to determine if the letter is there.
	*		- If the letter is there, the display is updated
	*		- If the letter is not there, the image is updated
	* - If the new game button is pushed, the startNewGame() method
	*		is called.
   ***************************************************************/

	public void actionPerformed (ActionEvent e)
	{
		if( !hung && !won ){
			// Checks if user pressed a letter button
			for(int i=0; i<letterButtons.length; i++ ){

				// Checks if the ith button was pressed and if the button
				// has not been pressed previously
				if (e.getSource() == letterButtons[i] && !letterChosen[i]) {
					char letter = (char)('A' + i);
					letterButtons[i].setText( "" );
					letterButtons[i].setBackground(Color.gray);
					letterChosen[i] = true;

					// Pass along the chosen letter to the findChar method
					if( game.findChar( letter ) ){
						won = game.updateDisplay( letter );
						gameLabel.setText( game.getDisplay() );
					}
					else{
						// The letter was not there, so update the image
						// to the next hanged image based on the number
						// of misses to date.
						updateImage( game.getNumMisses() );

						// If the number of misses is equal to the number
						// of total images, then the user has lost and
						// hung is true
						if( game.getNumMisses() == (hangImages.length-1) )
							hung = true;

					}// end else
				}//end if

			}// end for loop
		}// end if


		// Checks if user pressed newGameButton
		if (e.getSource() == newGameButton ){
			startNewGame();
		}

	}// end actionPerformed method


	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		HangmanGUI gui = new HangmanGUI();
	}


}
