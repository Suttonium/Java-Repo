package ClassNotes;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class DrawText extends JFrame {

    private class DrawTextPanel extends JPanel {
        private Font font = new Font("Comic Sans MS", Font.BOLD, 18);

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            String message = "Spring break come back!";
            int pHeight = getHeight();
            int pWidth = getWidth();
            // Font f = new Font("Comic Sans MS", Font.BOLD, 18); //is now the
            // field
            FontMetrics fm = g.getFontMetrics(font);
            int sHeight = fm.getHeight();
            int sDescent = fm.getDescent();
            int sWidth = fm.stringWidth(message);
            float x = (pWidth - sWidth) / 2f;
            float y = pHeight / 2f + (sHeight / 2f - sDescent);
            g.setFont(font);
            g.drawString(message, (int) x, (int) y);
        }

        public void changeFont(String string) {
            font = new Font(string, Font.BOLD, 18);
            repaint();
        }

    }

    public DrawText() {
        super("Drawing Text");
        setLayout(new BorderLayout());

        JPanel pTop = new JPanel();
        pTop.add(new JLabel("Font"));
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        String[] fs = ge.getAvailableFontFamilyNames();
        JComboBox<String> fonts = new JComboBox<>(fs);

        pTop.add(fonts);

        pTop.add(new JLabel("Size"));
        JSpinner sp = new JSpinner(new SpinnerNumberModel(18, 5, 1000, 5));

        add(pTop, BorderLayout.NORTH);

        DrawTextPanel p = new DrawTextPanel();
        add(p, BorderLayout.CENTER);

        sp.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sp.getValue();
            }
        });

        fonts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = fonts.getSelectedIndex();
                p.changeFont(fs[i]);
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JFrame frame = new DrawText();
        frame.setVisible(true);
    }
}
