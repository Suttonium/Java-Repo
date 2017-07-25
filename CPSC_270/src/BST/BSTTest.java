package BST;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class to assert the CBst implementation is performing correctly
 * 
 * @author Raymond Sutton
 * @version 03272017
 *
 */
public class BSTTest {
    private BST myBST;

    /**
     * test constructor creating a new, empty BST
     */
    @Before
    public void constructor() {
        myBST = new BST();

    }

    /**
     * asserts the constructor is created correctly
     */
    @Test
    public void isTheConstructorCreatedSuccessfully() {
        assertNotNull(myBST);
    }

    /**
     * test method to assure insert will add to a right subtree
     */
    @Test
    public void testInsertWorksWhenGoingToARightSubtree() {
        myBST.insert('m');
        myBST.insert('n');
        myBST.insert('l');
        myBST.insert('o');
        assertTrue(myBST.find('o'));
    }

    /**
     * test method to assure the insert method works correctly
     */
    @Test
    public void testInsertMethodWorksCorrectlyWithMultipleNodes() {
        myBST.insert('m');
        myBST.insert('n');
        myBST.insert('l');
        assertNotNull(myBST);
    }

    /**
     * test method to assure find works when value is the root
     */
    @Test
    public void testIfFindWorksCorrectlyWhenValueIsRoot() {
        myBST.insert('m');
        myBST.insert('n');
        myBST.insert('l');
        assertTrue(myBST.find('m'));
    }

    /**
     * test method to assure find works when value is in the left subtree
     */
    @Test
    public void testIfFindWorksCorrectlyWhenValueIsInLeftSubTree() {
        myBST.insert('m');
        myBST.insert('n');
        myBST.insert('l');
        assertTrue(myBST.find('l'));
    }

    /**
     * test method to assure find works when value is in the right subtree
     */
    @Test
    public void testIfFindWorksCorrectlyWhenValueIsInRightSubTree() {
        myBST.insert('m');
        myBST.insert('n');
        myBST.insert('l');
        assertTrue(myBST.find('n'));
    }

    /**
     * test method to assure find works when the value is not in the tree
     */
    @Test
    public void testIfFindWorksCorrectlyWhenValueIsNotInTree() {
        myBST.insert('m');
        myBST.insert('n');
        myBST.insert('l');
        assertFalse(myBST.find('a'));
    }

    /**
     * test method to assure find works with an empty tree
     */
    @Test
    public void testIfFindWorksWithNullTree() {
        assertFalse(myBST.find('a'));
    }

    /**
     * test method to assure height works with a larger left subtree
     */
    @Test
    public void testIfHeightWorksCorrectlyWithLargerLeftTree() {
        myBST.insert('m');
        myBST.insert('n');
        myBST.insert('l');
        myBST.insert('k');
        assertEquals(new Integer(3), myBST.height());
    }

    /**
     * test method to assure height works with a larger right subtree
     */
    @Test
    public void testIfHeightWorksCorrectlyWithLargerRightTree() {
        myBST.insert('m');
        myBST.insert('n');
        myBST.insert('l');
        myBST.insert('o');
        assertEquals(new Integer(3), myBST.height());
    }

    /**
     * test method to assure height works with an empty tree
     */
    @Test
    public void testIfHeightWorksWithEmptyTree() {
        assertEquals(new Integer(0), myBST.height());
    }

    /**
     * test method to assure preorder works with a basic tree
     */
    @Test
    public void testIfPreOrderReturnsCorrectStringWithInsertedValues() {
        myBST.insert('m');
        myBST.insert('n');
        myBST.insert('l');
        assertEquals("mln", myBST.preorder());
    }

    /**
     * test method to assure preorder works with an empty tree
     */
    @Test
    public void testIfPreOrderReturnsCorrectStringWithEmptyTree() {
        assertEquals("", myBST.preorder());
    }

    /**
     * test method to assure nothing happens when removing a value not in the
     * tree
     */
    @Test
    public void testIfRemoveDoesNothingWhenValueIsNotInTree() {
        myBST.insert('b');
        myBST.insert('a');
        myBST.insert('c');
        myBST.remove('z');
        String expected = "bac";
        String actual = myBST.preorder();
        assertEquals(expected, actual);
    }

    /**
     * test method to assure remove works properly with a non-empty tree
     */
    @Test
    public void testRemoveWorksProperlyWhenNodesAreInserted() {
        myBST.insert('b');
        myBST.insert('a');
        myBST.insert('c');
        myBST.remove('b');
        assertFalse(myBST.find('b'));
    }

    /**
     * test method to assure removing from a detailed right subtree works
     * correctly
     */
    @Test
    public void testRemovingFromRightSubTreeOfAMoreComplexTree() {
        myBST.insert('d');
        myBST.insert('b');
        myBST.insert('f');
        myBST.insert('a');
        myBST.insert('c');
        myBST.insert('e');
        myBST.insert('g');
        myBST.remove('f');
        assertFalse(myBST.find('f'));
    }

