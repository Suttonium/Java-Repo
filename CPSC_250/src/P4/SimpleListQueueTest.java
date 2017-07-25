package P4;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Simple test program to test the enqueue and dequeue methods of the
 * SimpleListQueue class
 * 
 * @author Austin
 *
 */
public class SimpleListQueueTest {

	/**
	 * simple test class to test if the queue is empty
	 */
	@Test
	public void testEmpties() {
		SimpleListQueue<Integer> expected = new SimpleListQueue<Integer>();
		SimpleListQueue<Integer> actual = new SimpleListQueue<Integer>();

		assertEquals("Checking", expected.toString(), actual.toString());
	}

	/**
	 * simple test class that tests whether or not the enqueue and dequeue
	 * methods were performed correctly
	 */
	@Test
	public void testEnqueueAndDequeue() {
		SimpleListQueue<Integer> queue = new SimpleListQueue<Integer>();
		int[] array = new int[3];
		array[0] = 0;
		array[1] = 1;
		array[2] = 2;
		for (int i = 0; i < array.length; i++) {
			queue.enqueue(array[i]);
		}
		// checks that enqueue was performed correctly
		assertFalse(queue.isEmpty());

		for (int i = 0; i < array.length; i++) {
			Integer x = queue.dequeue();
			assertEquals("Checking", new Integer(array[i]), x);
		}
		// checks that dequeue was performed correctly
		assertTrue(queue.isEmpty());
	}
}
