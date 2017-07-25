package ClassNotes;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonsAndActionListeners extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ButtonsAndActionListeners() {
        super("BMI Calculator");

        setLayout(new GridLayout(2, 1));

        JPanel top = new JPanel(new FlowLayout());
        top.add(new JLabel("Weight (lb)"));
        JTextField weight = new JTextField(10);
        top.add(weight);
        top.add(new JLabel("Height (ft)"));
        JTextField height = new JTextField(10);
        top.add(height);
        JButton button = new JButton("Go");
        top.add(button);

        JPanel bottom = new JPanel(new FlowLayout());
        bottom.add(new JLabel("Index: "));
        JLabel result = new JLabel("");
        bottom.add(result);

        add(top);
        add(bottom);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double w = Double.parseDouble(weight.getText());
                double h = Double.parseDouble(height.getText());
                double r = (w * 4.88) / (h * h);
                result.setText(String.format("%.2f", r));
            }
        });
        pack();

    }

    public static void main(String[] args) {
        JFrame f = new ButtonsAndActionListeners();
        f.setVisible(true);
    }
}
