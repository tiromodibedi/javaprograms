/*********************************************************
*  HangMan Game Program for GUI's                        *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 30-10-2017                                      *
*********************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;


public class GameStructure {
  /*  instance variables  */
  private String[] wordList;
  private JTextField tf;
  private JLabel jlLetsUsed;
  private static String letter;
  private static int[] wordLength = new int[64];
  private static int level = (int) (Math.random() * 64);// random word
  private static JFrame frame = new JFrame();
  private static ImageIcon bg = new ImageIcon("hangman1.png");
  private static ImageIcon logo = new ImageIcon("logo.png");
  private static ImageIcon ic = new ImageIcon("hangmanIcon.png");
  private JLabel img;

  private JFrame gameFrame = new JFrame();
  private JPanel bottomRight = new JPanel();
  private JPanel bottomLeft = new JPanel();
  private JPanel top = new JPanel();
  private JPanel bottom = new JPanel();
  private JPanel imgPane = new JPanel();
  private JPanel panel1 = new JPanel();



  /*  constructor  */
  public GameStructure(){
    wordList = { "computer", "java", "activity", "alaska",
            "appearance", "javatar", "automobile", "falafel", "birthday",
            "canada", "central", "character", "chicken", "chosen", "cutting",
            "daily", "darkness", "shawarma", "disappear", "driving", "effort",
            "establish", "exact", "establishment", "fifteen", "football",
            "foreign", "frequently", "frighten", "function", "gradually",
            "hurried", "identity", "importance", "impossible", "invented",
            "italian", "journey", "lincoln", "london", "massage", "minerals",
            "outer", "paint", "particles", "personal", "physical", "progress",
            "quarter", "recognise", "replace", "rhythm", "situation",
            "slightly", "steady", "stepped", "strike", "successful", "sudden",
            "terrible", "traffic", "unusual", "volume", "yesterday" };
    wordLength = new int[64];
    level = (int) (Math.random() * 64);// random word
    frame = new JFrame();
    bg = new ImageIcon("hangman1.png");
    logo = new ImageIcon("logo.png");
    ic = new ImageIcon("hangmanIcon.png");
    img = new JLabel(bg, JLabel.CENTER);

    public void window() {
        bg = new ImageIcon("hangman1.png");
        img.setIcon(bg);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        imgPane.setLayout(new BorderLayout());
        panel1.setLayout(new BorderLayout());
        panel1.setOpaque(false);// !!
        top.setBorder(BorderFactory.createTitledBorder(""));
        bottom.setBorder(BorderFactory.createTitledBorder(""));
        tf = new JTextField(1);
        JLabel jl = new JLabel("Enter a letter", JLabel.CENTER);
        jlLetsUsed = new JLabel("Letters used:  ", JLabel.CENTER);
        final JLabel jlLines = new JLabel("__ ", JLabel.CENTER);
        jl.setFont(new Font("Rockwell", Font.PLAIN, 20));
        tf.setFont(new Font("Rockwell", Font.PLAIN, 20));
        jlLetsUsed.setFont(new Font("Rockwell", Font.PLAIN, 20));
        jlLines.setFont(new Font("Rockewell", Font.PLAIN, 20));
        imgPane.add(img);// center
        top.add(jl);// top center
        top.add(tf);// top center
        bottomLeft.add(jlLetsUsed);// bottom left position
        bottomRight.add(jlLines);// bottom right position
        bottom.add(bottomLeft);// bottom
        bottom.add(bottomRight);// bottom
        panel1.add(imgPane, BorderLayout.CENTER);// background image (center)
        panel1.add(top, BorderLayout.NORTH);// text field and jlabel (top)
        panel1.add(bottom, BorderLayout.SOUTH);// blank spaces and letters used
        //gameFrame.setJMenuBar(menuBar);
        gameFrame.setTitle("Hangman");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setIconImage(new ImageIcon("logo.png").getImage());
        gameFrame.setResizable(false);
        gameFrame.add(panel1);
        gameFrame.setSize(800, 500);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);

        int j = 0;
        String line = "";
        for (j = 0; j < 64; j++) {
            wordLength[j] = wordList[j].length();// gets length of words
        }// end for
        int m = 0;
        // creates line first then put into .setText
        while (m < wordLength[level]) {
            line += "__ ";
            m++;
        }// end for
        jlLines.setText(line);

        tf.addActionListener(new ActionListener() {
            int wrong = 0;
            int right = 0;

            @Override
            public void actionPerformed(ActionEvent e) {// enter key
                JTextField tf = (JTextField) e.getSource();
                letter = tf.getText();
                tf.setText("");
                // tf.requestFocus();
                jlLetsUsed.setText(jlLetsUsed.getText() + letter + " ");// sets
                                                                        // jlabel
                                                                        // text
                                                                        // to
                                                                        // users
                                                                        // entered
                                                                        // letter
                char[] jlabelText = jlLines.getText().toCharArray();// converts
                                                                    // string to
                                                                    // character
                                                                    // array
                                                                    // (array is
                                                                    // length of
                                                                    // string)
                char userEnteredChar = letter.charAt(0);
                // System.out.println(wordList[level]);
                if (!wordList[level].contains(letter)) {
                    wrong++;
                    if (wrong == 1) {
                        bg = new ImageIcon("hangman2.png");
                        img.setIcon(bg);
                    }
                    if (wrong == 2) {
                        bg = new ImageIcon("hangman3.png");
                        img.setIcon(bg);
                    }
                    if (wrong == 3) {
                        bg = new ImageIcon("hangman4.png");
                        img.setIcon(bg);
                    }
                    if (wrong == 4) {
                        bg = new ImageIcon("hangman5.png");
                        img.setIcon(bg);
                    }
                    if (wrong == 5) {
                        bg = new ImageIcon("hangman6.png");
                        img.setIcon(bg);
                    }
                    if (wrong == 6) {
                        bg = new ImageIcon("hangman7.png");
                        img.setIcon(bg);
                    }
                    if (wrong == 6) {
                        JOptionPane
                                .showMessageDialog(frame, "He's dead." + "\n"
                                        + "Press 'OK' to restart." + "\n"
                                        + "The word was " + wordList[level]
                                        + ".", "You Lost",
                                        JOptionPane.INFORMATION_MESSAGE, ic);
                        GameStructure restart = new GameStructure();
                        level = (int) (Math.random() * 64);// generate new
                                                            // random word
                        restart.window();
                    }
                    return;
                }
                int i = 0;
                for (i = 0; i < wordList[level].length(); i++) {
                    if (wordList[level].charAt(i) == userEnteredChar) {
                        jlabelText[3 * i] = ' ';
                        jlabelText[3 * i + 1] = userEnteredChar;
                        right++;
                    }// end if
                }// end for
                jlLines.setText(String.valueOf(jlabelText));
                if (jlabelText.length / 3 == right) {
                    JOptionPane.showMessageDialog(frame, "You got the word!"
                            + "\n" + "Press 'OK' for new word", "Good Job",
                            JOptionPane.INFORMATION_MESSAGE, logo);
                    GameStructure restart = new GameStructure();
                    level = (int) (Math.random() * 64);// generate new
                                                        // random word
                    restart.window();
                }
            }// end actionPerformed method
        });
    }// end window method
  }

}


/*********************************************************
*  HangMan Game Program for GUI's                        *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 30-10-2017                                      *
*********************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class HangMan extends JFrame{
  /*  instance variables  */
  private WordList wordList;
  private JTextField textField;
  private JLabel lettersUsed;
  private static String inputLetter;
  private int listLength;
  private static int[] wordsArray;
  private static int level;
  private static ImageIcon background;
  private static ImageIcon logo;
  private static ImageIcon icon;
  private Jlabel image;
  private JFrame gameFrame;
  private JPanel bottomRight;


  /*  constructor  */
  public HangMan(){
    super();
    initialiseComponents();
  }

  public void initialiseComponents(){
    try {
      wordList = WordList.readFromFile("dictionary.txt");
    } catch (Exception e) {
      e.printStackTrace();
    }
    listLength = wordList.size(); // num of words
    wordsArray = new int[listLength]; // wordsArray
    level = (int) (Math.random() * listLength); // random number



  }





}
