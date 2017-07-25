package BinaryTree;

/**
 * In-class notes testing some Binary Tree Methods
 * 
 * @author Austin
 *
 */
public class BinTree {
    private Node root;

    /**
     * Initializes a tree. but the root isn't pointing to anything yet ß
     */
    public BinTree() {
        root = null;
    }

    /**
     * Make the dummy tree for testing purposes
     */
    public void makeTree() {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);
        Node n5 = new Node(5, null, null);
        root = new Node(4, n2, n5);
    }

    /**
     * return the root which points to the rest of the tree
     * 
     * @return
     */
    public Node getRoot() {
        return root;
    }

    public String inorder() {
        return inorderHelper(root);
    }

    private String inorderHelper(Node n) {
        if (n != null) {
            return inorderHelper(n.getLeft()) + n.getValue()
                    + inorderHelper(n.getRight());
        }
        return "";
    }

    public String preorder() {
        return preorderHelper(root);
    }

    private String preorderHelper(Node n) {
        if (n != null) {
            return preorderHelper(n.getLeft()) + preorderHelper(n.getRight())
                    + n.getValue();
        }
        return "";
    }

    /**
     * Find a certain value within the tree
     * 
     * @param obj
     *            value to be found
     * @param n
     *            pointer to the left or right node
     * @return true or false if the value is found
     */
    public boolean find(int obj, Node n) {
        if (n == null) {
            return false;
        }
        else if (n.getValue() == (obj)) {
            return true;
        }
        else {
            return (find(obj, n.getLeft()) || find(obj, n.getRight()));
        }
    }

    public boolean isLeaf() {
        return (root.getLeft() == null || root.getRight() == null);
    }

    public static void main(String[] args) {
        BinTree tree = new BinTree();
        tree.makeTree();
        System.out.println(tree.inorder());
    }
}
