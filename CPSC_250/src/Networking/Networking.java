package Networking;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Basic class that reads from a server socket and implements methods.
 * Networking is very similar to FileIO
 * 
 * @author Austin
 *
 */
public class Networking {
	/**
	 * Basic method to calculate the SUM of an ArrayList
	 * 
	 * @param list
	 *            - the ArrayList holding the stored values from the server
	 * @return the SUM of every value in the ArrayList
	 */
	public static int SUM(ArrayList<Integer> list) {
		int SUM = 0;
		for (int i = 0; i < list.size(); i++) {
			SUM += list.get(i);
		}
		return SUM;
	}

	/**
	 * Basic method to calculate the AVERAGE of an ArrayList
	 * 
	 * @param list
	 *            - the ArrayList holding the stored values from the server
	 * @return the AVERAGE value of the ArrayList
	 */
	public static double AVERAGE(ArrayList<Integer> list) {
		double count = 0;
		double SUM = 0;
		for (int i = 0; i < list.size(); i++) {
			SUM += list.get(i);
			count++;
		}
		double AVERAGE = SUM / count;
		return AVERAGE;
	}

	/**
	 * Basic method to determine the size of the ArrayList
	 * 
	 * @param list
	 *            - the ArrayList holding the stored values from the server
	 * @return the size of the ArrayList
	 */
	public static int COUNT(ArrayList<Integer> list) {
		return list.size();
	}

	/**
	 * main method to run the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(2345);
			// intialize the server socket
			Socket client = server.accept();
			// accept what is being sent from the server
			Scanner clientScanner = new Scanner(client.getInputStream());
			// create a scanner to read the server
			PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
			// create a PrintWriter to send the new values back to the server
			String string = clientScanner.nextLine();
			// the first line in the server
			ArrayList<Integer> list = new ArrayList<Integer>();
			// intialize an ArrayList to store the values taken from the server
			Scanner stringScanner = new Scanner(string);
			// create a scanner to read the line
			while (stringScanner.hasNext()) {
				// while scanner has a next value
				String method = stringScanner.next();
				// variable to figure out what above methdo to call
				Integer x = 0;
				while (stringScanner.hasNextInt()) {
					x = stringScanner.nextInt();
					list.add(x);
				}
				if (method.equals("SUM")) {
					// calls the SUM method
					writer.println(SUM(list));
				} else if (method.equals("AVERAGE")) {
					// calls the AVERAGE method
					writer.println(AVERAGE(list));
				} else if (method.equals("COUNT")) {
					// calls the COUNT method
					writer.println(COUNT(list));
				}
			}
			server.close(); // close your server
			clientScanner.close(); // close your scanner
			stringScanner.close(); // close your scanner
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
