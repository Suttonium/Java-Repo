package Recursion;

/**
 * @author Raymond Sutton, 00915098
 * @version 2017-01-25
 *
 */
public class RecursiveParser implements ParserADT {

    /**
     * (non-Javadoc)
     * 
     * @see ParserADT#factorial(java.lang.Integer)
     */
    @Override
    public Integer factorial(Integer n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see ParserADT#isPalindrome(java.lang.String)
     */
    @Override
    public boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        return isPalindrome(s.substring(1, s.length() - 1));
    }

    /**
     * (non-Javadoc)
     * 
     * @see ParserADT#power(java.lang.Double, java.lang.Integer)
     */
    @Override
    public Double power(Double b, Integer x) throws IllegalArgumentException {
        if (x < 0) {
            throw new IllegalArgumentException();
        }
        if (x == 0) {
            return 1.0;
        }
        else if (x % 2 == 0) {
            Double ans = power(b, x / 2);
            return ans * ans;
        }
        else {
            return b * power(b, x - 1);
        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see ParserADT#isParamList(java.lang.String)
     */
    @Override
    public boolean isParamList(String p) {
        if (p == null) {
            return false;
        }
        if (p.length() < 2) {
            return false;
        }
        if (p.length() == 2
                && (p.charAt(0) == '(' && p.charAt(p.length() - 1) == ')')) {
            return true;
        }
        if (p.length() > 2
                && (p.charAt(0) == '(' && p.charAt(p.length() - 1) == ')')) {
            String sub = (p.substring(1, p.length() - 1));
            return paramListHelper(sub);
        }
        else {
            return false;
        }
    }

    /**
     * This method is a helper method to determine if the parameter is truly an
     * identifier
     * 
     * @param sub
     *            the substring used within the paramList method
     * @return true or false depending on if the substring is an identifier
     */
    private boolean paramListHelper(String sub) {
        if (sub.length() == 1) {
            return Character.isLetter(sub.charAt(0));
        }

        int lastIndex = sub.length() - 1;
        int lastChar = sub.charAt(sub.length() - 1);
        if (Character.isLetter(lastChar)
                && sub.charAt(sub.length() - 2) == ',') {
            return paramListHelper(sub.substring(0, lastIndex - 1));
        }
        else {
            return false;
        }
    }
}
