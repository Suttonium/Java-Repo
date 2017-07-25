package Hash;

import java.util.HashSet;

/**
 * Basic class to show how HashSets work
 * 
 * @author Austin
 *
 */
public class Hashsets {
	/**
	 * main method to run the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// How to initalize
		HashSet<String> ownedBooks = new HashSet<String>();

		ownedBooks.add("A Tale of Two Cities"); // adds to the set
		ownedBooks.add("The Lord of the Rings"); // .add() will not duplicate
		System.out.println("Contains \"A Tale of Two Cities\": " + ownedBooks.contains("A Tale of Two Cities"));
		// .contains() will return true or false
		ownedBooks.remove("The Lord of the Rings"); // removes from the set
		System.out.println("Contains \"The Lord of the Rings\": " + ownedBooks.contains("The Lord of the Rings"));
	}
}
