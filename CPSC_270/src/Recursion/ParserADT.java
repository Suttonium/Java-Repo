package Recursion;
/**
 * <!--
 * 
 * <pre>
 * INSTRUCTIONS FOR READING THIS ASSIGNMENT:
 * 1. Create an Eclipse project for this assignment.
 * 2. Import this file into that project.
 * 3. In Eclipse, right-click the imported file and select Export/Java/JavaDoc
 * 4. Note the destination (look for this in the bottom 1/3 of the dialog box
 * 5. Click Finish
 * 6. Find the index.html file and double click it.
 * </pre>
 * 
 * -->
 * <h1>Asg1: Recursion</h1>
 * <p>
 * This API defines the ParserADT. It provides methods to parse a given String
 * and calculate some Mathematical functions.
 * </p>
 * <h2>Objectives</h2>
 * <p>
 * <ul>
 * <li>practice writing recursive methods</li>
 * <li>practice developing JUnit tests</li>
 * <li>use Web-CAT to learn how to develop correct implementations and effective
 * tests</li>
 * </ul>
 * </p>
 * <h2>Introduction</h2>
 * <p>
 * The class ParserADT defines the API for a utility package for parsing
 * expressions.
 * </p>
 * <p>
 * Your task is to implement this ADT, develop a JUnit test class, and document
 * both using Javadoc. You MUST use recursion for all the methods described
 * below (except for the Constructor).
 * </p>
 * <h2>Instructions</h2>
 * <p>
 * <ul>
 * <li>Write the Javadoc for the JUnit class and the implementation.</li>
 * <li>Write the JUnit tests for the ADT described by this API.</li>
 * <li>Implement the ADT described by this API.</li>
 * <li>Submit to Web-CAT using the eclipse menu "Project->Submit
 * Assignment..."</li>
 * <li>To see my comments after I've graded your work, or to see your results at
 * any time, login to http://web-cat.cs.vt.edu</li>
 * </ul>
 * </p>
 * <h2>Practical Tips</h2>
 * <p>
 * Develop preliminary JUnit tests before you implement the methods, using the
 * process described in class and the slides. For example, develop tests for a
 * method, implement the method, run the tests. Do this until the method passes
 * the tests. Go on to the next method.
 * </p>
 * <p>
 * Sometimes you may have to implement a little bit as well in order to write
 * your JUnit tests. The process involves switching between JUnit tests and
 * implementation, in order to develop a good understanding of the problems to
 * be solved.
 * </p>
 * </p>
 * <h2>NOTES</h2>
 * <p>
 * <li>You may submit as many times as you like until the deadline.</li>
 * <li>The grade of your latest submission will be the one recorded.</li>
 * <li><b>Disregard the Web-CAT correctness grade. I will compute it
 * differently.</b></li>
 * </ul>
 * </p>
 * <h2>CHECKLIST</h2>
 * <p>
 * Check that you have done all the following.
 * <ul>
 * <li>The implementing class for this assignment is named RecursiveParser</li>
 * <li>All methods specified in the ADT are implemented.</li>
 * <li>Any non-ADT methods are declared PRIVATE.</li>
 * <li>Fields, if any, are declared private.</li>
 * <li>Code is formatted as described in piazza</li>
 * <li>Javadoc is present in the implementation and JUnit class headers as well
 * as all non-private fields and ALL methods, as described in piazza</li>
 * <li>You read and followed these how-to items in piazza:
 * <ul>
 * <li>write JUnit tests</li>
 * <li>write and format readable Java (and satisfy Web-CAT's format checks)</li>
 * <li>video: setup eclipse to format your code for Web-CAT</li>
 * <li>setup Eclipse for Web-CAT</li>
 * <li>submit your assignment to Web-CAT from within Eclipse</li>
 * <li>find formatting or code coverage errors in my source code</li>
 * </ul>
 * </li>
 * </ul>
 * 
 * @author acsiochi
 * @version 20170112
 */
public interface ParserADT {

    /**
     * <p>
     * Determine the factorial of the given integer. An IllegalArgumentException
     * is thrown if x is negative. Refer to your class notes for the definition
     * of factorial. This must be done recursively.
     * </p>
     * <h3>WARNING</h3>
     * <p>
     * NO POINTS WILL BE AWARDED if your implementation is not recursive.
     * </p>
     * 
     * @param n
     *            the number whose factorial is to be computed
     * @return n!
     * @throws IllegalArgumentException
     *             when n is negative
     */
    public Integer factorial(Integer n) throws IllegalArgumentException;

    /**
     * <p>
     * Determine if the given string is a palindrome. Refer to your class notes
     * for the BNF of a palindrome. This must be done recursively.
     * </p>
     * <h3>WARNING</h3>
     * <p>
     * NO POINTS WILL BE AWARDED if your implementation is not recursive.
     * </p>
     * 
     * @param s
     *            determine if this string is a palindrome
     * @return true if s is a palindrome, false else
     */
    public boolean isPalindrome(String s);

    /**
     * <p>
     * Determine if the given string is a list of actual parameters. This must
     * be done recursively.
     * </p>
     * <h3>WARNING</h3>
     * <p>
     * NO POINTS WILL BE AWARDED if your implementation is not recursive.
     * </p>
     * <p>
     * The following BNF recursively defines this list of actual params:
     * </p>
     * 
     * <pre>
     * ACTUALPARAMS ::= ( PLIST )
     * PLIST ::= null | ID RESTLIST
     * RESTLIST ::= null | , ID RESTLIST
     * ID ::= 'a' | 'b' | ... | 'Z'
     * </pre>
     * </p>
     * <h3>EXAMPLES</h3>
     * <p>
     * <table border = "1">
     * <tr style="color:red">
     * <td>String</td>
     * <td>Result returned by isParamList</td>
     * </tr>
     * <tr>
     * <td>(a,b,c)</td>
     * <td>true</td>
     * </tr>
     * <tr>
     * <td>(a,b,)</td>
     * <td>false</td>
     * </tr>
     * </table>
     * </p>
     * 
     * @param p
     *            string to check
     * @return true if p is a list of parameters
     */
    public boolean isParamList(String p);

    /**
     * <p>
     * Calculate b raised to the x power if x is non-negative. An
     * IllegalArgumentException is thrown if x is negative. This must be done
     * recursively.
     * </p>
     * <h3>WARNING</h3>
     * <p>
     * NO POINTS WILL BE AWARDED if your implementation is not recursive.
     * </p>
     * <p>
     * Use the following recursive definition for power:
     * 
     * <pre>
     * b<sup>x</sup> =
     *       1.0 if x = 0
     *       (b<sup>(x/2)</sup>)<sup>2</sup> if x is even
     *       b*(b<sup>(x-1)</sup>) if x is odd
     * </pre>
     * </p>
     * <h3>EXAMPLES</h3>
     * <p>
     * <table border = "1">
     * <tr style="color:red">
     * <td>b</td>
     * <td>x</td>
     * <td>RESULT</td>
     * </tr>
     * <tr>
     * <td>2</td>
     * <td>3</td>
     * <td>8.0 is returned</td>
     * </tr>
     * <tr>
     * <td>2</td>
     * <td>-8</td>
     * <td>IllegalArgumentException is thrown</td>
     * </tr>
     * </table>
     * </p>
     * 
     * @param b
     *            number to be raised
     * @param x
     *            power to which b is raised
     * @return b raised to the x power
     * @throws IllegalArgumentException
     *             if x is negative
     */
    public Double power(Double b, Integer x) throws IllegalArgumentException;

}
