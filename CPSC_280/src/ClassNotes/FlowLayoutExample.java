package ClassNotes;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FlowLayoutExample extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public FlowLayoutExample() {
        super("My Window");
        // set layout to allign left with 10 x 8 pixels
        // setLayout(new FlowLayout(FlowLayout.LEFT, 10, 8));
        setLayout(new GridLayout(3, 2));

        // adds text to the window saying "First Name"
        JLabel firstLabel = new JLabel("First Name");
        add(firstLabel);
        // adds an input box
        JTextField firstName = new JTextField(20);
        add(firstName);

        JLabel middleLabel = new JLabel("MI");
        add(middleLabel);
        JTextField middleName = new JTextField(3);
        add(middleName);

        JLabel lastLabel = new JLabel("Last Name");
        add(lastLabel);
        JTextField lastName = new JTextField(20);
        add(lastName);

        pack();

        // ends program on closing of window
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // no relative location
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        JFrame frame = new FlowLayoutExample();
        frame.setVisible(true);
    }
}
