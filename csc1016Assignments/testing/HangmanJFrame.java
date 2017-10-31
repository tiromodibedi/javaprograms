import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/** class to display a JFrame object using border layout */

public class HangmanJFrame extends JFrame implements ActionListener {

 private JPanel centerPanel;
 private JPanel southPanel;
 private JTextField textField;
 private LinePanel line;
 private String [] wordList = {"computer","java","activity","alaska","appearance","article",
   "automobile","basket","birthday","canada","central","character","chicken","chosen",
   "cutting","daily","darkness","diagram","disappear","driving","effort","establish","exact",
   "establishment","fifteen","football","foreign","frequently","frighten","function","gradually",
   "hurried","identity","importance","impossible","invented","italian","journey","lincoln",
   "london","massage","minerals","outer","paint","particles","personal","physical","progress",
   "quarter","recognise","replace","rhythm","situation","slightly","steady","stepped",
   "strike","successful","sudden","terrible","traffic","unusual","volume","yesterday" };

 public ArrayList<String> usedLetters = new ArrayList(); // list of used letter by user
 public ArrayList<String> correctLetters = new ArrayList();
 public String userInput = "";

 private int numLives = 6; // number of lives
 public String theWord; // the wrong which is chosen
 JButton exitButton;
 JButton playAgain;

 // no-argument constructor
 public HangmanJFrame() { 
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  theWord = pickWord();
  correctLetters = new ArrayList(theWord.length());

  setSize(600,500);
  setLocation(100, 100);
  setTitle("Hangman Game");
  setLayout(new BorderLayout());

  centerPanel = new JPanel();
  line = new LinePanel(15,theWord,usedLetters);
  centerPanel.setSize(500,500);
  centerPanel.setBackground(Color.WHITE);
  centerPanel.add(line);
  add(centerPanel, BorderLayout.CENTER);

  textField = new JTextField(20);
  textField.addActionListener(this);

  playAgain = new JButton("Play Again");
  exitButton = new JButton("Exit");
  exitButton.addActionListener(this);
  playAgain.addActionListener(this);

  southPanel = new JPanel();
  southPanel.setBackground(Color.BLACK);
  southPanel.setLayout(new  GridLayout(0,3));
  southPanel.add(playAgain);
  southPanel.add(textField);
  southPanel.add(exitButton);
  add(southPanel, BorderLayout.SOUTH);

 }

 // Picks a word, latter it will be picked randomly.
 private String pickWord(){
  return wordList[0];
 }

 // This method check wither the input is valid
 // i.e. its in the alphabet.
 private boolean checkInput(String s){
  String [] alphabet = {"a","b","c","d","e","f",
    "g","h","i","j","k","l","m","n","o","p",
    "q","r","s","t","u","v","w","x","y","z"};

  for (int i = 0; i < alphabet.length; i++){
   if (s.equals(alphabet[i]) && s.length() <= 1){
    return true;
   }
  }
  return false;
 }

 /**
  * 
  */
 public void Play(){


  if (numLives > 0){

   if (userInput.length() == 1 && usedLetters.contains(userInput) == false &&
     checkInput(userInput) == true){
    usedLetters.add(userInput);

    if (theWord.contains(userInput) == true){
     correctLetters.add(userInput);
     centerPanel.removeAll();

     line = new LinePanel(20,theWord,correctLetters);
     centerPanel.add(line);
     centerPanel.revalidate();
    }

    else{
     numLives = numLives - 1;

     centerPanel.removeAll();
     line = new LinePanel(numLives,theWord,correctLetters);

     centerPanel.add(line);
     centerPanel.revalidate();
    }
   }

   else if (userInput.length() > 1)
    System.out.println("Enter a valid letter");

   else if (userInput.length() == 1 && checkInput(userInput) == true && theWord.contains(userInput)){
    correctLetters.add(userInput);
   }

   centerPanel.removeAll();

   line = new LinePanel(20,theWord,usedLetters);
   centerPanel.add(line);
   centerPanel.revalidate();
  }  
}
 // return true if the word and the correctly used letters list match
 public boolean checkWord(String s, ArrayList<String> t){
  String temp = "";

  for (int i = 0; i < s.length(); i++){
   if ( t.contains(s.substring(i, i+1)) == true){
    temp += s.substring(i, i+1);
   }
  }

  if (s.equals(temp)){
   return true;
  }

  return false;
 }

 public void actionPerformed(ActionEvent evt) {
  String temp = textField.getText();
  if (temp.length() == 1){
   userInput = temp;
  }
  textField.selectAll();
  if (checkWord(theWord, correctLetters) != true){
   Play();
  }

  if (evt.getSource() == exitButton){
   System.exit(0);
  }

//  if (evt.getSource() == playAgain){
//   removeAll();
//   repaint();
//   
//  }

 }


}