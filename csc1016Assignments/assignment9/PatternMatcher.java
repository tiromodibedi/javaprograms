/*********************************************************
*  Pattern Matcher Program to search text patterns       *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 30-10-2017                                      *
*********************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PatternMatcher implements ActionListener{
  /*  indtance variables  */
  private JTextField userInputField;
  private JList list;
  private WordList wordList;
  DefaultListModel listModel;

  /*  Constructor  */
  public PatternMatcher(JTextField userInputField, WordList wordlist, JList searchOutputList){
    this.userInputField = userInputField;
    this.wordList = wordList;
    this.list = searchOutputList;
  }

  /*  Methods */
  public void actionPerformed(ActionEvent e){
    System.out.println(userInputField.getText());
    //userInputField.setText("");

    String inputPattern = userInputField.getText();

    Pattern p = new Pattern(inputPattern);
    try {
      WordList words = WordList.readFromFile("dictionary.txt");
      for (Word w : words) {
        if (p.matches(w)) {
          listModel.addElement(w);
          //System.out.println(w);
        }
      }
      list.setModel(listModel);
      userInputField.setText("");
    } catch (Exception error) {
      error.printStackTrace();
    }
  }
}
