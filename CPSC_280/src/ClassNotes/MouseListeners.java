package ClassNotes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MouseListeners extends JFrame {

    private static class Square {
        private Color color;
        private Rectangle2D.Double rectangle;

        public Square(int x, int y) {
            rectangle = new Rectangle2D.Double(x, y, 10, 10);
            Random random = new Random();
            color = new Color(random.nextInt(256), random.nextInt(256),
                    random.nextInt(256));
        }

        public void paintMe(Graphics2D g2) {
            g2.setColor(color);
            g2.fill(rectangle);
        }
    }

    public MouseListeners() {
        super("Mouse Rockes, Yeah!");
        add(new JPanel() {
            private Square rectangle = null;
            {
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        rectangle = new Square(e.getX(), e.getY());
                        // x = e.getX();
                        // y = e.getY();
                        repaint();
                    }
                });
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                if (rectangle != null) {
                    rectangle.paintMe(g2);
                }
            }
        });

        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JFrame f = new MouseListeners();
        f.setVisible(true);
    }

}