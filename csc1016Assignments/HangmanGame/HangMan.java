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

/*import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;*/

public class HangMan {

/*
  private String[] wordList = { "computer", "java", "activity", "alaska",
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
          "terrible", "traffic", "unusual", "volume", "yesterday" }; */

  private String[] wordList = getWordsArray();

  public String[] getWordsArray(){
    try {
      wordList = WordList.readFromFile("dictionary.txt");
    } catch (Exception e) {
      e.printStackTrace();
    }
    int listLength = wordList.size(); // num of words
    String[] wordsArray = new int[listLength]; // wordsArray
    int i = 0;
    for (Word w : wordList) {
      wordsArray[i] = w;
      i++;
    }
    //level = (int) (Math.random() * listLength); // random number
    return wordsArray;
  }

  private JTextField textField;
  private JLabel lettersUsed;
  static String inputLetter;
  static int[] wordsArray = new int[64];
  static int level = (int) (Math.random() * 64);// random word
  static JFrame frame = new JFrame();
  static ImageIcon bg = new ImageIcon("state1.GIF");
  JLabel img = new JLabel(bg, JLabel.CENTER);

  public void window() {
      bg = new ImageIcon("state1.GIF");
      img.setIcon(bg);

      JFrame gameFrame = new JFrame();
      JPanel bottomRight = new JPanel();
      JPanel bottomLeft = new JPanel();
      JPanel top = new JPanel();
      JPanel bottom = new JPanel();
      JPanel imgPane = new JPanel();
      JPanel panel1 = new JPanel();
      bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
      imgPane.setLayout(new BorderLayout());
      panel1.setLayout(new BorderLayout());
      panel1.setOpaque(false);// !!
      top.setBorder(BorderFactory.createTitledBorder(""));
      bottom.setBorder(BorderFactory.createTitledBorder(""));
      textField = new JTextField(1);
      JLabel jl = new JLabel("Enter a inputLetter", JLabel.CENTER);
      lettersUsed = new JLabel("Letters used:  ", JLabel.CENTER);
      final JLabel jlLines = new JLabel("__ ", JLabel.CENTER);
      jl.setFont(new Font("Rockwell", Font.PLAIN, 20));
      textField.setFont(new Font("Rockwell", Font.PLAIN, 20));
      lettersUsed.setFont(new Font("Rockwell", Font.PLAIN, 20));
      jlLines.setFont(new Font("Rockewell", Font.PLAIN, 20));
      imgPane.add(img);// center
      top.add(jl);// top center
      top.add(textField);// top center
      bottomLeft.add(lettersUsed);// bottom left position
      bottomRight.add(jlLines);// bottom right position
      bottom.add(bottomLeft);// bottom
      bottom.add(bottomRight);// bottom
      panel1.add(imgPane, BorderLayout.CENTER);// background image (center)
      panel1.add(top, BorderLayout.NORTH);// text field and jlabel (top)
      panel1.add(bottom, BorderLayout.SOUTH);// blank spaces and letters used

      gameFrame.setTitle("Hangman");
      gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      gameFrame.setResizable(false);
      gameFrame.add(panel1);
      gameFrame.setSize(800, 500);
      gameFrame.setLocationRelativeTo(null);
      gameFrame.setVisible(true);

      int j = 0;
      String line = "";
      for (j = 0; j < 64; j++) {
          wordsArray[j] = wordList[j].length();// gets length of words
      }// end for
      int m = 0;
      // creates line first then put into .setText
      while (m < wordsArray[level]) {
          line += "__ ";
          m++;
      }// end for
      jlLines.setText(line);

      textField.addActionListener(new ActionListener() {
          int wrong = 0;
          int right = 0;

          @Override
          public void actionPerformed(ActionEvent e) {// enter key
              JTextField textField = (JTextField) e.getSource();
              inputLetter = textField.getText();
              textField.setText("");

              lettersUsed.setText(lettersUsed.getText() + inputLetter + " ");// sets
                                                                      // jlabel
                                                                      // text
                                                                      // to
                                                                      // users
                                                                      // entered
                                                                      // inputLetter
              char[] jlabelText = jlLines.getText().toCharArray();// converts
                                                                  // string to
                                                                  // character
                                                                  // array
                                                                  // (array is
                                                                  // length of
                                                                  // string)
              char userEnteredChar = inputLetter.charAt(0);
              // System.out.println(wordList[level]);
              if (!wordList[level].contains(inputLetter)) {
                  wrong++;
                  if (wrong == 1) {
                      bg = new ImageIcon("state2.GIF");
                      img.setIcon(bg);
                  }
                  if (wrong == 2) {
                      bg = new ImageIcon("state3.GIF");
                      img.setIcon(bg);
                  }
                  if (wrong == 3) {
                      bg = new ImageIcon("state4.GIF");
                      img.setIcon(bg);
                  }
                  if (wrong == 4) {
                      bg = new ImageIcon("state5.GIF");
                      img.setIcon(bg);
                  }
                  if (wrong == 5) {
                      bg = new ImageIcon("state6.GIF");
                      img.setIcon(bg);
                  }
                  if (wrong == 6) {
                      bg = new ImageIcon("state7.GIF");
                      img.setIcon(bg);
                  }
                  if (wrong == 6) {
                      JOptionPane
                              .showMessageDialog(frame, "He's dead." + "\n"
                                      + "Press 'OK' to restart." + "\n"
                                      + "The word was " + wordList[level]
                                      + ".", "You Lost",
                                      JOptionPane.INFORMATION_MESSAGE);
                      HangMan restart = new HangMan();
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
                          JOptionPane.INFORMATION_MESSAGE/*, logo*/);
                  HangMan restart = new HangMan();
                  level = (int) (Math.random() * 64);
                  restart.window();
              }
          }// end actionPerformed method
      });
  }// end window method

  public static void main(String[] args) {
    HangMan game = new HangMan();
    game.window();
  }
}
