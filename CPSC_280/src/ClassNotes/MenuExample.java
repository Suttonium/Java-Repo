package ClassNotes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MenuExample extends JFrame {
    public MenuExample() {
        super("Example of a Menu");

        JMenuBar menuBar = new JMenuBar();
        JMenu program = new JMenu("Program");
        menuBar.add(program);
        JMenuItem about = program.add("About...");
        program.addSeparator();
        JMenuItem exit = program.add("Exit");

        JMenu colors = new JMenu("Colors");
        menuBar.add(colors);
        JMenuItem red = colors.add("Red");
        JMenuItem orange = colors.add("Orange");
        JMenuItem yellow = colors.add("Yellow");
        JMenuItem green = colors.add("Green");
        JMenuItem blue = colors.add("Blue");
        JMenuItem cyan = colors.add("Cyan");
        JMenuItem magenta = colors.add("Magenta");

        setJMenuBar(menuBar);
        // need a listern for item

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MenuExample.this,
                        new JLabel(
                                "<html><b> Yeah! app</b><br>by <i>yours truly</i></html>"),
                        "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.RED);
            }
        });

        magenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.MAGENTA);
            }
        });

        orange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.ORANGE);
            }
        });

        yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.YELLOW);
            }
        });

        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.GREEN);
            }
        });

        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.BLUE);
            }
        });

        cyan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.CYAN);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                askForClosing();
            }
        });

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("going down...");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("Yahoo!!!");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                askForClosing();
            }
        });

        setSize(500, 259);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    protected void askForClosing() {
        int result = JOptionPane.showConfirmDialog(this, "Are you a quitter?");
        if (result == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    public static void main(String[] args) {
        JFrame f = new MenuExample();
        f.setVisible(true);
    }
}
