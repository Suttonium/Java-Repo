package FileIO;

import java.io.File;
import java.util.Scanner;

/**
 * This program reads a file and adds each value read into a 2D array
 * 
 * @author Austin
 *
 */
public class FileIO {
	/**
	 * 
	 * @param fileName
	 *            - the string to create your .txt file
	 * @return the 2D array created from reading the file
	 */
	public static String[][] readArray(String fileName) {

		try { // always need try-catch for FileIO
			System.out.println("Try to load data from " + fileName);
			File file = new File(fileName); // create your new file
			Scanner fin = new Scanner(file); // make a scanner to read the file
			fin.useDelimiter("/t"); // delimiter ignores the parameter

			String sizeLine = fin.nextLine(); // find the first line
			System.out.println("Read < " + sizeLine + ">");
			Scanner sizeScan = new Scanner(sizeLine);
			// create a scanner to read the line
			sizeScan.useDelimiter("\t|r\n|n");

			int height = sizeScan.nextInt();
			// the first variable is the height of the 2D array
			int width = sizeScan.nextInt();
			// the second variable is the width of the 2D array

			System.out.println("Reading array with " + height + " rows and " + width + " columns.");
			sizeScan.close(); // end the scanner because it is no longer needed

			String[][] newArray = new String[height][width];
			// create a 2D array from the height and width
			int rowCount = 0;
			while (fin.hasNextLine()) {
				// while there is another line in the file
				String rowLine = fin.nextLine(); // find the next line
				Scanner rowScan = new Scanner(rowLine);
				// create a scanner for the line
				rowScan.useDelimiter("\t");
				int columnCount = 0;
				while (rowScan.hasNext()) {
					// while the line you're scanning has a next string
					String nextCell = rowScan.next(); // make your variable
					newArray[rowCount][columnCount++] = nextCell;
					// add it into the array you created
				}
				rowScan.close();
				// close the scanner because it is no longer needed
				if (columnCount != newArray[rowCount].length) {
					System.out.println("Invalid data on row " + rowCount);
					// column not finished checker
					fin.close();
					return newArray;
				}
				rowCount++;
			}
			if (rowCount != newArray.length) {
				System.out.println("Invalid data rows mismatch = " + rowCount);
				// line not finished checker
				fin.close();
				return newArray;
			}
			fin.close(); // close the scanner for the file
			return newArray; // return your new 2D array
		} catch (Exception e) { // if an exception is caught
			// do something here
			return null; // return nothing(null)
		}
	}
}
