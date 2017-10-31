import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;

public class GUIDemo2 extends JFrame implements ActionListener {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    JLabel label;
    JPanel buttonPanel;
    JPanel labelPanel;
    JPanel textInputPanel;
    JTextField textInput;
    JTextArea textAreaInput;


    //Constructor
    public GUIDemo2() {
        super("GUI Demo");
        JMenuBar bar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem item1 = new JMenuItem("Open");
        JMenu item2 = new JMenu("More options");
        JMenuItem item3 = new JMenuItem("Option 1");
        item2.add(item3);
        fileMenu.add(item1);
        fileMenu.add(item2);
        bar.add(fileMenu);
        setJMenuBar(bar);


        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Create two buttons
        JButton button1 = new JButton("Close");
        JButton button2 = new JButton("Open");

        button1.addActionListener(this);
        button2.addActionListener(this);

        //Create a JLabel
        label = new JLabel("Text will be updated here...");
        label.setFont(new Font("Arial", Font.PLAIN, 28));

        //Create a text field
        textInput = new JTextField("Add text here...", 30);
        textAreaInput = new JTextArea("Add text here...", 5, 20);
        //textAreaInput.setLineWrap(true);
        //textAreaInput.setEditable(false);

        JScrollPane j = new JScrollPane(textAreaInput);

        //Create a JPanel to hold my buttons
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        //Create JPanel to hold Label
        labelPanel = new JPanel();
        labelPanel.setLayout(new FlowLayout());

        //Create JPanel to hold text field
        textInputPanel = new JPanel();
        textInputPanel.setLayout(new FlowLayout());


        //Add buttons to JPanel
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        //Add label to panel
        labelPanel.add(label);

        //Add textfield to Jpanel
        //textInputPanel.add(textAreaInput);
        textInputPanel.add(textInput);

        //Add JPanels to JFrame
        add(buttonPanel, BorderLayout.SOUTH);
        add(labelPanel, BorderLayout.CENTER);
        add(textInputPanel, BorderLayout.NORTH);
    }


    public static void main(String[] args) {
        GUIDemo2 myGUI = new GUIDemo2();
        myGUI.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionString = e.getActionCommand();
        if (actionString.equals("Close")) {
            label.setText("Hello " + textInput.getText() + "!");

        } else if (actionString.equals("Open")) {
            label.setText("The open button was clicked!");
            labelPanel.setBackground(Color.GREEN);
        }

    }
}
