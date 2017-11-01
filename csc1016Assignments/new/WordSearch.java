/*********************************************************
*  WordSearch Program for GUI's                          *
*  Name: Tiro Modibedi                                   *
*  Student Number: MDBTIR001                             *
*  Date: 30-10-2017                                      *
*********************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class WordSearch extends JFrame{
  /*  instance variables  */
  public static final int WIDTH = 600;
  public static final int HEIGHT = 600;

  private JLabel pattern;
  private JLabel matches;

  private JPanel textFieldPanel;
  private JPanel scrollPanePanel;

  private JScrollPane scrollPane;
  private JTextField textField;
  private JTextArea textArea;

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

    /*****  REMOVE THIS CODE LATER  ******/
    //setLayout(new BorderLayout()); // comment out later
    Border outline = BorderFactory.createLineBorder(Color.black);
    /*****  REMOVE THIS CODE LATER  ******/

    /*  Labels  */
    pattern = new JLabel("Pattern");
    matches = new JLabel("Matches");

    /*  Components  */
    textField = new JTextField();
    textArea = new JTextArea();
    scrollPane = new JScrollPane(textArea);

    /*  Panels  */
    textFieldPanel = new JPanel();
    scrollPanePanel = new JPanel();

    /*  jList  */
    list = new JList();
    scrollPane.setViewportView(list);
    listModel = new DefaultListModel();

    /*  set the size of the two Labels  */
    pattern.setPreferredSize(new Dimension(100, 100));
    matches.setPreferredSize(new Dimension(100, 100));

    /*  set the size of the textField   */
    textField.setPreferredSize(new Dimension(200, 50));

    /*  set the size of the textArea   */
    textArea.setPreferredSize(new Dimension(200, 200));

    /*  set the size of the scroll  */
    scrollPane.setPreferredSize(new Dimension(300, 300));
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    /*  Create and add textFieldPanel to the GUI  */
    JPanel textFieldPanel = new JPanel();
    textFieldPanel.setSize(new Dimension(200, 300));
    textFieldPanel.setBorder(outline); // remove
    textFieldPanel.setLayout(new FlowLayout());
    textFieldPanel.add(pattern);
    textFieldPanel.add(textField);
    //add(textFieldPanel, BorderLayout.NORTH);

    /*  Create and add scrollPanePanel to frame   */
    JPanel scrollPanePanel = new JPanel();
    scrollPanePanel.setSize(new Dimension(200, 300));
    scrollPanePanel.setBorder(outline); // remove
    scrollPanePanel.setLayout(new FlowLayout());
    scrollPanePanel.add(matches);
    scrollPanePanel.add(scrollPane);
    //add(scrollPanePanel, BorderLayout.NORTH);

    /********************************BOX LAYOUT********************************/
    JPanel pageAxisPanel = new JPanel();
    //pageAxisPanel.setBorder(outline);
    pageAxisPanel.setLayout(new BoxLayout(pageAxisPanel, BoxLayout.PAGE_AXIS));
    pageAxisPanel.add(textFieldPanel);
    pageAxisPanel.add(scrollPanePanel);

    add(pageAxisPanel);

    textField.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            jTextFieldActionPerformed(evt);
        }
    });

    pack();
  }

  private void jTextFieldActionPerformed(ActionEvent evt) {
      String inputPattern = textField.getText();

      Pattern p = new Pattern(inputPattern);

      if (list.getModel().getSize() != 0) {
        listModel.removeAllElements();
      }

      try {
        WordList wordList = WordList.readFromFile("dictionary.txt");
        for (Word w : wordList) {
          if (p.matches(w)) {
            listModel.addElement(w);
          }
        }
        list.setModel(listModel);
        textField.setText("");
      } catch (Exception e) {
        e.printStackTrace();
      }
  }


  public static void main(String[] args) {
    new WordSearch().setVisible(true);
  }

}
