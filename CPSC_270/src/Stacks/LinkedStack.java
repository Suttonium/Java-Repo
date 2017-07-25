package Stacks;

import LinkedList.Node;

/**
 * List stack implementation
 * 
 * @author Raymond Sutton
 * @version ...
 */
public class LinkedStack {
    private Node top;
    private int size;

    /**
     * creates a new stack
     */
    public LinkedStack() {
        top = null;
        size = 0;
    }

    /**
     * creates a new stack
     * 
     * @param size
     */
    public LinkedStack(int size) {
        top = null;
        size = 0;
    }

    /**
     * clears the stack
     */
    public void clear() {
        top = null;
        size = 0;
    }

    /**
     * adds it to the top of the stack
     * 
     * @param it
     *            Object to be added
     * @return whether it was added or not
     */
    public boolean push(Character it) {
        top = new Node(it, top);
        size++;
        return true;
    }

    /**
     * removes the top value of the stack
     * 
     * @return the removed Object
     */
    public Object pop() {
        if (top == null) {
            return null;
        }
        Object it = top.element();
        top = top.next();
        size--;
        return it;
    }

    /**
     * returns the top value in the stack
     * 
     * @return the top value in the stack
     */
    public Object peek() {
        if (top == null) {
            return null;
        }
        return top.element();
    }

    public int length() {
        return size;
    }
}
