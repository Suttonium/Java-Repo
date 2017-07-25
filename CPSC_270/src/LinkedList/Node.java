package LinkedList;

/**
 * Node class to create the objects used in CLList
 * 
 * @author Raymond Sutton
 * @version 20170210
 *
 */
public class Node {
    private Character value;
    private Node next;

    /**
     * Constructor that creates a Node object
     * 
     * @param val
     *            the value within the Node
     * @param n
     *            Pointer to the next Node object
     */
    public Node(Character val, Node n) {
        value = val;
        next = n;
    }

    /**
     * Constructor which has no value within the Node, but has a next pointer
     * 
     * @param n
     *            pointer to the next Node object
     */
    public Node(Node n) {
        value = null;
        next = n;
    }

    /**
     * Returns the element value within the Node
     * 
     * @return the element within the Node
     */
    public Character element() {
        return value;
    }

    /**
     * Assigns the value within the Node to a new value
     * 
     * @param newObj
     *            the value to be placed within the Node
     * @return the new value of the Node
     */
    public Character setElement(Character newObj) {
        value = newObj;
        return value;
    }

    /**
     * Pointer to the next Node in the List
     * 
     * @return the next Node in the list
     */
    public Node next() {
        return next;
    }

    /**
     * set the pointer to the next Node
     * 
     * @param next
     *            the pointer to be used
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
