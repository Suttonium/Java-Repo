package Networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Networking_Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(3456);
			System.out.println("Awaiting client...");
			Socket client = server.accept();
			System.out.println("Client connected...");

			Scanner in = new Scanner(client.getInputStream());
			System.out.println("Got the client inputStream...");

			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			System.out.println("Created the client outputStream...");
			out.println("Hello! To quit, just type 'BYE'!");

			System.out.println("Ready to process client messages...");
			Scanner scnr = new Scanner(System.in);
			while (in.hasNext()) {
				String message = in.nextLine();
				System.out.println("client >> " + message);

				String msg = scnr.nextLine();
				out.println(msg);
				if (message.toUpperCase().equals("BYE")) {
					System.out.println("Processed BYE command...");
					out.println("Goodbye!");
					break;
				}
			}
			scnr.close();
			client.close();
			System.out.println("Client gone...");
			server.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Server out...");
	}
}
