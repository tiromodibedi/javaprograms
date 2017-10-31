import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;

public class GUIDemo extends JFrame implements ActionListener {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    JLabel label1;
    JTextField textField;
    JTextArea textArea;

    //Constructor
    public GUIDemo() {
        super("GUI Demo");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(this);

        JMenu moreOptions = new JMenu("More Options");
        JMenuItem nesteItem = new JMenuItem("Nested");

        fileMenu.add(open);

        moreOptions.add(nesteItem);
        fileMenu.add(moreOptions);
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);


        //Set up text input
        textField = new JTextField("Default", 20);
        textArea = new JTextArea("Default", 5, 20);
        //textArea.setLineWrap(true);
        //textArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(textArea);

        //Horizontal Scrollbar options
        //scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //Vertical scrollbar options
        //scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        //scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scroll, BorderLayout.NORTH);

        ImageIcon i = new ImageIcon("happy.png");

        //Set up label
        label1 = new JLabel("Defalt text of the label");
        label1.setIcon(i);
        //label1.setVisible(false);
        add(label1, BorderLayout.CENTER);

        //Create buttons
        JButton button1 = new JButton("Update Label");
        button1.addActionListener(this);

        //Set icon
        button1.setIcon(i);

        add(button1, BorderLayout.SOUTH);

    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Update Label")) {

            label1.setText("Hi there " + textArea.getText() + "!");
        }
    }


    public static void main(String[] args) {
        GUIDemo myGUI = new GUIDemo();
        myGUI.setVisible(true);
    }
}
