package Hashing;

public class Node {
    private Node next;
    private Node left;
    private Node right;
    private Character value;

    public Node(Node n, Character val) {
        this.next = n;
        this.value = val;
    }

    public Node(Node n) {
        this.value = null;
        this.next = n;
    }

    public Node(Node n, Node r, Character val) {
        this.left = n;
        this.right = r;
        this.value = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }
}
