package Sorts;

import java.util.Arrays;

public class BubbleSortShown {

	public static void main(String[] args) {
		int[] array = { 15, 3, 9, 7, 19, 8, 1, 5 };
		log("Let's get started on Bubble Sort implementation in Java \n");
		log("============ Ascending Order result:" + Arrays.toString(bubbleSortAscending(array)) + "\n");
		log("============ Descending Order result:" + Arrays.toString(bubbleSortDescending(array)) + "\n");
	}

	// Bubble Sort Algorithm in Ascending Order
	public static int[] bubbleSortAscending(int[] input) {
		int temp;
		for (int i = 0; i < input.length - 1; i++) {

			for (int j = 1; j < input.length - i; j++) {
				if (input[j - 1] > input[j]) {
					temp = input[j - 1];
					input[j - 1] = input[j];
					input[j] = temp;
				}
			}
			log("Iteration " + (i + 1) + ": " + Arrays.toString(input));
		}
		return input;
	}

	// Bubble Sort Algorithm in Descending Order
	public static int[] bubbleSortDescending(int[] input) {
		int temp;
		for (int i = 0; i < input.length - 1; i++) {

			for (int j = 1; j < input.length - i; j++) {
				if (input[j - 1] < input[j]) {
					temp = input[j - 1];
					input[j - 1] = input[j];
					input[j] = temp;
				}
			}
			log("Iteration " + (i + 1) + ": " + Arrays.toString(input));
		}
		return input;
	}

	// Simple log util
	private static void log(String result) {
		System.out.println(result);

	}
}
