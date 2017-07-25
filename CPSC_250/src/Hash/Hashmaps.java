package Hash;

import java.util.HashMap;

/**
 * Basic class to show how Hashmaps work
 * 
 * @author Austin
 *
 */
public class Hashmaps {
	/**
	 * main method to run the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// How to intialize
		HashMap<String, Integer> statePopulation = new HashMap<String, Integer>();
		// String = type of value within hashmap
		// Integer = key to represent the values
		// how to add to a hashmap
		statePopulation.put("CA", 38332521);
		// adds to the hashmap
		statePopulation.put("AZ", 6626624);
		statePopulation.put("MA", 6692824);

		System.out.print("Population of Arizona in 2013 is ");
		System.out.print(statePopulation.get("AZ"));
		// returns the key value to AZ
		System.out.println(".");

		// 2014 estimated population
		statePopulation.put("AZ", 6871809); // updates the value of AZ

		System.out.print("Population of Arizona in 2014 is ");
		System.out.print(statePopulation.get("AZ"));
		// returns the value of the "AZ" key
		System.out.println(".");
	}
}
