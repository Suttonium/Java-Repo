package LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class to assert the CLList has full coverage
 * 
 * @author Austin
 * @version 20170210
 *
 */
public class LinkedListTest {
    private LinkedList list;

    /**
     * Constructor for a new CLList that is instantiated before every test
     * method
     */
    @Before
    public void constructor() {
        list = new LinkedList();
    }

    /**
     * Test method which assures the length() method works correctly by
     * returning the length after adding two values into the Linked List
     */
    @Test
    public void testInsertingIntoListMakesListSizeIncrement() {
        list.insert('a');
        list.insert('b');
        int expected = 2;
        int actual = list.length();
        assertEquals("Incorrect Result", expected, actual);
    }

    /**
     * This method makes sure the length and remove methods work correctly when
     * inserting and removing values from the list`
     */
    @Test
    public void testInsertingAndThenDeletingCorrectlyFollowsTheSizeOfList() {
        list.insert('a');
        list.insert('b');
        list.insert('c');
        list.moveToStart();
        list.remove();
        int expected = 2;
        int actual = list.length();
        assertEquals("Incorrect Result", expected, actual);
    }

    /**
     * This method tests the moveToStart() method by returning the correct
     * current position
     */
    @Test
    public void testMovingCurrentPositionToFrontReturnsCorrectPosition() {
        list.insert('a');
        list.insert('b');
        list.insert('c');
        list.moveToStart();
        int expected = 0;
        int actual = list.curPos();
        assertEquals("Incorrect Result", expected, actual);
    }

    /**
     * This method moves the current position to the front of the list and then
     * moves the current pointer to the next entry
     */
    @Test
    public void doesTheNextMethodCorrectlyMoveTheCurrentPosition() {
        list.insert('a');
        list.insert('b');
        list.insert('c');
        list.moveToStart();
        list.next();
        int expected = 1;
        int actual = list.curPos();
        assertEquals("Incorrect Result", expected, actual);
    }

    /**
     * This method moves the current position to the front of the list and then
     * moves the current pointer to the next entry. It then moves the current
     * pointer to the previous entry.
     */
    @Test
    public void doesThePrevMethodCorrectlyMoveTheCurrentPosition() {
        list.insert('a');
        list.insert('b');
        list.insert('c');
        list.moveToStart();
        list.next();
        list.prev();
        int expected = 0;
        int actual = list.curPos();
        assertEquals("Incorrect", expected, actual);
    }

    /**
     * This method assures a RuntimeException is thrown when getting the value
     * of an empty list
     */
    @Test(expected = RuntimeException.class)
    public void doesTheGetMethodThrowExceptionWhenHeadEqualsTail() {
        assertNotNull(list);
        list.get();
    }

    /**
     * This method returns the value of the current position of a filled list
     */
    @Test
    public void willGetMethodReturnCurrentWithAppropriateConditions() {
        list.insert('a');
        list.insert('b');
        list.insert('c');
        list.insert('d');
        // list is now | [d] -> [c] -> [b] -> [a]
        list.moveToStart();
        Character expected = 'd';
        Character actual = (Character) list.get();
        assertEquals("Incorrect Result", expected, actual);
    }

    /**
     * This method does nothing when calling next from the tail node
     */
    @Test
    public void testNextMethodIfCurrentIsAtTail() {
        assertNotNull(list);
        list.next();
    }

    /**
     * This method does nothing when calling previous of the node next to head
     */
    @Test
    public void testIfHeadDotNextIsCurrentWhenTryingToCallPrevMethod() {
        list.insert('a');
        assertNotNull(list);
        list.prev();
    }

    /**
     * This method does nothing when removing from an empty list
     */
    @Test
    public void testRemoveMethodWithNothingInList() {
        assertNotNull(list);
        list.remove();
    }

    /**
     * This method tests the remove method when removing the node next to tail
     */
    @Test
    public void testRemoveMethodWhenCurrentDotNextIsTail() {
        list.insert('a');
        list.remove();
        assertNotNull(list);
    }

    /**
     * This method returns -1 when finding the current position of an empty list
     */
    @Test
    public void testIfEmptyListReturnsNegativeOne() {
        int expected = -1;
        int actual = list.curPos();
        assertEquals("Incorrect Result", expected, actual);
    }

    /**
     * This method tests that when select and cut are called, the length is
     * correctly calculated.
     */
    @Test
    public void doesSelectAndCutWorkingTogetherReturnCorrectLength() {
        list.insert('a');
        list.insert('b');
        list.insert('c');
        list.insert('d');
        list.insert('e');
        list.insert('f');
        list.moveToStart();
        list.select(3);
        list.cut();
        int expected = 3;
        int actual = list.length();
        assertEquals("Incorrect Result", expected, actual);
    }

    /**
     * This method checks if select continues when selecting past the tail node
     */
    @Test
    public void doesSelectWorkIfItSelectsPastTail() {
        list.insert('a');
        list.insert('b');
        list.insert('c');
        list.insert('d');
        list.insert('e');
        list.insert('f');
        list.moveToStart();
        list.next();
        list.next();
        list.next();
        list.select(5);
        assertNotNull(list);
    }

    /**
     * This method checks if you can remove from a list with no values/null
     */
    @Test
    public void testRemoveFromNullValue() {
        assertNotNull(list);
        list.insert('a');
        list.remove();
    }

    @Test
    public void testInsertSorted() {
        list.sortedInsert('d');
        list.sortedInsert('b');
        list.sortedInsert('a');
        System.out.println(list.toString());
        list.sortedInsert('c');
        System.out.println(list.toString());
        assertEquals("abcd", list.toString());

    }

}
