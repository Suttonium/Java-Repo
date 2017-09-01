package BST;

/**
 * implementation for the CBst ADT
 * 
 * @author Raymond Sutton
 * @version 03272017
 *
 */
// testing
public class BST implements BST_ADT {
    private Node root;

    /**
     * creates an empty tree by calling clear() method
     */
    public BST() {
        clear();
    }

    /**
     * called by the constructor to create an empty tree
     */
    private void clear() {
        this.root = null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see CBstADT#find(java.lang.Character)
     */
    @Override
    public Boolean find(Character c) {
        return findHelper(root, c);
    }

    /**
     * private method to find a specific value in the tree
     * 
     * @param n
     *            Node to begin traversal of tree
     * @param c
     *            value method is looking for
     * @return true or false depending on if the value was found in the tree
     */
    private Boolean findHelper(Node n, Character c) {
        if (n == null) {
            return false;
        }
        else if (n.getValue().compareTo(c) == 0) {
            return true;
        }
        else if (n.getValue().compareTo(c) > 0) {
            return findHelper(n.getLeft(), c);
        }
        else {
            return findHelper(n.getRight(), c);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see CBstADT#height()
     */
    @Override
    public Integer height() {
        return heightHelper(root);
    }

    /**
     * private method to determine the longest path from the root to the deepest
     * Node
     * 
     * @param n
     *            Node to begin traversal
     * @return the height of the tree
     */
    private Integer heightHelper(Node n) {
        if (n == null) {
            return 0;
        }
        return Math.max(heightHelper(n.getLeft()), heightHelper(n.getRight()))
                + 1;
    }

    /*
     * (non-Javadoc)
     * 
     * @see CBstADT#insert(java.lang.Character)
     */
    @Override
    public void insert(Character c) {
        this.root = insertHelper(root, c);
    }

    /**
     * private helper method to perform the insert method
     * 
     * @param n
     *            the Node to begin the traversal of the tree
     * @param c
     *            value to be inserted into the tree
     * @return the created Node that is inserted into the tree
     */
    private Node insertHelper(Node n, Character c) {
        if (n == null) {
            return new Node(null, null, c);
        }
        else if (n.getValue().compareTo(c) > 0) {
            n.setLeft(insertHelper(n.getLeft(), c));
        }
        else if (n.getValue().compareTo(c) < 0) {
            n.setRight(insertHelper(n.getRight(), c));
        }
        return n;
    }

    /*
     * (non-Javadoc)
     * 
     * @see CBstADT#isBalanced()
     */
    @Override
    public Boolean isBalanced() {
        return isBalancedHelper(root);
    }

    /**
     * private helper method to assert the BST is balanced
     * 
     * @param n
     *            root Node to begin traversal
     * @return whether or not the tree is balanced
     */
    private Boolean isBalancedHelper(Node n) {
        if (n == null) {
            return true;
        }
        int leftHeight = heightHelper(n.getLeft());
        int rightHeight = heightHelper(n.getRight());

        return (Math.abs(leftHeight - rightHeight) <= 1)
                && isBalancedHelper(n.getRight())
                && isBalancedHelper(n.getLeft());
    }

    /*
     * (non-Javadoc)
     * 
     * @see CBstADT#position(java.lang.Character)
     */
    @Override
    public Integer position(Character c) {
        return findPosition(root, c, 0);
    }

    /**
     * private helper method to execute the position method
     * 
     * @param n
     *            node to begin traversal
     * @param c
     *            character we want the position of
     * @param pos
     *            original root position
     * @return the position of c
     */
    private Integer findPosition(Node n, Character c, Integer pos) {
        if (find(c)) {
            if (n.getValue().compareTo(c) == 0) {
                return pos;
            }
            else if (n.getValue().compareTo(c) < 0) {
                return findPosition(n.getRight(), c, ((2 * pos) + 2));
            }
            else {
                return findPosition(n.getLeft(), c, ((2 * pos) + 1));
            }
        }
        return -1;
    }

    /*
     * (non-Javadoc)
     * 
     * @see CBstADT#preorder()
     */
    @Override
    public String preorder() {
        return preorderHelper(root);
    }

    /**
     * private helper method to perfrom the preorder method
     * 
     * @param n
     * @return
     */
    private String preorderHelper(Node n) {
        if (n != null) {
            return n.getValue() + preorderHelper(n.getLeft())
                    + preorderHelper(n.getRight());
        }
        return "";
    }

    /*
     * (non-Javadoc)
     * 
     * @see CBstADT#remove(java.lang.Character)
     */
    @Override
    public void remove(Character c) {
        this.root = removeHelper(root, c);
    }

    /**
     * private method that returns the deleted Node from the tree
     * 
     * @param n
     *            Node to begin traversal of tree
     * @param c
     *            value to be removed
     * @return the removed Node
     */
    private Node removeHelper(Node n, Character c) {
        if (n == null) {
            return null;
        }
        if (n.getValue().compareTo(c) > 0) {
            n.setLeft(removeHelper(n.getLeft(), c));
        }
        else if (n.getValue().compareTo(c) < 0) {
            n.setRight(removeHelper(n.getRight(), c));
        }
        else {
            if (n.getLeft() == null) {
                return n.getRight();
            }
            else if (n.getRight() == null) {
                return n.getLeft();
            }
            else {
                Node temp = getMax(n.getLeft());
                n.setValue(temp.getValue());
                n.setLeft(deleteMax(n.getLeft()));
            }
        }
        return n;
    }

    /**
     * private method used by the removeHelper method to find the largest value
     * 
     * @param n
     *            Node to begin traversal of tree
     * @return the Node with the maximum value in the tree
     */
    private Node getMax(Node n) {
        if (n.getRight() == null) {
            return n;
        }
        return getMax(n.getRight());
    }

    /**
     * private method used by the removeHelper method to delete the maximum Node
     * in the tree
     * 
     * @param n
     *            Node to begin traversal of the tree
     * @return the deleted Node
     */
    private Node deleteMax(Node n) {
        if (n.getRight() == null) {
            return n.getLeft();
        }
        n.setRight(deleteMax(n.getRight()));
        return n;
    }

    public void deleteMaxLeaf() {
        deleteMaxLeafHelper(root);
    }

    private void deleteMaxLeafHelper(Node n) {
        if (n.getRight() == null && n.getLeft() == null) {
            remove(n.getValue());
        }
        else if (n.getRight() == null) {
            deleteMaxLeafHelper(n.getLeft());
        }
        else {
            deleteMaxLeafHelper(n.getRight());
        }
    }
}
