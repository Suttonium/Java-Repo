package P3;

/// **
// * Test class for SongLibrary.java that assures the program works correctly.
// *
// * @author Austin
// *
// */
// public class SongLibraryTest {
// /**
// * a) The user starts the program. b) The system displays the main window,
// * which has a title, menus and components in their initial state (e.g., the
// * table is empty, the Add button is enabled, the Delete button is disabled,
// * the window is centered and packed and its title is “SongLibrary”).
// */
// @Test
// public void testCaseOneStartingTheProgram() {
// Gooey.capture(new GooeyFrame() {
//
// @Override
// public void invoke() {
// SongLibrary.main(new String[] {});
// }
//
// @Override
// public void test(JFrame frame) {
//
// Dimension expected = frame.getSize();
// frame.pack();
// Dimension actual = frame.getSize();
// assertEquals("Different Sizes", expected, actual);
//
// Point expectedLocale = frame.getLocation();
// frame.setLocationRelativeTo(null);
// Point actualLocale = frame.getLocation();
// assertEquals("Incorrect Position", expectedLocale,
// actualLocale);
//
// assertEquals("", "SongLibrary", frame.getTitle());
// JButton add = Gooey.getButton(frame, "Add");
// assertTrue(add.isEnabled());
// JButton delete = Gooey.getButton(frame, "Delete");
// assertFalse(delete.isEnabled());
//
// JTable table = Gooey.getComponent(frame, JTable.class);
// assertEquals("", 0, table.getRowCount());
// }
// });
// }
//
// /**
// * a) The user selects the menu options SongLibrary & Exit. b) The system
// * displays a confirm dialog with text “Do you want to exit?”. c) The user
// * presses the Yes button. d) The dialog & main window close (in that
// * order). Cancelling closing the program. e) In (c), the user presses
// * either the No or Cancel button. f) The dialog closes but the main window
// * remains open.
// */
// @Test
// public void testCaseTwoClosingTheProgram() {
// Gooey.capture(new GooeyFrame() {
// @Override
// public void invoke() {
// SongLibrary.main(new String[] {});
// }
//
// @Override
// public void test(JFrame frame) {
// JMenuBar menuBar = Gooey.getMenuBar(frame);
// JMenu songLibrary = Gooey.getMenu(menuBar, "SongLibrary");
// JMenuItem exit = Gooey.getMenu(songLibrary, "Exit");
// assertTrue(frame.isShowing());
// songLibrary.doClick();
//
// Gooey.capture(new GooeyDialog() {
// @Override
// public void invoke() {
// exit.doClick();
// }
//
// @Override
// public void test(JDialog dialog) {
// assertEquals("Select an Option", dialog.getTitle());
// Gooey.getLabel(dialog, "Do you want to exit?");
// JButton yes = Gooey.getButton(dialog, "Yes");
// assertTrue(dialog.isShowing());
// yes.doClick();
// assertFalse(dialog.isShowing());
// }
// });
// assertFalse(frame.isShowing());
// }
// });
//
// Gooey.capture(new GooeyFrame() {
// @Override
// public void invoke() {
// SongLibrary.main(new String[] {});
// }
//
// @Override
// public void test(JFrame frame) {
// JMenuBar menuBar = Gooey.getMenuBar(frame);
// JMenu songLibrary = Gooey.getMenu(menuBar, "SongLibrary");
// JMenuItem exit = Gooey.getMenu(songLibrary, "Exit");
// songLibrary.doClick();
//
// Gooey.capture(new GooeyDialog() {
// @Override
// public void invoke() {
// exit.doClick();
// }
//
// @Override
// public void test(JDialog dialog) {
// assertEquals("Select an Option", dialog.getTitle());
// Gooey.getLabel(dialog, "Do you want to exit?");
// JButton no = Gooey.getButton(dialog, "No");
// assertTrue(frame.isShowing());
// assertTrue(dialog.isShowing());
// no.doClick();
// assertFalse(dialog.isShowing());
// exit.doClick();
// }
// });
// assertTrue(frame.isShowing());
// }
// });
// }
//
// /**
// * a) The user selects the menu options SongLibrary & About... b) The system
// * shows a dialog showing the names of the program and the developer. c) The
// * user presses the OK button. d) The dialog closes, returning to the main
// * window
// */
// @Test
// public void testCaseThreeShowingTheAboutDialog() {
// Gooey.capture(new GooeyFrame() {
// @Override
// public void invoke() {
// SongLibrary.main(new String[] {});
// }
//
// @Override
// public void test(JFrame frame) {
// JMenuBar menuBar = Gooey.getMenuBar(frame);
// JMenu songLibrary = Gooey.getMenu(menuBar, "SongLibrary");
// JMenuItem about = Gooey.getMenu(songLibrary, "About...");
// songLibrary.doClick();
//
// Gooey.capture(new GooeyDialog() {
// @Override
// public void invoke() {
// about.doClick();
// }
//
// @Override
// public void test(JDialog dialog) {
// assertEquals("About", dialog.getTitle());
// Gooey.getLabel(dialog,
// "<html><b>SongLibrary </b><br>by Raymond A. Sutton</html>");
// JButton ok = Gooey.getButton(dialog, "OK");
// assertTrue(frame.isShowing());
// assertTrue(dialog.isShowing());
// ok.doClick();
// assertFalse(dialog.isShowing());
// }
//
// });
// assertTrue(frame.isShowing());
// }
// });
// }
//
// /**
// * a) The user selects the menu options Table & Open... b) The system
// * displays a JFileChooser dialog to select a file. c) The user selects an
// * existing file with song information. d) The user presses the Open button.
// * e) The system displays the songs read from the file, updates the window
// * title, and (if the file had entries) enables the Delete button.
// */
// @Test
// public void testCaseFourLoadingAFileWithSongData() {
// Gooey.capture(new GooeyFrame() {
// @Override
// public void invoke() {
// SongLibrary.main(new String[] {});
// }
//
// @Override
// public void test(JFrame frame) {
// JMenuBar menuBar = Gooey.getMenuBar(frame);
// JMenu table = Gooey.getMenu(menuBar, "Table");
// JButton delete = Gooey.getButton(frame, "Delete");
// JMenuItem open = Gooey.getMenu(table, "Open...");
// table.doClick();
//
// Gooey.capture(new GooeyDialog() {
// @Override
// public void invoke() {
// open.doClick();
// }
//
// @Override
// public void test(JDialog dialog) {
// try {
// SwingUtilities.invokeAndWait(new Runnable() {
// @Override
// public void run() {
// JFileChooser choose = Gooey.getComponent(
// dialog, JFileChooser.class);
// File myFile = choose.getSelectedFile();
// choose.setSelectedFile(myFile);
// choose.approveSelection();
// JTable table = Gooey.getComponent(dialog,
// JTable.class);
// if (myFile.length() > 0) {
// assertTrue(delete.isEnabled());
// assertTrue(table.getRowCount() > 0);
// }
// else {
// assertFalse(delete.isEnabled());
// assertFalse(table.getRowCount() > 0);
// }
// assertEquals("", "SongLibrary ["
// + myFile.getAbsolutePath() + "]",
// frame.getTitle());
// }
// });
// }
// catch (InvocationTargetException
// | InterruptedException e) {
// e.printStackTrace();
// }
// }
// });
// }
// });
// }
//
// /**
// * a) The user presses the Add button. b) The system adds an empty row at
// * the end of the table. c) The user types song information in this new row.
// */
// @Test
// public void testCaseFiveAddingASong() {
// Gooey.capture(new GooeyFrame() {
// @Override
// public void invoke() {
// SongLibrary.main(new String[] {});
// }
//
// @Override
// public void test(JFrame frame) {
// JTable table = Gooey.getComponent(frame, JTable.class);
// int rows = table.getRowCount();
// assertEquals(0, rows);
// JButton add = Gooey.getButton(frame, "Add");
// add.doClick();
// rows = table.getRowCount();
// assertEquals(1, rows);
// }
// });
// }
// }