    /**
     * test method to assure removing from a detailed left subtree works
     * correctly
     */
    @Test
    public void testRemovingFromLeftSubTreeOfAMoreComplexTree() {
        myBST.insert('d');
        myBST.insert('b');
        myBST.insert('f');
        myBST.insert('a');
        myBST.insert('c');
        myBST.insert('e');
        myBST.insert('g');
        myBST.remove('b');
        assertFalse(myBST.find('b'));
    }

    /**
     * test method to assure removing from leaves of tree works correctly
     */
    @Test
    public void testRemovingFromLeavesOfTree() {
        myBST.insert('d');
        myBST.insert('b');
        myBST.insert('f');
        myBST.insert('a');
        myBST.insert('c');
        myBST.insert('e');
        myBST.insert('h');
        myBST.insert('g');
        myBST.remove('h');
        assertFalse(myBST.find('h'));
    }

    /**
     * test method to assure removing from an empty tree works correctly
     */
    @Test
    public void testRemovingFromAnEmptyTree() {
        myBST.remove('a');
        assertNotNull(myBST);
    }

    /**
     * test method to assure finding the position of the root node works
     * correctly
     */
    @Test
    public void findPositionOfRootNode() {
        myBST.insert('a');
        Integer expected = 0;
        Integer actual = myBST.position('a');
        assertEquals(expected, actual);
    }

    /**
     * test method to assure getting position from an empty tree works correctly
     */
    @Test
    public void testGettingPositionFromNullTree() {
        Integer expected = -1;
        Integer actual = myBST.position(null);
        assertEquals(expected, actual);
    }

    /**
     * test method to assure getting position within left subtree works
     * correctly
     */
    @Test
    public void testGettingPositionFromSecondLevelOfLeftTree() {
        myBST.insert('b');
        myBST.insert('a');
        myBST.insert('c');
        Integer expected = 1;
        Integer actual = myBST.position('a');
        assertEquals(expected, actual);
    }

    /**
     * test method to assure getting position from right subtree works correctly
     */
    @Test
    public void testGettingPositionFromSecondLevelRightSubTree() {
        myBST.insert('b');
        myBST.insert('a');
        myBST.insert('c');
        assertEquals(new Integer(2), myBST.position('c'));
    }

    /**
     * test method to assure -1 is returned if value is not in tree
     */
    @Test
    public void testGettingPositionIfValueIsNotInTree() {
        myBST.insert('b');
        myBST.insert('a');
        myBST.insert('c');
        Integer expected = -1;
        Integer actual = myBST.position('z');
        assertEquals(expected, actual);
    }

    /**
     * test method to assure a null tree is balanced
     */
    @Test
    public void testIfEmptyTreeIsBalanced() {
        Boolean expected = true;
        Boolean actual = myBST.isBalanced();
        assertEquals(expected, actual);
    }

    /**
     * test method to assure the inserted values creat a balanced tree
     */
    @Test
    public void testIfThisTreeIsBalanced() {
        myBST.insert('d');
        myBST.insert('b');
        myBST.insert('f');
        myBST.insert('a');
        myBST.insert('c');
        myBST.insert('e');
        myBST.insert('g');
        Boolean expected = true;
        Boolean actual = myBST.isBalanced();
        assertEquals(expected, actual);
    }

    /**
     * test method to assure the inserted values do not create a balanced tree
     */
    @Test
    public void testIfThisTreeIsNotBalanced() {
        myBST.insert('d');
        myBST.insert('b');
        myBST.insert('a');
        myBST.insert('c');
        Boolean expected = false;
        Boolean actual = myBST.isBalanced();
        assertEquals(expected, actual);
    }

    /**
     * test method to assure method fails if left subtree is unbalanced
     */
    @Test
    public void testIfLeftSubtreeIsUnbalancedMethodIsFalse() {
        myBST.insert('d');
        myBST.insert('c');
        myBST.insert('b');
        myBST.insert('a');
        myBST.insert('e');
        myBST.insert('f');
        Boolean expected = false;
        Boolean actual = myBST.isBalanced();
        assertEquals(expected, actual);
    }

    /**
     * test method to assyre method fails if right subtree is unbalanced
     */
    @Test
    public void testIfRightSubtreeIsUnbalancedMethodIsFalse() {
        myBST.insert('d');
        myBST.insert('c');
        myBST.insert('b');
        myBST.insert('e');
        myBST.insert('f');
        myBST.insert('g');
        Boolean expected = false;
        Boolean actual = myBST.isBalanced();
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteMaxLeaf() {
        myBST.insert('b');
        myBST.insert('a');
        myBST.insert('c');
        myBST.deleteMaxLeaf();
        assertEquals("ba", myBST.preorder());
    }
}
