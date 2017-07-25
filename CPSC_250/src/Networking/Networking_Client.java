package Networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Networking_Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("10.129.43.108", 3456);
			System.out.println("Got the server socket ...");
			InputStream inStream = socket.getInputStream();
			Scanner in = new Scanner(inStream);
			System.out.println("Got the server inputStream ...");
			OutputStream outStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outStream, true);
			System.out.println("Created the client outputStream ...");
			Scanner keyboard = new Scanner(System.in);

			System.out.println("Process the inputs ...");
			while (in.hasNext()) {
				String str = in.nextLine();
				System.out.printf("    echo >> %s\n", str);

				str = keyboard.nextLine();
				out.println(str);
			}
			in.close();
			keyboard.close();
			socket.close();
		} catch (IOException e) {
		}
		System.out.println("closing...");
	}
}
