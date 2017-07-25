package Queues;

/**
 * Linked queue implementation
 * 
 * @author Raymond Sutton
 * @version ...
 */
public class LinkedQueue {
    private Node front;
    private Node rear;
    private int size;

    private static class Node {
        private Node next;
        private Object value;

        public Node(Object val, Node n) {
            this.next = n;
            this.value = val;
        }

        public Node(Node n) {
            this.next = n;
            this.value = null;
        }

        @SuppressWarnings("unused")
        public void setValue(Object val) {
            this.value = val;
        }

        public Object getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            this.next = n;
        }

    }

    /**
     * creates a new queue
     */
    public LinkedQueue() {
        initialize();
    }

    /**
     * creates a new queue with a specific size
     * 
     * @param size
     *            size of new queue
     */
    public LinkedQueue(int size) {
        initialize();
    }

    /**
     * private method to create queue
     */
    private void initialize() {
        front = rear;
        rear = new Node(null);
        size = 0;
    }

    /**
     * add it to the rear of the queue
     * 
     * @param it
     *            Object to be added
     * @return whether or not the Object was added
     */
    public boolean enqueue(Object it) {
        rear.setNext(new Node(it, null));
        rear = rear.getNext();
        size++;
        return true;
    }

    /**
     * remove the front element
     * 
     * @return the removed element
     */
    public Object dequeue() {
        if (size == 0)
            return null;
        Object it = front.getNext().getValue(); // Store the value
        front.setNext(front.getNext().getNext()); // Advance front
        if (front.getNext() == null)
            rear = front; // Last element
        size--;
        return it; // Return element
    }

    /**
     * look at the front value
     * 
     * @return the front value
     */
    public Object peek() {
        if (size == 0)
            return null;
        return front.getNext().getValue();
    }

    /**
     * returns the size of the queue
     * 
     * @return the size of the queue
     */
    public int length() {
        return size;
    }
}
