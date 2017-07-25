package FinalReview;

/**
 * <!-- ASG3
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
 * <h1>Asg3: Binary Search Tree (BST)</h1>
 * <h2>Objectives</h2>
 * <p>
 * <ul>
 * <li>develop your ability to implement a BST given its ADT</li>
 * <li>improve your ability to write JUnit tests</li>
 * <li>improve your ability to write readable code according to best practices
 * </ul>
 * </p>
 * <h2>Introduction</h2>
 * <p>
 * The CBstADT defines the API for a Bst of Characters, where only letters and
 * numerals are used. Note that a newly created CBstADT is EMPTY.
 * </p>
 * <p>
 * Review your notes and chapter 7 of the ODSA book for information on and
 * example code for a BST.
 * </p>
 * <p>
 * Your task is to implement this ADT, develop a JUnit test class, and document
 * both using Javadoc.
 * </p>
 * <h2>Instructions</h2>
 * <p>
 * <ul>
 * <li>Study the example code in the textbook.</li>
 * <li>Your implementation should store Character references NOT Object nor
 * Comparable references.</li>
 * <li>Your implementation should NOT use generics.</li>
 * <li>Write the Javadoc for the JUnit class.</li>
 * <li>Write the Javadoc for your implementation class. Note: you must use the
 * eclipse commands to create this class from this ADT. Do not change the
 * generated comments for the methods. Only modify the class javadoc, and write
 * javadoc for any non-public methods and fields you add.</li>
 * <li>Write the JUnit tests for the ADT described by this API.</li>
 * <li>Implement, using a Binary Tree, the ADT described by this API.</li>
 * <li>You may NOT use any pre-existing classes such as Node etc.</li>
 * <li>Submit your files to Web-CAT using the eclipse menu "Project->Submit
 * Assignment..."</li>
 * <li>To see my comments after I've graded your work, or to see your results at
 * any time, login to http://web-cat.cs.vt.edu</li>
 * </ul>
 * </p>
 * <h2>Basic Tips</h2>
 * <p>
 * Write a protected method that creates a simple CBst by using the Node
 * constructors. You can then use this method to test your JUnit tests for
 * preorder. Once your preorder tests are validated, implement the preorder
 * method and test it. Once the preorder method has been validated, develop your
 * insert tests (you will need the preorder method here), then implement the
 * insert method and test it. Once these two are validated, continue with the
 * rest of the tests and methods.
 * </p>
 * <p>
 * Use the development process described in class and the slides. For example,
 * develop tests for a method, implement the method, run the tests. Do this
 * until the method passes the tests. Go on to the next method.
 * </p>
 * </p>
 * <h2>NOTES</h2>
 * <p>
 * <li>Any submission that is not a pointer-based implementation will receive NO
 * CREDIT.</li>
 * <li>Any submission that that uses pre-existing classes like Node will receive
 * NO CREDIT.</li>
 * <li>You may submit as many times as you like until the deadline.</li>
 * <li>The grade of your latest submission will be the one recorded.</li>
 * <li><b>Disregard the Web-CAT correctness grade. I will compute it
 * differently.</b></li>
 * </ul>
 * </p>
 * <h2>CHECKLISTS</h2>
 * <p>
 * Check that you have done all the following.
 * <table border="1">
 * <tr>
 * <td>DONE?</td>
 * <td>TASK</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>The implementing class for this assignment is named CBst</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>All methods specified in the ADT are implemented</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td><b>Except for constructors (which MUST be public)</b>, any non-ADT
 * methods are NOT declared public</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Fields, if any, are NOT declared public</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Code is formatted as described in piazza</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Javadoc is present in the implementation and JUnit class headers as well
 * as all non-private fields and ALL methods, as described in piazza</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Class header javadoc must include a brief description of the class, and
 * the &#64;author and &#64;version tags</td>
 * </tr>
 * </table>
 * </p>
 * <p>
 * Check that you read and followed these how-to items in piazza.
 * </p>
 * <table border="1">
 * <tr>
 * <td>DONE?</td>
 * <td>TASK</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Read: how to write JUnit tests</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Read: how to write and format readable Java (and satisfy Web-CAT's format
 * checks)</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Watch: video: setup eclipse to format your code for Web-CAT</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Read: how to setup Eclipse for Web-CAT</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Read: how to submit your assignment to Web-CAT from within Eclipse</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Read: how to find formatting or code coverage errors in my source
 * code</td>
 * </tr>
 * </table>
 *
 * @author acsiochi
 * @version 20170309 acs updated and reviewed draft
 * @version 20170306 initial draft
 */
