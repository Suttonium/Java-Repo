package P4;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Simple test program that tests the push and pop methods of the
 * SimpleListStack class
 * 
 * @author Austin
 *
 */
public class SimpleListStackTest {

	/**
	 * simple test class to test if the stack is empty
	 */
	@Test
	public void testEmpties() {
		SimpleListStack<Integer> expected = new SimpleListStack<Integer>();
		SimpleListStack<Integer> actual = new SimpleListStack<Integer>();

		assertEquals("Checking", expected.toString(), actual.toString());
	}

	/**
	 * simple test class that tests whether or not the push and pop methods were
	 * performed correcly
	 */
	public void testPush() {
		SimpleListStack<Integer> stack = new SimpleListStack<Integer>();
		int[] array = new int[3];
		array[0] = 0;
		array[1] = 1;
		array[2] = 2;

		for (int i = 0; i < array.length; i++) {
			stack.push(array[i]);
		}
		// checks if push was performed correctly
		assertFalse(stack.isEmpty());

		for (int i = 0; i < array.length; i++) {
			Integer x = stack.pop();
			assertEquals("Checking", new Integer(array[i]), x);
		}
		assertTrue(stack.isEmpty());
	}
}
