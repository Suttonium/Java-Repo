package P4;
/**
 * Class that extends the SimpleLinkedList class and implements the SimpleQueue
 * interface
 * 
 * @author Austin
 *
 * @param <T>
 */
public class SimpleListQueue<T> extends SimpleLinkedList<T> implements SimpleQueue<T> {

	/**
	 * adds the value parameter into the queue
	 * 
	 * @param value
	 *            - the value to be added into the queue
	 */
	@Override
	public void enqueue(T value) {
		Node<T> link = new Node<T>(value);
		if (isEmpty()) {
			link.next = first;
			first = link;
			last = link;
		} else {
			last.next = link;
			last = link;
			last.next = null;
		}
	}

	/**
	 * removes the last value from the queue
	 * 
	 * @return the removed value
	 */
	@Override
	public T dequeue() {
		Node<T> dequeue = first;
		if (first == null) {
			return null;
		} else {
			first = first.next;
		}
		return dequeue.value;
	}

	/**
	 * @return the last value added into the queue; does not add or remove
	 */
	@Override
	public T peek() {
		Node<T> peek = first;
		if (first == null) {
			return null;
		} else {
			return peek.value;
		}
	}

}