public interface DataStructureADT {

    /**
     * Determine if the given Character is in this tree.
     * 
     * @param c
     *            the Character to find in this tree
     * @return true if c is in this tree, false else
     */
    public Boolean find(Character c);

    /**
     * Determine the height of this tree. Consult the class notes for the
     * definition of height.
     * 
     * @return height of this tree
     */
    public Integer height();

    /**
     * Insert c into this tree. If c is already in the tree, ignore the insert
     * request.
     * 
     * <h3>Example</h3>
     * <p>
     * Given the following tree,
     * 
     * <pre>
     *     d
     *    / \
     *   b   f
     *  /   /
     * a   e
     * </pre>
     * 
     * if insert('c') is called then the resulting tree would be
     * 
     * <pre>
     *      d
     *     / \
     *    /   \
     *   b     f
     *  / \   /
     * a   c e
     * </pre>
     * 
     * </p>
     * 
     * @param c
     *            the Character to insert into this tree
     */
    public void insert(Character c);

    /**
     * Determine if this tree is balanced. A tree is balanced if the tree is
     * empty or both of the following are true:
     * <ul>
     * <li>the difference between the heights of the left subtree and right
     * subtrees is less than 2, AND</li>
     * <li>both subtrees are balanced</li>
     * </ul>
     * <h3>Example</h3>
     * <p>
     * This is a balanced tree:
     * 
     * <pre>
     *      d
     *     / \
     *    /   \
     *   b     f
     *        / \
     *       e   g
     * </pre>
     * 
     * This is NOT a balanced tree:
     * 
     * <pre>
     *      d
     *       \
     *        \
     *         f
     *        / \
     *       e   g
     * </pre>
     * </p>
     * 
     * @return true if this tree is balanced, false else
     */
    public Boolean isBalanced();

    /**
     * <p>
     * Determine the position of the given Character in this tree. The position
     * of the root is 0, its left kid is 1 and right kid is 2, and so on.
     * </p>
     * <h3>Example</h3>
     * <p>
     * Here are the first 7 positions:
     * 
     * <pre>
     *      0
     *     / \
     *    /   \
     *   1     2
     *  / \   / \
     * 3   4 5   6
     * </pre>
     * 
     * So, given the following tree,
     * 
     * <pre>
     *      d
     *     / \
     *    /   \
     *   b     f
     *  / \     \
     * a   c     g
     * </pre>
     * 
     * the positions of each Character would be
     * <table border="1">
     * <tr>
     * <td>Character</td>
     * <td>Position</td>
     * </tr>
     * <tr>
     * <td>a</td>
     * <td>3</td>
     * </tr>
     * <tr>
     * <td>b</td>
     * <td>1</td>
     * </tr>
     * <tr>
     * <td>c</td>
     * <td>4</td>
     * </tr>
     * <tr>
     * <td>d</td>
     * <td>0</td>
     * </tr>
     * <tr>
     * <td>f</td>
     * <td>2</td>
     * </tr>
     * <tr>
     * <td>g</td>
     * <td>6</td>
     * </tr>
     * </table>
     * g is at position 6 because position 5 is where the left kid of f would
     * be.
     * </p>
     * 
     * @param c
     *            the Character whose position is to be determined
     * @return position of c if c is in this tree, else -1
     */
    public Integer position(Character c);

    /**
     * <p>
     * Determine the preorder traversal of this tree.
     * </p>
     * <h3>Example</h3>
     * <p>
     * Given the following tree,
     * 
     * <pre>
     *     c
     *    / \
     *   b   e
     *  /   /
     * a   d
     * </pre>
     * 
     * The preorder traversal would be cbaed.
     * 
     * </p>
     * 
     * @return preorder traversal of this tree
     */
    public String preorder();

