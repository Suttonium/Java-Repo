package P4;

public interface SimpleStack<T> {

	/**
	 * Add the element to top of stack
	 * 
	 * @param value
	 */
	public void push(T value);

	/**
	 * Remove element from top of stack, and return associated value
	 * 
	 * @return stored value
	 */
	public T pop();

	/**
	 * Return value of element at top of stack, but leave in place
	 * 
	 * @return value
	 */
	public T peek();

	/**
	 * Return true if the Stack is empty
	 * 
	 * @return boolean
	 */
	public boolean isEmpty();

}
