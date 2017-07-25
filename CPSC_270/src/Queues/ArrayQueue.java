package Queues;

/**
 * Array queue implementation
 * 
 * @author Raymond Sutton
 * @version ...
 */
public class ArrayQueue {
    private Object queueArray[];
    private static final int defaultSize = 10;
    private int maxSize;
    private int front;
    private int rear;

    /**
     * creates a new queue with a fixed size
     * 
     * @param size
     */
    public ArrayQueue(int size) {
        maxSize = size + 1;
        rear = 0;
        front = 1;
        queueArray = new Object[maxSize];
    }

    /**
     * creates a new queue with the default size of 10
     */
    public ArrayQueue() {
        this(defaultSize);
    }

    /**
     * resets the queue
     */
    public void clear() {
        rear = 0;
        front = 1;
    }

    /**
     * adds it to the rear of the queue
     * 
     * @param it
     *            Object to be added
     * @return whether or the Object was added
     */
    public boolean enqueue(Object it) {
        if (((rear + 2) % maxSize) == front)
            return false;  // Full
        rear = (rear + 1) % maxSize; // Circular increment
        queueArray[rear] = it;
        return true;
    }

    /**
     * removes the value from the front of the queue
     * 
     * @return the removed Object
     */
    public Object dequeue() {
        if (length() == 0)
            return null;
        Object it = queueArray[front];
        front = (front + 1) % maxSize; // Circular increment
        return it;
    }

    /**
     * returns the length of the queue
     * 
     * @return the length of the queue
     */
    public int length() {
        return ((rear + maxSize) - front + 1) % maxSize;
    }
}
