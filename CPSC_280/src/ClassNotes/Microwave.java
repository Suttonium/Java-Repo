package ClassNotes;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Microwave extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Microwave() {
        super("Microwave(TM)");

        setLayout(new BorderLayout());
        add(new JButton("Food Here"), BorderLayout.CENTER);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(new JTextField("Your Time Goes Here"), BorderLayout.NORTH);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4, 3));

        for (String s : new String[] { "1", "2", "3", "4", "5", "6", "7", "8",
                "9", "Start", "0", "Stop" })
            panel2.add(new JButton(s));
        ;

        panel1.add(panel2);
        add(panel1, BorderLayout.EAST);

        pack();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JFrame frame = new Microwave();
        frame.setVisible(true);
    }
}
