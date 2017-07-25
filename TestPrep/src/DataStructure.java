
public class DataStructure implements DataStructureADT {
    private Node root;
    private Node current;
    private Node head;
    private Node tail;
    private int sizeOfLL;

    public DataStructure() {
        this.root = null;
        tail = new Node(null);
        current = tail;
        head = new Node(tail);
        sizeOfLL = 0;
    }

    @Override
    public Boolean find(Character c) {
        return findHelper(root, c);
    }

    private Boolean findHelper(Node n, Character c) {
        if (n != null) {
            if (n.getValue().compareTo(c) < 0) {
                return findHelper(n.getRight(), c);
            }
            else if (n.getValue().compareTo(c) > 0) {
                return findHelper(n.getLeft(), c);
            }
            else {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer height() {
        return heightHelper(root);
    }

    private Integer heightHelper(Node n) {
        if (n != null) {
            return Math.max(heightHelper(n.getRight()),
                    heightHelper(n.getLeft())) + 1;
        }
        return 0;
    }

    @Override
    public void insert(Character c) {
        this.root = insertHelper(root, c);
    }

    private Node insertHelper(Node n, Character c) {
        if (n == null) {
            return new Node(null, null, c);
        }
        else if (n.getValue().compareTo(c) > 0) {
            n.setLeft(insertHelper(n.getLeft(), c));
        }
        else {
            n.setRight(insertHelper(n.getRight(), c));
        }
        return n;
    }

    @Override
    public Boolean isBalanced() {
        return isBalancedHelper(root);
    }

    private Boolean isBalancedHelper(Node n) {
        if (n == null) {
            return true;
        }
        int leftHeight = heightHelper(n.getLeft());
        int rightHeight = heightHelper(n.getRight());

        return Math.abs(leftHeight - rightHeight) <= 1
                && isBalancedHelper(n.getLeft())
                && isBalancedHelper(n.getRight());
    }

    @Override
    public Integer position(Character c) {
        return posHelper(root, c, 0);
    }

    private Integer posHelper(Node n, Character c, Integer pos) {
        if (n != null) {
            if (n.getValue().compareTo(c) < 0) {
                return posHelper(n.getRight(), c, 2 * pos + 2);
            }
            else if (n.getValue().compareTo(c) > 0) {
                return posHelper(n.getLeft(), c, 2 * pos + 1);
            }
            else {
                return pos;
            }
        }
        return -1;
    }

    @Override
    public String preorder() {
        return preorderHelper(root);
    }

    private String preorderHelper(Node n) {
        if (n != null) {
            return n.getValue() + preorderHelper(n.getLeft())
                    + preorderHelper(n.getRight());
        }
        return "";
    }

    @Override
    public void remove(Character c) {
        this.root = removeHelper(root, c);
    }

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
            if (n.getRight() == null) {
                return n.getLeft();
            }
            else if (n.getLeft() == null) {
                return n.getRight();
            }
            else {
                Node temp = getMax(n.getLeft());
                n.setValue(temp.getValue());
                n.setLeft(deleteMax(n.getLeft()));
            }
        }
        return n;
    }

    private Node getMax(Node n) {
        if (n.getRight() == null) {
            return n;
        }
        return getMax(n.getRight());
    }

    private Node deleteMax(Node n) {
        if (n.getRight() == null) {
            return n.getLeft();
        }
        n.setRight(deleteMax(n.getRight()));
        return n;
    }

    @Override
    public Integer curPos() {
        Node temp = head.getNext();
        int i;
        for (i = 0; temp != current; i++) {
            temp = temp.getNext();
        }
        return i;
    }

    @Override
    public Object get() throws RuntimeException {
        if (current != head && current != tail) {
            return current.getValue();
        }
        throw new RuntimeException();
    }

    @Override
    public void insertLL(Character c) {
        current.setNext(new Node(current.getNext(), current.getValue()));
        current.setValue(c);
        if (tail == current) {
            tail = current.getNext();
        }
        sizeOfLL++;
    }

    @Override
    public Integer length() {
        return sizeOfLL;
    }

    @Override
    public void moveToStart() {
        current = head.getNext();
    }

    @Override
    public void next() {
        if (current != tail) {
            current = current.getNext();
        }
    }

    @Override
    public void prev() {
        if (current == head.getNext()) {
            return;
        }
        Node temp = head;
        while (temp != current) {
            temp = temp.getNext();
        }
        current = temp;
    }

    @Override
    public void removeLL() {
        if (current == tail) {
            return;
        }
        current.setValue(current.getNext().getValue());
        if (current.getNext() == tail) {
            tail = current;
        }
        current.setNext(current.getNext().getNext());
    }

    @Override
    public void insertSorted(Character c) {
        moveToStart();
        for (int i = 0; i < sizeOfLL; i++) {
            if (current == null || current.getValue() == null) {
                insertLL(c);
            }
            else if (current.getValue() <= c) {
                current = current.getNext();
            }
        }
        insertLL(c);
        sizeOfLL++;
    }

    @Override
    public void removeMaxLeaf() {
        deleteMaxLeafHelper(root);
    }

    private void deleteMaxLeafHelper(Node n) {
        if (n.getLeft() == null && n.getRight() == null) {
            remove(n.getValue());
        }
        else if (n.getRight() == null) {
            deleteMaxLeafHelper(n.getLeft());
        }
        else {
            deleteMaxLeafHelper(n.getRight());
        }
    }

    public String toString() {
        moveToStart();
        String s = "";
        while (current.getNext() != null) {
            s += current.getValue();
            current = current.getNext();
        }
        return s;
    }
}
