/*********************************************************
*  WordSearch Program for GUI's                          *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 30-10-2017                                      *
*********************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordSearch extends JFrame{
  // instance variables
  private JLabel pattern;
  private JLabel matches;
  private JPanel textFieldPanel;
  private JPanel scrollPanePanel;
  private JScrollPane jScrollPane;
  private JTextField jTextField;
  private WordList wordList;
  private JList list;
  DefaultListModel listModel;


  // constructor
  public WordSearch(){
    super();
    initialiseComponents();
  }

  private void initialiseComponents() {
    /*  Labels  */
    pattern = new JLabel();
    matches = new JLabel();

    /*  Panels  */
    textFieldPanel = new JPanel();
    scrollPanePanel = new JPanel();

    /*  Fields  */
    jTextField = new JTextField();
    jScrollPane = new JScrollPane();

    /*  JList  */
    list = new JList();
    jScrollPane.setViewportView(list);
    listModel = new DefaultListModel();

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    pattern.setText("Pattern");

    jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    GroupLayout jPanel1Layout = new GroupLayout(textFieldPanel);
    textFieldPanel.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addComponent(pattern, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jTextField, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(pattern, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addContainerGap(19, Short.MAX_VALUE))
    );

    matches.setText("Matches");

    GroupLayout jPanel2Layout = new GroupLayout(scrollPanePanel);
    scrollPanePanel.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addComponent(matches, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jScrollPane)
            .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(matches, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 149, Short.MAX_VALUE))
                .addComponent(jScrollPane))
            .addContainerGap())
    );

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(textFieldPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPanePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(textFieldPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(scrollPanePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    /*
    try {
      WordList wordList = WordList.readFromFile("dictionary.txt");
    } catch (Exception e) {
      e.printStackTrace();
    } */

    // Handle Events
    //PatternMatcher textFieldListener = new PatternMatcher(jTextField, wordList, list);
    //jTextField.addActionListener(textFieldListener);

    jTextField.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            jTextFieldActionPerformed(evt);
        }
    });

    pack();
  }

  private void jTextFieldActionPerformed(ActionEvent evt) {
      //System.out.println(jTextField.getText());
      //jTextField.setText("");
      String inputPattern = jTextField.getText();
      Pattern p = new Pattern(inputPattern);

      if (list.getModel().getSize() != 0) {
        listModel.removeAllElements();
      }

      try {
        WordList wordList = WordList.readFromFile("dictionary.txt");
        for (Word w : wordList) {
          if (p.matches(w)) {
            listModel.addElement(w);
            //System.out.println(w);
          }
        }
        list.setModel(listModel);
        jTextField.setText("");
      } catch (Exception e) {
        e.printStackTrace();
      }
  }


  public static void main(String[] args) {
    new WordSearch().setVisible(true);
  }
}
