package Exceptions;

/**
 * basic class to describe the function and purpose of exceptions
 * 
 * @author Austin
 *
 */
public class Exceptions {
	/**
	 * Basic class to create an exception Divinding by zero is not possible to
	 * it throws an exception
	 * 
	 * @return
	 */
	public static int methodA() {
		System.out.println("methodA Running Now... ");
		int divideByZero = 12 / 0;
		System.out.println("Done.");
		return divideByZero;
	}

	/**
	 * Main method to run the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Good Morning");
		try {
			methodA();
		} catch (RuntimeException e) {
			System.out.println("Runtime Rules");
			e.printStackTrace();
			// run program to see a stacktrace!! VERY USEFUL FOR DEBUGGING
			System.out.println();
		} catch (Exception e) {
			System.out.println("Basic Exception");
			// if an exception is caught, the try block ends and goes to the
			// catch
		} finally {
			System.out.println("Goodbye cruel world");
			// finally is always used. Is sort of a clean-up method. It is
			// executed whether or not an exception is caught. It is always
			// the last thing done before the code ends, even if its first.
		}
	}
}
