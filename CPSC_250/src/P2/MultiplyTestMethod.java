package P2;

public class MultiplyTestMethod {
	public static void multiplyArrays(int[][] arrayOne, int[][] arrayTwo) {
		int[][] output = new int[arrayOne.length][arrayTwo[0].length];
		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output[0].length; j++) {
				output[i][j] = 0;
			}
		}

		for (int i = 0; i < arrayOne.length; i++) {
			for (int j = 0; j < arrayTwo[0].length; j++) {
				for (int k = 0; k < arrayOne[0].length; k++) {
					output[i][j] += arrayOne[i][k] * arrayTwo[k][j];
					// System.out.println(output[i][j]);
				}
				System.out.println();
			}
		}
		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output[0].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
		//return output;
	}

	public static void main(String[] args) {
		int[][] arrayOne = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
		int[][] arrayTwo = { { 1, 2, 3 }, { 4, 5, 6 } };

		multiplyArrays(arrayOne, arrayTwo);
	}
}
