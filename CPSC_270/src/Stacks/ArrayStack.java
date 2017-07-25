package Stacks;

/**
 * Stack implementation using arrays
 * 
 * @author Raymond Sutton
 * @version ...
 */
public class ArrayStack {
    private Object stackArray[];
    private static final int defaultSize = 10;
    private int maxSize;
    private int top;

    /**
     * constructor that creates a new stack using the given size
     * 
     * @param size
     *            size to make stack
     */
    public ArrayStack(int size) {
        maxSize = size;
        top = 0;
        stackArray = new Object[size];
    }

    /**
     * creates a default stack of size 10
     */
    public ArrayStack() {
        this(defaultSize);
    }

    /**
     * clears the stack
     */
    public void clear() {
        top = 0;
    }

    /**
     * adds it to the top of the stack
     * 
     * @param it
     *            Object to be added
     * @return whether the item was added or not
     */
    public boolean push(Object it) {
        if (top >= maxSize) {
            return false;
        }
        stackArray[top++] = it;
        return true;
    }

    /**
     * removes the top value from the stack
     * 
     * @return the removed Object
     */
    public Object pop() {
        if (top == 0) {
            return null;
        }
        return stackArray[--top];
    }

    /**
     * returns the value at the top of the stack
     * 
     * @return the peeked Object
     */
    public Object peek() {
        if (top == 0) {
            return null;
        }
        return stackArray[top - 1];
    }

    /**
     * returns the lenght of the stack
     * 
     * @return the length of the stack
     */
    public int length() {
        return top;
    }
}
