package P2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Matrix {
    public static int cnt = 0;
	public static File multiply(File file1, File file2) {
		String fileName = String.format("output_%d.txt",cnt++);
		File outputFile = new File(fileName); // initiates an output file
		try {
			Scanner fileOneScanner = new Scanner(file1); // scanner to scan the input file
			fileOneScanner.useDelimiter("/t|x"); // ignores tabs
			Scanner fileTwoScanner = new Scanner(file2); // scanner to scan the input file
			PrintWriter myWriter = new PrintWriter(outputFile); //writer to write array to file
			
			
			//file1Info
			String arrayOneLine = fileOneScanner.nextLine(); // setting first line of file 1 to a string
			Scanner fileOneLineOne = new Scanner(arrayOneLine); // setting scanner to figure out height and width
			String[] dimensions1 = arrayOneLine.split("x");
			int arrayOneHeight = Integer.parseInt(dimensions1[0]); // height of file 1
			int arrayOneWidth =  Integer.parseInt(dimensions1[1]);// width of file 
			int [][] fileOneArray = new int[arrayOneHeight][arrayOneWidth]; // intializing file 1 array
			
			
			//file2Info
			String arrayTwoLine = fileTwoScanner.nextLine(); //setting first line of file 2 to a string 
			Scanner fileTwoLineOne = new Scanner(arrayTwoLine); // setting scanner to scan for height and width
			String[] dimensions2 = arrayTwoLine.split("x");
			int arrayTwoHeight = Integer.parseInt(dimensions2[0]); // height of file 2
			int arrayTwoWidth = Integer.parseInt(dimensions2[1]); // width of file 2
			int [][] fileTwoArray = new int[arrayTwoHeight][arrayTwoWidth]; // intializing file 2 array
			
			
			//setting file1 elements to the array
			int rowCountFile1 = 0;
			while (fileOneScanner.hasNextLine()) {
				int indexNumberFile1 = 0;
				String lineElementsFile1 = fileOneScanner.nextLine(); // set next line to a string for scanning
				Scanner fileOneElementScanner = new Scanner(lineElementsFile1);  // scanner for the next line
				while(fileOneElementScanner.hasNextInt()) {
					int nextCellFile1 = fileOneElementScanner.nextInt(); // next number on the row is a variable to be added
					fileOneArray[rowCountFile1][indexNumberFile1++] = nextCellFile1; // each index of each array in the file is assigned to a value
				}
				rowCountFile1++; //incremenet row count after a row is filled 
				fileOneElementScanner.close();
			}
			System.out.println("Printing Array 1"); // prints out the values to terminal for checking
			for (int i = 0; i < fileOneArray.length; i++) {
				for (int j = 0; j < fileOneArray[0].length; j++) {
					System.out.print(fileOneArray[i][j] + " ");
				}
				System.out.println();
			}
			fileOneLineOne.close();
			
			
			//setting file2 elements to the array
			int rowCountFile2 = 0;
			while(fileTwoScanner.hasNextLine()) {
				int indexNumberFile2 = 0;
				String lineElementsFile2 = fileTwoScanner.nextLine(); // set next line to a string for scanning
				Scanner fileTwoElementScanner = new Scanner(lineElementsFile2); //scanner for the next line
				while(fileTwoElementScanner.hasNextInt()) {
					int nextCellFile2 = fileTwoElementScanner.nextInt(); // next number on the row is a variable to be added
					fileTwoArray[rowCountFile2][indexNumberFile2++] = nextCellFile2; // each index of each array in the file is assigned
				}
				rowCountFile2++; // incremenet row count after a row is filled
				fileTwoElementScanner.close();
			}
			System.out.println("Printing Array 2");
			for (int i = 0; i < fileTwoArray.length; i++) {
				for (int j = 0; j < fileTwoArray[0].length; j++) {
					System.out.print(fileTwoArray[i][j] + " ");
				}
				System.out.println();
			}
			fileTwoLineOne.close();
			
			
			//information to output multiplied arrays to an output file
			int[][] outputArray = new int[arrayOneHeight][arrayTwoWidth]; //new array values will be put into
			if (fileOneArray[0].length != fileTwoArray.length) {
				myWriter.close();
				fileOneScanner.close();
				fileTwoScanner.close();
				throw new IllegalMultiplicationException();
			}
			
			
			//multiplies the array 
			for (int i = 0;i < fileOneArray.length; i++) {
				for (int j = 0;j< fileTwoArray[0].length;j++) {
					for (int k =0;k<fileOneArray[0].length;k++) {
						outputArray[i][j] += fileOneArray[i][k] * fileTwoArray[k][j];
					}
				}
			}
			
			
			 //prints the array to the output file
			myWriter.println(outputArray.length + "x" + outputArray[0].length);
			for (int i =0;i<outputArray.length;i++) {
				for (int j =0;j<outputArray[0].length;j++) {
					myWriter.print(outputArray[i][j] + " ");
				}
				myWriter.println();
			}
			myWriter.close();
			fileOneScanner.close();
			fileTwoScanner.close();
			return outputFile;
			
			
		} catch (FileNotFoundException e) {
			return null;
		} catch(InputMismatchException e) {
			return null;
		}
	}
}
