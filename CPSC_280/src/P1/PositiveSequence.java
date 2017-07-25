package P1;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * The purpose of this program is to analyze a sequence of four numbers and fill
 * in the missing value denoted by a "-1"
 * 
 * @author Austin
 *
 */
public class PositiveSequence {
    /**
     * This class calls various classes throughout the program to determine if
     * the given sequence is arithmetic, geometric, neither, or presents an
     * error in the program
     * 
     * @param a
     *            the first value in the sequence
     * @param b
     *            the second value in the sequence
     * @param c
     *            the third value in the sequence
     * @param d
     *            the fourth value in the sequence
     * @exception IllegalArgumentException
     *                thrown whenever a list is not sorted from least to
     *                greatest, there is more than one -1, there are values less
     *                than zero, other than -1, and if there is a 0.
     * @exception NoSuchElementException
     *                thrown if there is no -1 value in the sequence
     * @return the missing value denoted by a "-1"
     */
    public static int process(int a, int b, int c, int d) {
        int[] array = { a, b, c, d };

        int missingValue = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < -1 || array[i] == 0) {
                throw new IllegalArgumentException();
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                count++;
            }
        }
        if (count == 0) {
            throw new NoSuchElementException();
        }

        if (count > 1) {
            throw new IllegalArgumentException();
        }
        for (int j = 0; j < array.length; j++) {
            if (array[j] == -1) {
                missingValue = arithmeticOrGeometric(array);
            }
        }

        return missingValue;
    }

    /**
     * This method determines if the sequence is arithmetic or geometric
     * 
     * @param array
     *            an array of the initial four values within the process method
     * @return the missing value within the sequence
     */
    private static int arithmeticOrGeometric(int[] array) {
        int missingValue = 0;
        int A = array[0];
        int B = array[1];
        int C = array[2];
        int D = array[3];

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(A);
        list.add(B);
        list.add(C);
        list.add(D);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == -1) {
                list.remove(list.get(i));
            }
        }
        isSorted(list);

        double a = array[0];
        double b = array[1];
        double c = array[2];
        double d = array[3];

        if (a == -1) {
            if (d / c == c / b) {
                missingValue = geometric(array);
            }
            else if (d - c == c - b) {
                missingValue = arithmetic(array);
            }
            else {
                missingValue = -1;
            }
        }

        else if (b == -1) {
            if (a * (d / c) == c / (d / c)) {
                missingValue = geometric(array);
            }
            else if (a + (d - c) == c - (d - c)) {
                missingValue = arithmetic(array);
            }
            else {
                missingValue = -1;
            }
        }

        else if (c == -1) {
            if (d / (b / a) == b * (b / a)) {
                missingValue = geometric(array);
            }
            else if (d - (b - a) == b + (b - a)) {
                missingValue = arithmetic(array);
            }
            else {
                missingValue = -1;
            }
        }

        else if (d == -1) {
            if (c / b == b / a) {
                missingValue = geometric(array);
            }
            else if (c - b == b - a) {
                missingValue = arithmetic(array);
            }
            else {
                missingValue = -1;
            }
        }

        return missingValue;
    }

    /**
     * Because the sequence is arithmetic, this method determines where the "-1"
     * is and inserts the proper value
     * 
     * @param array
     *            the array with the initial four values from the process method
     * @return the missing value of the sequence
     */
    public static int arithmetic(int[] array) {
        int missingValue = 0;

        int a = array[0];
        int b = array[1];
        int c = array[2];
        int d = array[3];

        if (a == -1) {
            missingValue = b - (d - c);
            if (missingValue <= 0) {
                missingValue = -1;
            }
        }
        else if (b == -1) {
            missingValue = array[2] - (array[3] - array[2]);
            if (missingValue <= 0) {
                missingValue = -1;
            }
        }
        else if (c == -1) {
            missingValue = array[3] - (array[1] - array[0]);
            if (missingValue <= 0) {
                missingValue = -1;
            }
        }

        else if (d == -1) {
            missingValue = (array[1] - array[0]) + array[2];
            if (missingValue <= 0) {
                missingValue = -1;
            }
        }

        return missingValue;
    }

    /**
     * Because the sequence is geometric, this method determines where the "-1"
     * is and inserts the proper value. It also creates an ArrayList to check
     * for through the isSorted method.
     * 
     * @param array
     *            the array with the initial four values from the process method
     * @return the missing value of the sequence
     */
    public static int geometric(int[] array) {
        int missingValue = 0;
        int LCD;

        double a = array[0];
        double b = array[1];
        double c = array[2];
        double d = array[3];

        if (a == -1) {
            LCD = (array[2] / array[1]);
            missingValue = array[1] / LCD;
            if (missingValue * LCD != array[1]) {
                missingValue = -1;
            }
        }
        else if (b == -1) {
            LCD = (array[3] / array[2]);
            missingValue = array[0] * LCD;
            if (missingValue * LCD != array[2]) {
                missingValue = -1;
            }
        }
        else if (c == -1) {
            LCD = array[1] / array[0];
            missingValue = array[1] * LCD;
            if (missingValue * LCD != array[3]) {
                missingValue = -1;
            }
        }
        else if (d == -1) {
            LCD = array[2] / array[1];
            missingValue = array[2] * LCD;
            if (missingValue / LCD != array[2]) {
                missingValue = -1;
            }
        }
        else {
            missingValue = -1;
        }

        return missingValue;
    }

    /**
     * This method determines if the list parameter is correctly sorted after
     * thw -1 is removed
     * 
     * @param list
     *            the ArrayList being check for sort
     * @exception IllegalArgumentException
     *                thrown if the sequence is not sorted from least to
     *                greatest
     */
    public static void isSorted(ArrayList<Integer> list) {
        int a = list.get(0);
        int b = list.get(1);
        int c = list.get(2);

        if (!(a < b && a < c)) {
            throw new IllegalArgumentException();
        }
        else if (!(b > a && b < c)) {
            throw new IllegalArgumentException();
        }
        else if (!(c > a && c > b)) {
            throw new IllegalArgumentException();
        }
    }
}
