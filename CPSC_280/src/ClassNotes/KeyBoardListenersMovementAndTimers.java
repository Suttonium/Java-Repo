package ClassNotes;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class KeyBoardListenersMovementAndTimers extends JFrame {
    private static class Missile {
        private int x, y;

        public Missile(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void moveUp() {
            y -= 5;
        }

        public void paintMe(Graphics2D g2) {
            Rectangle2D.Double r = new Rectangle2D.Double(x, y, 5, 10);
            g2.setColor(Color.RED);
            g2.fill(r);
        }
    }

    private static class XWing {
        private Image img;
        private AudioClip sound;
        private int x, y;

        public XWing(int x, int y) {
            this.x = x;
            this.y = y;
            this.img = getImage("xwing.png");
            this.sound = getSound("xwingSound.wav");
        }

        public void moveXBy(int delta) {
            x += delta;
        }

        public void moveYBy(int delta) {
            y += delta;
        }

        public void paintMe(Graphics2D g2) {
            g2.drawImage(img, x, y, null);
        }

        public void playMeSound() {
            sound.play();
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        private Image getImage(String name) {
            URL file = getClass().getResource(name);
            ImageIcon icon = new ImageIcon(file);
            return icon.getImage();
        }

        private AudioClip getSound(String name) {
            URL file = getClass().getResource(name);
            return Applet.newAudioClip(file);
        }
    }

    private static class KBListenersAndMovingCharactersPanel extends JPanel {
        private boolean up, down, left, right;
        private XWing xwing;
        private Missile missile;

        public KBListenersAndMovingCharactersPanel() {
            xwing = new XWing(300, 35);
            up = down = right = left = false;
            missile = null;
            setFocusable(true);
            Timer timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (left)
                        xwing.moveXBy(-10);
                    if (right)
                        xwing.moveXBy(10);
                    if (up)
                        xwing.moveYBy(-10);
                    if (down)
                        xwing.moveYBy(10);
                    if (missile != null) {
                        missile.moveUp();
                    }
                    repaint();
                }
            });
            timer.start();
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            up = true;
                            break;
                        case KeyEvent.VK_DOWN:
                            down = true;
                            break;
                        case KeyEvent.VK_RIGHT:
                            right = true;
                            break;
                        case KeyEvent.VK_LEFT:
                            left = true;
                            break;
                        case KeyEvent.VK_SPACE:
                            xwing.playMeSound();
                            missile = new Missile(xwing.getX(), xwing.getY());
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            up = false;
                            break;
                        case KeyEvent.VK_DOWN:
                            down = false;
                            break;
                        case KeyEvent.VK_RIGHT:
                            right = false;
                            break;
                        case KeyEvent.VK_LEFT:
                            left = false;
                            break;
                        case KeyEvent.VK_SPACE:
                            xwing.playMeSound();
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            xwing.paintMe(g2);
            if (missile != null) {
                missile.paintMe(g2);
            }
        }
    }

    public KeyBoardListenersMovementAndTimers() {
        super("Flying Letter");
        add(new KBListenersAndMovingCharactersPanel());
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JFrame f = new KeyBoardListenersMovementAndTimers();
        f.setVisible(true);
    }
}
