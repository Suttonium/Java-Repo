package P4;
public interface SimpleQueue<T> {

	/**
	 * Add the element to back of line
	 * 
	 * @param value
	 */
	public void enqueue(T value);

	/**
	 * Remove element from front of line, and return associated value
	 * 
	 * @return stored value
	 */
	public T dequeue();

	/**
	 * Return value of element at front of line, but leave in place
	 * 
	 * @return value
	 */
	public T peek();

	/**
	 * Return true if the Queue is empty
	 * 
	 * @return boolean
	 */
	public boolean isEmpty();

}