package ClassNotes;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Thermometer extends JFrame {
    private int temp;
    private JButton subtract;
    private JButton add;
    private JLabel temperature;
    private JLabel currentTemp;
    private JButton reset;

    public Thermometer() {
        super("Therometer");
        temp = 39;
        subtract = new JButton("-1");
        add(subtract);
        subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(temp <= 35)) {
                    currentTemp.setText("" + --temp);
                }
            }
        });
        temperature = new JLabel("Temperature: ");
        add(temperature);
        currentTemp = new JLabel("" + temp);
        add(currentTemp);
        add = new JButton("+1");
        add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(temp >= 42)) {
                    currentTemp.setText("" + ++temp);
                }
            }
        });
        reset = new JButton("Reset");
        add(reset);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp = 39;
                currentTemp.setText("" + temp);
            }
        });
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFrame f = new Thermometer();
        f.setVisible(true);
    }
}
