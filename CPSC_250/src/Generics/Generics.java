package Generics;

import java.util.ArrayList;

/**
 * Basic class to showcase how generics work
 * 
 * @author Austin
 *
 * @param <Type>
 *            - Generic typing
 */
public class Generics<Type> {
	// generics let more than one type be a possible type for a class
	private Type one;
	private Type two;

	public Generics(Type x, Type y) {
		one = x;
		two = y;
	}

	public Type getOne() {
		return one;
	}

	public Type getTwo() {
		return two;
	}

	@Override
	public String toString() {
		String finale = "One: " + getOne() + " Two: " + getTwo();
		return finale;
	}

	/**
	 * main method to run the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// integer pair using generics
		Generics<Integer> intPair = new Generics<Integer>(1, 2);
		// double pair using generics
		Generics<Double> doublePair = new Generics<Double>(3.14159, 2.7182);
		// String pair using generics
		Generics<String> stringPair = new Generics<String>("Hello", "World");
		// Character pair using generics
		Generics<Character> charPair = new Generics<Character>('X', 'Y');

		ArrayList<Object> myList = new ArrayList<Object>();
		// use the 'Object' typing when using ArrayLists and generics
		myList.add(intPair);
		myList.add(doublePair);
		myList.add(stringPair);
		myList.add(charPair);

		for (int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i).toString());
		}
	}
}
