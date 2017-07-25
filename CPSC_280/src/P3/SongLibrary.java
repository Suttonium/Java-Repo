package P3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * This program creates a song library that allows the user to add, modify,
 * remove, save, and read songs from a CSV text file.
 * 
 * @author Austin
 * @version 20171403
 */
@SuppressWarnings("serial")
public class SongLibrary extends JFrame {
    private JMenuBar menuBar;
    private JMenu songLibrary;
    private JMenuItem about;
    private JMenuItem exit;
    private JMenu tableItem;
    private JMenuItem newItem;
    private JMenuItem open;
    private JMenuItem save;
    private Box box;
    private JButton add;
    private JButton delete;
    private Vector<Vector<String>> DATA;
    private Vector<String> HEADERS;
    private DefaultTableModel tableModel;
    private JTable table;
    private JPanel panel;

    /**
     * This constructor adds the JScollPane values to the pane, sets the layout
     * the a border layout, creates and adds the JMenuBar with all included
     * items, adds the window options, creates and add the JButtons for the GUI,
     * and intializes all of the basic functions needed for this table
     */
    public SongLibrary() {
        super("SongLibrary");
        createLayout();
        addOptionsToPane();
        createMenuBar();
        windowListener();
        createRightBox();
        createTable();
        addBasicFunctions();
    }

    /**
     * sets the border layout to this
     */
    private void createLayout() {
        this.setLayout(new BorderLayout());
    }