    /**
     * <p>
     * Remove the given Character from this tree. Do nothing if the given
     * Character is not in this tree.
     * </p>
     * <h3>Example</h3>
     * <p>
     * Given the following tree,
     * 
     * <pre>
     *      d
     *     / \
     *    /   \
     *   b     f
     *  / \   / \
     * a   c e   g
     * </pre>
     * 
     * calling remove(d) will result in
     * 
     * <pre>
     *      c
     *     / \
     *    /   \
     *   b     f
     *  /     / \
     * a     e   g
     * </pre>
     * 
     * Be sure to review the notes and book on remove.
     * </p>
     * 
     * @param c
     *            the Character to remove
     */
    public void remove(Character c);

    /**
     * <!-- ASG2
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
     * <h1>Asg2: Linked List</h1>
     * <h2>Objectives</h2>
     * <p>
     * <ul>
     * <li>develop your ability to implement a Linked List given its ADT</li>
     * <li>improve your ability to write JUnit tests</li>
     * <li>improve your ability to write readable code according to best
     * practices
     * </ul>
     * </p>
     * <h2>Introduction</h2>
     * <p>
     * The CListADT defines the API for a list of Characters. Note that a newly
     * created CListADT is EMPTY.
     * </p>
     * <p>
     * A Character is located at a position in the CListADT. One of the
     * Characters is the current Character. A CListADT has methods to manage its
     * list of Characters (details of the methods are given below).
     * </p>
     * <p>
     * Your task is to implement this ADT, develop a JUnit test class, and
     * document both using Javadoc.
     * </p>
     * <h2>Instructions</h2>
     * <p>
     * <ul>
     * <li>Study the LList.java and Link.java code in the textbook.</li>
     * <li>Your implementation should store Character references NOT Object
     * references.</li>
     * <li>Your implementation should NOT use generics.</li>
     * <li>Write the Javadoc for the JUnit class and the implementation.</li>
     * <li>Write the JUnit tests for the ADT described by this API.</li>
     * <li>Implement, using a LINKED LIST, the ADT described by this API.</li>
     * <li>You may NOT use any pre-existing classes such as List, ArrayList,
     * etc.</li>
     * <li>Submit your files to Web-CAT using the eclipse menu "Project->Submit
     * Assignment..."</li>
     * <li>To see my comments after I've graded your work, or to see your
     * results at any time, login to http://web-cat.cs.vt.edu</li>
     * </ul>
     * </p>
     * <h2>Practical Tips</h2>
     * <p>
     * Develop preliminary JUnit tests before you implement the methods, using
     * the process described in class and the slides. For example, develop tests
     * for a method, implement the method, run the tests. Do this until the
     * method passes the tests. Go on to the next method.
     * </p>
     * <p>
     * Sometimes you may have to implement a little bit as well in order to
     * write your JUnit tests. The process involves switching between JUnit
     * tests and implementation, in order to develop a good understanding of the
     * problems to be solved.
     * </p>
     * </p>
     * <h2>NOTES</h2>
     * <p>
     * <li>Any submission that is not a linked list implementation will receive
     * NO CREDIT.</li>
     * <li>Any submission that that uses pre-existing classes like ArrayList
     * will receive NO CREDIT.</li>
     * <li>You may submit as many times as you like until the deadline.</li>
     * <li>The grade of your latest submission will be the one recorded.</li>
     * <li><b>Disregard the Web-CAT correctness grade. I will compute it
     * differently.</b></li>
     * </ul>
     * </p>
     * <h2>CHECKLISTS</h2>
     * <p>
     * Check that you have done all the following.
     * <table border="1">
     * <tr>
     * <td>DONE?</td>
     * <td>TASK</td>
     * </tr>
     * <tr>
     * <td>.</td>
     * <td>The implementing class for this assignment is named CLList</td>
     * </tr>
     * <tr>
     * <td>.</td>
     * <td>All methods specified in the ADT are implemented</td>
     * </tr>
     * <tr>
     * <td>.</td>
     * <td>Except for constructors, any non-ADT methods are declared
     * PRIVATE</td>
     * </tr>
     * <tr>
     * <td>.</td>
     * <td>Fields, if any, are declared private</td>
     * </tr>
     * <tr>
     * <td>.</td>
     * <td>Code is formatted as described in piazza</td>
     * </tr>
     * <tr>
     * <td>.</td>
     * <td>Javadoc is present in the implementation and JUnit class headers as
     * well as all non-private fields and ALL methods, as described in
     * piazza</td>
     * </tr>
     * <tr>
     * <td>.</td>
     * <td>Class header javadoc must include a brief description of the class,
     * and the &#64;author and &#64;version tags</td>
     * </tr>
     * </table>
     * </p>
     * <p>
     * Check that you read and followed these how-to items in piazza.
     * </p>
     * <table border="1">
     * <tr>
     * <td>DONE?</td>
     * <td>TASK</td>
     * </tr>
     * <tr>
     * <td>.</td>
     * <td>Read: how to write JUnit tests</td>
     * </tr>
     * <tr>
     * <td>.</td>
     * <td>Read: how to write and format readable Java (and satisfy Web-CAT's
     * format checks)</td>
     * </tr>
     * <tr>
     * <td>.</td>
     * <td>Watch: video: setup eclipse to format your code for Web-CAT</td>
     * </tr>
     * <tr>
     * <td>.</td>
     * <td>Read: how to setup Eclipse for Web-CAT</td>
     * </tr>
     * <tr>
     * <td>.</td>
     * <td>Read: how to submit your assignment to Web-CAT from within
     * Eclipse</td>
     * </tr>
     * <tr>
     * <td>.</td>
     * <td>Read: how to find formatting or code coverage errors in my source
     * code</td>
     * </tr>
     * </table>
     *
     * @author acsiochi
     * @version 20170208 initial draft
     * @version 20170210 update methods, final review for release
     */

