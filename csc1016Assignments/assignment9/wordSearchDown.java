//Version 1.0 - Completed 7/26/12
import java.util.*;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.*;
import java.awt.event.*;

public class wordSearch extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JFrame win, helpWin, aboutWin;
	private JTextArea inBox, fileName, outBox;
	private JPanel north, label, center, south, 
		checkPanel1, checkPanel2, resultsLimitPanel;
	private JLabel l1, l2, l3;
	private JTextField numResults;
	private JButton choose, clear, search;
	private JFileChooser fileC;
	private JScrollPane scrollPane1, scrollPane2;
	private JCheckBox caseIgnore, dotall, literal, multiline, comments;
	private int flags;
	
	//the amount of results where the user should be queried if they want
	//all displayed
	private int resultsLimit;
	private boolean staggerResults;
	private final String HELP_URL = "wordSearchHelp.html";
	private final String ABOUT_URL = "wordSearchAbout.html";

	public wordSearch(){
		
		//Add the search string input box
		l1 = new JLabel("Enter a search string:");
		l1.setVerticalAlignment(SwingConstants.BOTTOM);
		l1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		north = new JPanel(new BorderLayout());
		north.add(l1, BorderLayout.NORTH);
		
		inBox = new JTextArea(4, 20);
		inBox.setLineWrap(true);
		inBox.setWrapStyleWord(true);
		scrollPane1 = new JScrollPane(inBox);
		north.add(scrollPane1, BorderLayout.CENTER);
		north.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(north);
		
		//Add the check boxes
		flags = 0;
		caseIgnore = new JCheckBox("Ignore Case");
		dotall = new JCheckBox("dotall Mode");
		literal = new JCheckBox("Literal Parsing");
		multiline = new JCheckBox("Multiline Mode");
		comments = new JCheckBox("Permit Comments");
		caseIgnore.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
		dotall.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
		multiline.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
		checkPanel1 = new JPanel();
		checkPanel2 = new JPanel();
		checkPanel1.setLayout(new BoxLayout(checkPanel1, BoxLayout.X_AXIS));
		checkPanel2.setLayout(new BoxLayout(checkPanel2, BoxLayout.X_AXIS));
		checkPanel1.add(caseIgnore);
		checkPanel1.add(dotall);
		checkPanel1.add(literal);
		checkPanel2.add(multiline);
		checkPanel2.add(comments);
		checkPanel1.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
		checkPanel2.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
		add(checkPanel1);
		add(checkPanel2);

		//Add a results limit field
		resultsLimitPanel = new JPanel();
		resultsLimitPanel.setLayout(new BoxLayout(resultsLimitPanel, BoxLayout.X_AXIS));
		l3 = new JLabel("Show this many results at a time:");
		l3.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		numResults = new JTextField("*", 5);
		numResults.setEditable(true);
		numResults.setMaximumSize(new Dimension(60, 30));
		numResults.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		resultsLimitPanel.add(l3);
		resultsLimitPanel.add(numResults);
		add(resultsLimitPanel);
		staggerResults = true;
		
		//Add the file chooser button and field
		l2 = new JLabel("Choose a txt file to search:");
		l2.setAlignmentX(Component.LEFT_ALIGNMENT);
		l2.setBorder(BorderFactory.createEmptyBorder(25,5,5,5));
		label = new JPanel();
		label.setLayout(new BorderLayout());
		label.add(l2, BorderLayout.WEST);
		add(label);
		center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
		fileName = new JTextArea(3, 30);
		fileName.setEditable(true);
		fileName.setLineWrap(true);
		fileName.setWrapStyleWord(true);
		//fileName.setSize(new Dimension(30, 60));
		choose = new JButton("Choose File");
		choose.setActionCommand("choose");
		choose.addActionListener(this);
		choose.setMnemonic(KeyEvent.VK_F);
		choose.setMaximumSize(new Dimension(16, 26));
		center.add(choose);
		center.add(Box.createRigidArea(new Dimension(10, 0)));
		center.add(fileName);
		center.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		add(center);
		
		fileC = new JFileChooser();
		fileC.setApproveButtonText("Choose File");
		fileC.setDialogTitle("Choose File To Search");
		FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
		fileC.addChoosableFileFilter(filter);
		
		//Add the search button
		ImageIcon mg = new ImageIcon(getClass().getResource("Search_icon.png"), "magnifying glass");
		search = new JButton("Search!", mg);
		search.setMnemonic(KeyEvent.VK_S);
		search.setAlignmentX(Component.CENTER_ALIGNMENT);
		search.setMinimumSize(new Dimension(100, 60));
		search.setActionCommand("search");
		search.addActionListener(this);
		add(search);
		
		//Add the results display box and "Clear" button
		south = new JPanel();
		south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));
		outBox = new JTextArea(15, 30);
		outBox.setLineWrap(true);
		outBox.setWrapStyleWord(true);
		outBox.setEditable(false);
		scrollPane2 = new JScrollPane(outBox);
		scrollPane2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		south.add(scrollPane2);
		clear = new JButton("Clear Results");
		clear.setMnemonic(KeyEvent.VK_C);
		clear.setAlignmentX(Component.CENTER_ALIGNMENT);
		clear.setActionCommand("clear");
		clear.addActionListener(this);
		clear.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		south.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));
		south.add(clear);
		add(south);
		

	}
	
	public JMenuBar createMenuBar(){
				
		//Set up the menu
		JMenuBar menuBar = new JMenuBar();
		JMenu helpMenu = new JMenu("Help me!");
		helpMenu.setMnemonic(KeyEvent.VK_HELP);
		JMenuItem help = new JMenuItem("Help! What's going on?!");
		help.setMnemonic(KeyEvent.VK_H);
		help.addActionListener(this);
		help.setActionCommand("help");
		JMenuItem about = new JMenuItem("About wordSearch");
		about.setMnemonic(KeyEvent.VK_A);
		about.addActionListener(this);
		about.setActionCommand("about");
		helpMenu.add(help);
		helpMenu.add(about);
		menuBar.add(helpMenu);		
		
		return menuBar;
	}

	private static void createAndShowGUI(){

		JFrame win = new JFrame("wordSearch");
		JComponent newContentPane = new wordSearch();
		newContentPane.setOpaque(true);
		win.setContentPane(newContentPane);
		win.setJMenuBar(((wordSearch)newContentPane).createMenuBar());
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.pack();
		win.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e){
		
		//If it is from the search button, validate input and perform the search
		if(e.getActionCommand().equals("search")){
			
			String limitStr = numResults.getText().trim();
			
			//Validate results limit field; An asterisk in the numResults 
			//field indicates all results should be shown
			if(limitStr.equals("*"))
				staggerResults = false;
			else if(limitStr.matches(".*\\D.*") || (Integer.valueOf(limitStr) < 2)){
				JOptionPane.showMessageDialog(win, "Nice try.\nPlease input a number greater than 1 to show " 
						+ "some results \nor an asterisk (*) to show all results.\n", "What are you doing?!", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			else{
				resultsLimit = Integer.valueOf(limitStr);
				staggerResults = true;
			}
			String text = fileName.getText();
			
			//Launch new thread to perform the search
			Thread t = new Thread(new performSearch(text));
			t.start();

			
		}
		//If it is from the choose button, choose the file
		else if(e.getActionCommand().equals("choose")){
			
			int returnVal = fileC.showOpenDialog(wordSearch.this);

			if(returnVal == JFileChooser.APPROVE_OPTION){
				File text = fileC.getSelectedFile();
				fileName.setText(text.getAbsolutePath());
			}
		}
		//If it is from the clear button, clear the display
		else if(e.getActionCommand().equals("clear")){
			outBox.setText("");
		}
		else if(e.getActionCommand().equals("help")){

			helpWin = new JFrame("wordSearch Help");
			helpWin.add(new helpFrame());
			helpWin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			helpWin.pack();
			helpWin.setVisible(true);
			
		}
		else if(e.getActionCommand().equals("about")){

			aboutWin = new JFrame("About wordSearch");
			aboutWin.add(new aboutFrame());
			aboutWin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			aboutWin.setPreferredSize(new Dimension(530, 550));
			aboutWin.pack();
			aboutWin.setVisible(true);
		}

	}
	
	//Runnable to be started when the Choose button sends an event
	private class performSearch implements Runnable{

		Scanner input;
		String searchString;
		String matchStr = "";
		Pattern pattern;
		int count = 0;
		File f;

		performSearch(String file){  f = new File(file); }

		public void run() {
		
			try {
	
				input = new Scanner( f );
				
				searchString = inBox.getText();
				
				flags = 0;
				
				if(caseIgnore.isSelected())
					flags |= Pattern.CASE_INSENSITIVE;
				if(dotall.isSelected())
					flags |= Pattern.DOTALL;
				if(literal.isSelected())
					flags |= Pattern.LITERAL;
				if(multiline.isSelected())
					flags |= Pattern.MULTILINE;
				if(comments.isSelected())
					flags |= Pattern.COMMENTS;
				
				if(flags == 0)
					pattern = Pattern.compile(searchString);
				else
					pattern = Pattern.compile(searchString, flags);
				
				while(true){
					
					matchStr = input.findWithinHorizon(pattern, 0);
	
					if(matchStr == null)
						break;
					else
						outBox.append("Found the string \"" + matchStr + "\"\n");
	
					//code a limit on results
					count++;
	
					if(staggerResults && (count % resultsLimit == 0) && (count >= resultsLimit)){
	
						int result = JOptionPane.showOptionDialog(win, "Show the next " 
							+ resultsLimit	+ " results?\n", "Lots of results", 
							JOptionPane.YES_NO_OPTION, 
							JOptionPane.QUESTION_MESSAGE, null, null, null);
	
						if(result == JOptionPane.CLOSED_OPTION || result == JOptionPane.NO_OPTION)
							break;
	
					}
				}

			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(win, "File not found.\nPlease name another "
						+ "file, preferably one that exists.", "What are you doing?!", 
						JOptionPane.WARNING_MESSAGE);
				return;
			} finally{
	
				if(input != null)
					input.close();
			}	
				if(count > 1)
					outBox.append("There were " + count + " results.\n");
				else if(count == 1)
					outBox.append("There was 1 result.\n");				
				else
					outBox.append("No results!\n");
								
		}
	}

	//Inner class that creates the frame for the "help" document
	private class helpFrame extends JScrollPane implements HyperlinkListener{
		
		//For serialization
		private static final long serialVersionUID = 1L;
		JEditorPane editPane;
		URL helpPage;
		
		helpFrame(){
			
			editPane = new JEditorPane();
			editPane.setEditable(false);
			helpPage = wordSearch.class.getResource(HELP_URL);
			
			if(helpPage != null){
				try{
					editPane.setPage(helpPage);
				} catch (IOException ioe){
					System.err.println("Attempted to read a bad URL: " + helpPage);
				}
				
			}
			else{
				System.err.println("Couldn't find file: " + HELP_URL);
				editPane.setText("Couldn't find file: " + HELP_URL);
			}
			
			editPane.addHyperlinkListener(this);
			setViewportView(editPane);
			setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			setPreferredSize(new Dimension(700, 1145));
			setMinimumSize(new Dimension(10, 10));
			
		}
		
		public void hyperlinkUpdate(HyperlinkEvent e){
			
			if(e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED)){
				
				URL eventURL = e.getURL();
				
				try{
					//i.e., if the location is on the web, and not in the help doc,
					// use the default web browser
					if(eventURL.toString().contains("http://")){
						
						Desktop desktop = Desktop.getDesktop();
						URI eventURI;
					
					
						eventURI = eventURL.toURI();

						if(Desktop.isDesktopSupported() 
								&& desktop.isSupported(Desktop.Action.BROWSE))
								desktop.browse(eventURI);	
						else{
							JOptionPane.showMessageDialog(this, "Web browsing not supported.\n"
									+ "Try choosing a default web browser on your system.\n"
									+ "Sorry about that.", "No web for you", 
									JOptionPane.WARNING_MESSAGE);
						}

					}
					//else, the link is within the help doc and can be displayed
					// in the EditorPane
					else
						editPane.setPage(e.getURL());
					
				}catch(IOException ioe){
					System.err.println(ioe);
				}catch(URISyntaxException ue){
					System.err.println(ue);
				}
			}
		}
	}
	
	//Inner class that creates the frame for the "about" document
	private class aboutFrame extends JPanel implements ActionListener{

		
		
		//for serialization 
		private static final long serialVersionUID = 1L;
		JEditorPane editPane;
		JButton ok;
		URL aboutPage;
				
		public aboutFrame(){

			editPane = new JEditorPane();
			editPane.setEditable(false);
			aboutPage = wordSearch.class.getResource(ABOUT_URL);
			
			if(aboutPage != null){
				
				try{
					editPane.setPage(aboutPage);
				} catch (IOException ioe){
					System.err.println("Attempted to read a bad URL: " + aboutPage);
				}
				
			}
			else{
				System.err.println("Couldn't find file: " + ABOUT_URL);
				editPane.setText("Couldn't find file: " + ABOUT_URL);
			}
			
			ok = new JButton("Get me outta here");
			ok.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
			ok.setActionCommand("ok");
			ok.setMnemonic(KeyEvent.VK_G);
			ok.addActionListener(this);
			//set layout
			add(editPane);
			add(ok);
			setPreferredSize(new Dimension(430, 470));
			setMinimumSize(new Dimension(10, 10));
			setBackground(Color.WHITE);
			
		}

		public void actionPerformed(ActionEvent e){
			
			if(e.getActionCommand().equals("ok")){

				aboutWin.dispose();
			}
		}
	}
	public static void main(String[] args){

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });	
	}
}