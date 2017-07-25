package P4;
/**
 * The SimpleListStack class extends the SimpleLinkedList class and implements
 * the Simple Stack interface
 * 
 * @author Austin
 * 
 * 
 * @param <T>
 *            - generic typing
 */
public class SimpleListStack<T> extends SimpleLinkedList<T> implements SimpleStack<T> {

	/**
	 * Adds the value to the top of the stack
	 * 
	 * @param value
	 *            - the value to be added to the top of the stack
	 */
	@Override
	public void push(T value) {
		add(0, value);
	}

	/**
	 * Removes the top value from the stack
	 * 
	 * @return the removed value
	 */
	@Override
	public T pop() {
		return remove(0);
	}

	/**
	 * @return the top value from the stack; does not add or remove
	 */
	@Override
	public T peek() {
		if (first == null) {
			return null;
		} else {
			return first.value;
		}
	}
}
