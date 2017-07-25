package Recursion;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for the RecursiveParser method
 * 
 * @author Raymond Sutton
 * @version 2017-01-25
 *
 */
public class RecursiveParserTest {

    /**
     * This method tests the functionality of the factorial method by creating a
     * RecurisveParser object and calling the assert method
     */
    @Test
    public void isThisTheCorrectFactorialAnswer() {
        RecursiveParser rp = new RecursiveParser();
        int expected = 120;
        int actual = rp.factorial(5);
        assertEquals("Incorrect Result", expected, actual);
    }

    /**
     * This method tests if an exception is thrown when factorial is called with
     * a negative value
     */
    @Test(expected = IllegalArgumentException.class)
    public void isAnExceptionThrownWhenICallFactorialWithANegativeNumber() {
        RecursiveParser rp = new RecursiveParser();
        Integer n = -5;
        assertNotNull(rp);
        rp.factorial(n);
    }

    /**
     * This method tests the true/ false assertion of the isPalindrome method
     */
    @Test
    public void isThisAPalindromeTF() {
        RecursiveParser palin = new RecursiveParser();
        assertTrue("Incorrect Result", palin.isPalindrome("racecar"));
        assertFalse("Incorrect Result", palin.isPalindrome("hello"));
        assertTrue("Incorrect Result", palin.isPalindrome("a"));
        assertTrue("Incorrect Result", palin.isPalindrome(""));
    }

    /**
     * This method checks the effectiveness of the isParamList method
     */
    @Test
    public void isThisAParamListTF() {
        RecursiveParser param = new RecursiveParser();
        assertFalse(param.isParamList(null));
        assertFalse("Incorrect Result", param.isParamList("z"));
        assertTrue("Incorrect Result", param.isParamList("()"));
        assertFalse("Incorrect Result", param.isParamList("z)"));
        assertFalse("Incorrect Result", param.isParamList("(z"));
        assertTrue("Incorrect Result", param.isParamList("(z)"));
        assertFalse("Incorrect Result", param.isParamList("(ab"));
        assertFalse("Incorrect Result", param.isParamList("ab)"));
        assertFalse("Incorrect Result", param.isParamList("abc"));
        assertFalse("Incorrect Result", param.isParamList("45"));
        assertFalse("Incorrect Result", param.isParamList("4, 5"));
        assertTrue("Incorrect Result", param.isParamList("(a,b,c,d)"));
        assertFalse("Incorrect Result", param.isParamList("(a,b,cd)"));
        assertFalse("Incorrect Result", param.isParamList("(a,b,c,5)"));
    }

    /**
     * This method creates a new RecursiveParser object and calls the power
     * method to test its correctness
     */
    @Test
    public void isThisTheAnswerForPowerMethod() {
        RecursiveParser num = new RecursiveParser();
        Double expected = 8.0;
        Double actual = num.power(2.0, 3);
        assertEquals("Incorrect Result", expected, actual);
    }

    /**
     * This method checks if power throws an exception with a negative x
     */
    @Test(expected = IllegalArgumentException.class)
    public void doesPowerThrowAnExceptionWithNegativeX() {
        RecursiveParser pow = new RecursiveParser();
        Double x = 2.0;
        Integer y = -1;
        assertNotNull(pow);
        pow.power(x, y);
    }
}
