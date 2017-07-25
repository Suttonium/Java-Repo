package Recursion;

import java.util.ArrayList;

public class Recursion {
    public int exp(int baseNum, int power) {
        if (power == 0) { // base case
            return 1;
        }
        else {
            return baseNum * exp(baseNum, power - 1);
        }
    }

    public int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        else {
            return n * fact(n - 1);
        }
    }

    public int fib(int n) {
        if (n == 0) { // base case
            return 0;
        }
        else if (n == 1) { // second base case
            return 1;
        }
        else {
            return fib(n - 1) + fib(n - 2);
            // fibonacci sequence says the third number is a combo of the prior
            // 2 numbers
        }
    }

    public static int min(ArrayList<Integer> values) {
        if (values.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        else {
            Integer first = values.remove(0);
            int minList = min(values);
            values.add(0, first);
            if (first < minList) {
                return first;
            }
            else {
                return minList;
            }
        }
    }

    public static String reverse(String str) {
        if (str.length() == 0) {
            return "";
        }
        else {
            return str.charAt(str.length() - 1)
                    + reverse(str.substring(0, str.length() - 1));
        }
    }

    public static int sum(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        else {
            Integer first = list.remove(0);
            int sum = sum(list);
            list.add(0, first);
            return first + sum;
        }
    }

    public static int max(ArrayList<Integer> list) {
        if (list.isEmpty()) { // base case
            return Integer.MIN_VALUE;
        }
        else {
            Integer first = list.remove(0); // remove first element
            int maxList = max(list); // call max again
            list.add(0, first); // add the element back in
            if (first > maxList) {
                // if old element is greater than max of new list, return old
                return first;
            }
            else {
                return maxList;
            }
        }
    }

    public static boolean isIdentifier(String s) {
        if (s.length() == 0) {
            return false;
        }
        else if (s.length() == 1) {
            return Character.isLetter(s.charAt(0));
        }
        else {
            int lastIndex = s.length() - 1;
            char lastChar = s.charAt(lastIndex);
            boolean frontIsIdent = isIdentifier(s.substring(0, lastIndex));
            boolean lastIsDigit = Character.isDigit(lastChar);
            boolean lastIsLetter = Character.isLetter(lastChar);
            return frontIsIdent && (lastIsDigit || lastIsLetter);
        }
    }
}