    /**
     * <p>
     * Return the position of the current element. The position of the first
     * element is 0. Positions increase by one as they move away from the first
     * element. -1 is returned if the list is empty.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * if l == < a, b | c , d , e >  then
     *   l.curPos() returns 2
     * </pre>
     * 
     * @return the position of the current element, -1 if list is empty
     */
    public Integer curPos();

    /**
     * <p>
     * Return a copy of the element at the current position of this CListADT.
     * Throws and exception if this is not possible.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * if l == < a, b | c , d > then
     *   l.get() returns c
     * </pre>
     * 
     * @return a copy of the current element
     * @throws RuntimeException
     *             when it is not possible to return the current element
     */
    public Object get() throws RuntimeException;

    /**
     * <p>
     * Insert a copy of c into this CListADT at the current position.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * if l == < a, b | c , d > then
     *   l.insert(x) produces < a , b , | x , c , d >
     * </pre>
     * 
     * @param c
     *            Character a copy of which is to be inserted
     */
    public void insertLL(Character c);

    /**
     * <p>
     * Determine the number of elements in this list.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * if l == < a, b | c , d > then
     *   l.length() returns 4.
     * </pre>
     * 
     * @return number of elements in this list
     */
    public Integer length();

    /**
     * <p>
     * Move the current position to the start of this list.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * if l == < a, b | c , d > then
     *   l.moveToStart() produces < | a, b , c , d >.
     * </pre>
     */
    public void moveToStart();

    /**
     * <p>
     * Move the current position one element towards the tail of this CListADT.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * if l == < a, b | c , d > then
     *   l.next() produces < a , b , c | d >
     * </pre>
     * 
     */
    public void next();

    /**
     * <p>
     * Move the current position one element towards the head of this CListADT.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * if l == < a, b | c , d > then
     *   l.prev() produces < a | b , c , d >
     * </pre>
     * 
     */
    public void prev();

    /**
     * <p>
     * Remove the current character from this CListADT.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * if l == < a, b | c , d > then
     *   l.remove() produces < a , b , | d >
     * </pre>
     * 
     */
    public void removeLL();

    public void insertSorted(Character c);

    public void removeMaxLeaf();

    public String toString();

}