    /**
     * adds "basic functions" including resizble, pack, location, and close
     * operation
     */
    private void addBasicFunctions() {
        this.pack();
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    /**
     * adds the headers for the panel
     */
    private void addOptionsToPane() {
        HEADERS = new Vector<String>();
        HEADERS.add("Song");
        HEADERS.add("Artist");
        HEADERS.add("Album");
        HEADERS.add("Year");
    }

    /**
     * creates and adds the JMenuBar
     */
    private void createMenuBar() {
        menuBar = new JMenuBar();
        this.add(menuBar);
        addMenuBarSongLibraryOptions(menuBar);
        addMenuBarTableOptions(menuBar);
        this.setJMenuBar(menuBar);
    }

    /**
     * creates the menu item "SongLibrary" and adds its menu items
     * 
     * @param menuBar
     *            the JMenuBar which is being added too
     */
    private void addMenuBarSongLibraryOptions(JMenuBar menuBar) {
        songLibrary = new JMenu("SongLibrary");
        menuBar.add(songLibrary);
        about = new JMenuItem("About...");
        songLibrary.add(about);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent aboutAction) {
                JOptionPane.showMessageDialog(SongLibrary.this,
                        new JLabel(
                                "<html><b>SongLibrary </b><br>by Raymond A. Sutton</html>"),
                        "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        songLibrary.addSeparator();
        exit = new JMenuItem("Exit");
        songLibrary.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                askForClosing();
            }
        });
    }

    /**
     * creates the menu item "Table" and adds its menu items
     * 
     * @param menuBar
     *            the JMenuBar which is being added too
     */
    private void addMenuBarTableOptions(JMenuBar menuBar) {
        tableItem = new JMenu("Table");
        menuBar.add(tableItem);
        newItem = new JMenuItem("New");
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTable();
                delete.setEnabled(false);
            }
        });
        tableItem.add(newItem);
        open = new JMenuItem("Open...");
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent openAction) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFileChooser chooser = new JFileChooser();
                        int result = chooser.showOpenDialog(SongLibrary.this);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File file = chooser.getSelectedFile();
                            readCSVFile(file);
                        }
                    }
                });
            }
        });
        tableItem.add(open);
        save = new JMenuItem("Save As...");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent saveAction) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFileChooser chooser = new JFileChooser();
                        int result = chooser.showSaveDialog(SongLibrary.this);

                        if (result == JFileChooser.APPROVE_OPTION) {
                            try {
                                File file = chooser.getSelectedFile();
                                PrintWriter writer = new PrintWriter(
                                        file + ".txt");
                                for (int i = 0; i < table.getRowCount(); i++) {
                                    for (int j = 0; j < table
                                            .getColumnCount(); j++) {
                                        writer.print(table.getValueAt(i, j));
                                        if (j < 3) {
                                            writer.print(", ");
                                        }
                                    }
                                    writer.println();
                                }
                                writer.close();
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
        tableItem.add(save);
    }

    /**
     * clears the table
     */
    private void clearTable() {
        int result = JOptionPane.showConfirmDialog(this,
                "Clear all table data?");
        if (result == JOptionPane.YES_OPTION) {
            DefaultTableModel dm = (DefaultTableModel) table.getModel();
            while (dm.getRowCount() > 0) {
                dm.removeRow(0);
            }
            delete.setEnabled(true);
        }
        else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    /**
     * reads the CSV file and imports the data into the table
     * 
     * @param file
     *            file to be read
     */
    private void readCSVFile(File file) {
        delete.setEnabled(false);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<String[]> elements = new ArrayList<String[]>();
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                elements.add(split);
                if (split[0].equals("")) {
                    delete.setEnabled(false);
                }
                else {
                    delete.setEnabled(true);
                }
            }
            reader.close();
            DATA = new Vector<Vector<String>>();
            for (int i = 0; i < elements.size(); i++) {
                DATA.add(new Vector<String>());
            }
            for (int i = 0; i < DATA.size(); i++) {
                for (int j = 0; j < elements.size() + 1; j++) {
                    DATA.get(i).add(elements.get(i)[j]);
                }
                // System.out.println(DATA.toString());
            }
            table.setModel(new DefaultTableModel(DATA, HEADERS));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        String s = "SongLibrary [" + file.getAbsolutePath() + "]";
        this.setTitle(s);
    }

    /**
     * If the user selects yes, the program is ended. If the user selects no,
     * the dialog box is exited and the program is continued
     */
    private void askForClosing() {
        int result = JOptionPane.showConfirmDialog(this,
                "Do you want to exit?");
        if (result == JOptionPane.YES_OPTION) {
            dispose();
        }
        else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    /**
     * adds a window listener used to exit the program if the red circle is hit
     */
    private void windowListener() {
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

    /**
     * creates the rightmost box used for holding the add and delete buttons
     */
    private void createRightBox() {
        box = Box.createVerticalBox();
        add = new JButton("Add");
        delete = new JButton("Delete");
        box.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel dm = (DefaultTableModel) table.getModel();
                dm.addRow(new String[] { "", "", "", "" });
                delete.setEnabled(true);
            }
        });
        box.add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent deleteAction) {
                DefaultTableModel dm = (DefaultTableModel) table.getModel();
                int[] rows = table.getSelectedRows();
                if (rows.length == 0) {
                    JOptionPane.showMessageDialog(SongLibrary.this,
                            new JLabel("No row selected"));
                }
                dm.removeRow(table.getSelectedRow());
            }
        });
        delete.setEnabled(false);
        this.add(box, BorderLayout.EAST);
    }

    /**
     * creates the table
     */
    private void createTable() {
        panel = new JPanel(); // create the sheet to put shit on
        panel.setLayout(new BorderLayout()); // make it shape to the border of
                                             // the frame
        tableModel = new DefaultTableModel(DATA, HEADERS); // add DATA and
                                                           // HEADERS to the
                                                           // model
        table = new JTable(tableModel); // add this model to the table to make
                                        // it pop up
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true); // fills frame
        JScrollPane scroller = new JScrollPane(table); // make a scroller so the
                                                       // table can scroll
        panel.add(scroller, BorderLayout.CENTER); // sets layout to center and
                                                  // adds it to the "sheet"
        this.add(panel); // add the "sheet" and everything on it to the frame
    }

    /**
     * main method for creating the GUI
     * 
     * @param args
     *            unused
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new SongLibrary();
                f.setVisible(true);
            }
        });
    }
}
