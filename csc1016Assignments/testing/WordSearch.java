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
  /*  instance variables  */
  public static final int WIDTH = 600;
  public static final int HEIGHT = 600;

  private JLabel pattern;
  private JLabel matches;

  private JPanel textFieldPanel;
  private JPanel scrollPanePanel;

  private JScrollPane jScrollPane;
  private JTextField jTextField;

  private WordList wordList;
  private JList list;
  DefaultListModel listModel;

  /*  constructor  */
  public WordSearch(){
    super();
    initialiseComponents();
  }

  public void initialiseComponents(){
    setSize(WIDTH, HEIGHT);
    setTitle("Word Puzzle Solver");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    /*  Labels  */
    pattern = new JLabel();
    matches = new JLabel();

    /*  Panels  */
    textFieldPanel = new JPanel();
    scrollPanePanel = new JPanel();

    /*  Fields  */
    jTextField = new JTextField();
    jScrollPane = new JScrollPane();

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

    BoxLayout boxLayout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS); // top to bottom
    setLayout(boxLayout);
    add(new JButton("Button 1"));
    add(new JButton("Button 2"));
    add(new JButton("Button 3"));
    pack();

    //setVisible(true);

  }

  public static void main(String[] args) {
    new WordSearch().setVisible(true);
  }

}
