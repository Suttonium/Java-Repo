package P4;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * simple test program to test the SimpleLinkedList class
 * 
 * @author Austin
 *
 */
public class SimpleLinkedListTest {

	/**
	 * simple test class to test adding into the linked list
	 */
	@Test
	public void testAdd() {
		SimpleLinkedList<String> list = new SimpleLinkedList<String>();
		list.add(0, "Hello");

		assertEquals("Hello", list.first.value);
		assertTrue(list.first.next == null);

		list.add(0, "Hi");

		assertEquals("Hi", list.first.value);
		assertEquals("Hello", list.first.next.value);
		assertTrue(list.first.next.next == null);

		list.add(1, "Hey");

		assertEquals("Hi", list.first.value);
		assertEquals("Hey", list.first.next.value);
		assertEquals("Hello", list.first.next.next.value);
		assertTrue(list.first.next.next.next == null);
	}

	/**
	 * simple test class to test adding to the back of the linked list
	 */
	@Test
	public void testAddBack() {
		SimpleLinkedList<String> list = new SimpleLinkedList<String>();
		list.add(0, "Hello");
		assertEquals("Hello", list.first.value);
		assertEquals("Hello", list.last.value);
		assertTrue(list.first.next == null);
		assertTrue(list.last.next == null);

		list.add(1, "Hi");
		assertEquals("Hi", list.last.value);
		assertEquals("Hi", list.first.next.value);
		assertTrue(list.last.next == null);

		list.add(2, "Hey");
		assertEquals("Hey", list.last.value);
		assertEquals("Hey", list.first.next.next.value);
		assertTrue(list.first.next.next.next == null);
	}

	/**
	 * simple test class to test adding to the front of the linked list
	 */
	@Test
	public void testAddFront() {
		SimpleLinkedList<String> list = new SimpleLinkedList<String>();
		list.add(0, "Hello");
		assertEquals("Hello", list.first.value);
		assertEquals("Hello", list.last.value);
		assertTrue(list.first.next == null);
		assertTrue(list.last.next == null);

		list.add(1, "Hi");
		assertEquals("Hi", list.last.value);
		assertEquals("Hi", list.first.next.value);
		assertTrue(list.last.next == null);
		assertTrue(list.first.next.next == null);

		list.add(2, "Hey");
		assertEquals("Hey", list.last.value);
		assertEquals("Hey", list.first.next.next.value);
		assertEquals("Hello", list.first.value);
		assertTrue(list.last.next == null);
		assertTrue(list.first.next.next.next == null);

		list.add(0, "Hola");
		assertEquals("Hola", list.first.value);
		assertEquals("Hello", list.first.next.value);
	}

	/**
	 * simple test class to test adding to the middle of the linked list
	 */
	@Test
	public void testAddMiddle() {
		SimpleLinkedList<String> list = new SimpleLinkedList<String>();
		list.add(0, "Hello");
		assertEquals("Hello", list.first.value);
		assertEquals("Hello", list.last.value);
		assertTrue(list.first.next == null);
		assertTrue(list.last.next == null);

		list.add(1, "Hi");
		assertEquals("Hi", list.last.value);
		assertEquals("Hi", list.first.next.value);
		assertTrue(list.last.next == null);
		assertTrue(list.first.next.next == null);

		list.add(2, "Hey");
		assertEquals("Hey", list.last.value);
		assertEquals("Hey", list.first.next.next.value);
		assertEquals("Hi", list.first.next.value);
		assertEquals("Hello", list.first.value);
		assertTrue(list.last.next == null);
		assertTrue(list.first.next.next.next == null);

		list.add(1, "Hola");
		assertEquals("Hola", list.first.next.value);
		assertEquals("Hi", list.first.next.next.value);
		assertTrue(list.first.next.next.next.next == null);
	}

	/**
	 * simple test class to test removing from the linked list
	 */
	@Test
	public void testRemove() {
		SimpleLinkedList<String> list = new SimpleLinkedList<String>();
		list.add(0, "Hello");
		list.add(0, "Hi");
		list.add(1, "Hey");

		list.remove(1);

		assertEquals("Hi", list.first.value);
		assertEquals("Hello", list.first.next.value);
		assertTrue(list.first.next.next == null);

		list.remove(0);

		assertEquals("Hello", list.first.value);
		assertTrue(list.first.next == null);
	}

	/**
	 * simple test class to test removing from the front of the linked list
	 */
	@Test
	public void testRemoveFront() {
		SimpleLinkedList<String> list = new SimpleLinkedList<String>();
		list.add(0, "Hello");
		assertEquals("Hello", list.last.value);
		assertEquals("Hello", list.first.value);
		assertTrue(list.first.next == null);

		list.add(1, "Hi");
		assertEquals("Hi", list.last.value);
		assertEquals("Hi", list.first.next.value);
		assertTrue(list.first.next.next == null);

		list.add(2, "Hey");
		assertEquals("Hey", list.last.value);
		assertEquals("Hey", list.first.next.next.value);
		assertTrue(list.first.next.next.next == null);

		list.remove(0);
		assertEquals("Hi", list.first.value);
		assertEquals("Hey", list.first.next.value);
		assertEquals("Hey", list.last.value);
		assertTrue(list.first.next.next == null);
	}

	/**
	 * simple test class to test removing from the back of the linked list
	 */
	@Test
	public void testRemoveBack() {
		SimpleLinkedList<String> list = new SimpleLinkedList<String>();
		list.add(0, "Hello");
		assertEquals("Hello", list.first.value);
		assertEquals("Hello", list.last.value);
		assertTrue(list.first.next == null);

		list.add(1, "Hi");
		assertEquals("Hi", list.first.next.value);
		assertEquals("Hi", list.last.value);
		assertTrue(list.first.next.next == null);

		list.add(2, "Hey");
		assertEquals("Hey", list.first.next.next.value);
		assertEquals("Hey", list.last.value);
		assertTrue(list.first.next.next.next == null);

		list.remove(2);
		assertEquals("Hi", list.last.value);
		assertEquals("Hi", list.first.next.value);
		assertTrue(list.first.next.next == null);
	}

	/**
	 * simple test class to test removing from the middle of the linked list
	 */
	@Test
	public void testRemoveMiddle() {
		SimpleLinkedList<String> list = new SimpleLinkedList<String>();
		list.add(0, "Hello");
		assertEquals("Hello", list.first.value);
		assertEquals("Hello", list.last.value);
		assertTrue(list.first.next == null);

		list.add(1, "Hi");
		assertEquals("Hi", list.first.next.value);
		assertEquals("Hi", list.last.value);
		assertTrue(list.first.next.next == null);

		list.add(2, "Hey");
		assertEquals("Hey", list.first.next.next.value);
		assertEquals("Hey", list.last.value);
		assertTrue(list.first.next.next.next == null);

		list.remove(1);
		assertEquals("Hello", list.first.value);
		assertEquals("Hey", list.last.value);
		assertEquals("Hey", list.first.next.value);
		assertTrue(list.first.next.next == null);
	}
}