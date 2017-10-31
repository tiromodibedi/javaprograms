import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.IOException;
public class TestFrame
{
   private JFrame jframe;
   private JTextField textField;
   private JLabel label;
   private JLabel label2;
   private JPanel panel;
   private JPanel panel2;
   private JTextArea textArea;
   private JScrollPane scroll;
   private JList jList;
   DefaultListModel dataModel;

   public TestFrame(){
      jframe = new JFrame("Word Puzzel Solver");
      jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jframe.setSize(500,500);
      jframe.setLayout(new FlowLayout());

      label = new JLabel("Pattern");
      label.setPreferredSize(new Dimension(100,100));
      label2 = new JLabel("Matches");
      label2.setPreferredSize(new Dimension(100,100));
      //Text field
      textField = new JTextField();
      textField.setPreferredSize(new Dimension(200,50));


      panel = new JPanel();
      panel.setSize(new Dimension(200,300));
      panel.setLayout(new FlowLayout());
      panel.add(label);
      panel.add(textField);
      jframe.add(panel);
      jframe.setVisible(true);
      jframe.setVisible(true);

      //Text field 2
      JList jList = new JList();
      textArea = new JTextArea(10,20);
      textArea.add(jList);
      scroll = new JScrollPane(textArea);
      scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
     // scroll.setViewportView(jList);
      panel2 = new JPanel();
      panel2.setSize(new Dimension(200,300));
      panel2.setLayout(new FlowLayout());
      panel2.add(label2);
      panel2.add(scroll);
      jframe.add(panel2);
      jframe.setVisible(true);
      jframe.setVisible(true);

      dataModel = new DefaultListModel();

  		Things x = new Things();
      textField.addActionListener(x);

   }
   private class Things implements ActionListener
   {
      @Override
      public void actionPerformed(ActionEvent event){

        try{
            String word = textField.getText();
            Pattern pat = new Pattern((word));
            WordList list = WordList.readFromFile("dictionary.txt");
            WordList matchWords = list.match(pat);
            //DefaultListModel dataModel = new DefaultListModel();
            for (Word x: matchWords){
               System.out.println(x);
               dataModel.addElement(x);
            }
            jList.setModel(dataModel);
         }catch(IOException e){
           e.printStackTrace();
         }


        // Pattern pat = new Pattern(word);
         //System.out.println(word);
      }
   }
   public static void main (String [] args)
   {
      TestFrame things = new TestFrame();
   }
}
