package SpaceInvaders;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SI extends JFrame {
    JPanel panel;
    JMenuBar menu;
    JMenu game;
    JMenuItem newGame;
    JMenuItem pause;
    JMenuItem resume;
    JMenuItem quit;
    JMenu help;
    JMenuItem about;
    SIPanel newPanel;

    public SI() {
        super("Space Invaders");
        newPanel = null;
        setSize(500, 450);
        menu = new JMenuBar();
        this.add(menu);
        game = new JMenu("Game");
        menu.add(game);
        newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SIPanel.getTimer().stop();
                askForRestart();
            }
        });
        game.add(newGame);
        game.addSeparator();
        pause = new JMenuItem("Pause");
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SIPanel.getTimer().stop();
            }
        });
        game.add(pause);
        resume = new JMenuItem("Resume");
        resume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SIPanel.getTimer().start();
            }
        });
        game.add(resume);
        game.addSeparator();
        quit = new JMenuItem("Quit");
        game.add(quit);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SIPanel.getTimer().stop();
                askForClosing();
            }
        });
        help = new JMenu("Help");
        about = new JMenuItem("About...");
        help.add(about);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(SI.this,
                        new JLabel(
                                "<html><b>SpaceInvaders</b><br>by Raymond A. Sutton</html>"),
                        "About...", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menu.add(Box.createHorizontalGlue());
        menu.add(help);
        setJMenuBar(menu);
        panel = new SIPanel();
        panel.setBackground(Color.BLACK);
        add(panel);
        createWindowListeners();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    }

    private void askForClosing() {
        int result = JOptionPane.showConfirmDialog(null, "Dare to exit?",
                "Confirm", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
        else {
            SIPanel.getTimer().start();
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    private void askForRestart() {
        int result = JOptionPane.showConfirmDialog(SI.this,
                "Would you like to start a new game?");
        if (result == JOptionPane.YES_OPTION) {
            panel.removeAll();
            panel.setVisible(false);
            newPanel = new SIPanel();
            add(newPanel);
            newPanel.setBackground(Color.BLACK);
        }
        else {
            SIPanel.getTimer().start();
        }
    }

    private void createWindowListeners() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowIconified(WindowEvent e) {
                // System.out.println("going down...");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // System.out.println("Yahoo!!");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                askForClosing();
            }
        });
    }

    public static void main(String[] args) {
        JFrame f = new SI();
        f.setVisible(true);
    }
}
