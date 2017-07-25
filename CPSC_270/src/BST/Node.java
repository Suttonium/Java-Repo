package BST;

/**
 * Node class used for storing values within the CBst implementation
 * 
 * @author Raymond Sutton
 * @version 03272017
 *
 */
public class Node {
    private Node left;
    private Node right;
    private Character value;

    /**
     * constructor which creates a new Node object using a left and right
     * pointer, and a character value
     * 
     * @param l
     *            pointer to the left child
     * @param r
     *            pointer to the right child
     * @param val
     *            value to be inserted into the Node
     */
    public Node(Node l, Node r, Character val) {
        this.left = l;
        this.right = r;
        this.value = val;
    }

    /**
     * returns the left child of the Node
     * 
     * @return left child of Node
     */
    public Node getLeft() {
        return left;
    }

    /**
     * sets the left child of the Node
     * 
     * @param left
     *            Node to be set as left child
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * returns the right child of the Node
     * 
     * @return right child of Node
     */
    public Node getRight() {
        return right;
    }

    /**
     * sets the right child of the Node
     * 
     * @param right
     *            Node to be set as right child
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * returns the Character value within the Node
     * 
     * @return the Character value within the Node
     */
    public Character getValue() {
        return value;
    }

    /**
     * sets the value of a specific Node
     * 
     * @param value
     *            the value to be placed inside the Node
     */
    public void setValue(Character value) {
        this.value = value;
    }

}
