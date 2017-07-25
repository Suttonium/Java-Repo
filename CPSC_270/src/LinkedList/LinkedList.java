package LinkedList;

/**
 * Implentation of the CList ADT
 * 
 * @author Raymond Sutton
 * @version 20170210
 *
 */
public class LinkedList implements LinkedListADT {
    private Node head;
    private Node tail;
    private Node current;
    private int listSize;
    private int possibleSizeForSelection;

    /**
     * Constructor calling the clear() method which creates a head and tail
     * dummy node
     */
    public LinkedList() {
        clear();
    }

    /**
     * create the head and tail of the list
     */
    private void clear() {
        tail = new Node(null);
        current = tail;
        head = new Node(tail);
        listSize = 0;
    }

    /**
     * (non-Javadoc)
     * 
     * @see LinkedListADT#curPos()
     */
    @Override
    public Integer curPos() {
        if (length() == 0) {
            return -1;
        }
        Node temp = head.next();
        int i;
        for (i = 0; current != temp; i++) {
            temp = temp.next();
        }
        return i;
    }

    /**
     * (non-Javadoc)
     * 
     * @see LinkedListADT#cut()
     */
    @Override
    public void cut() {
        for (int i = 0; i < possibleSizeForSelection; i++) {
            remove();
            current = current.next();
        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see LinkedListADT#get()
     */
    @Override
    public Object get() throws RuntimeException {
        if (current == tail) {
            throw new RuntimeException();
        }
        return current.element();
    }

    /**
     * (non-Javadoc)
     * 
     * @see LinkedListADT#insert(java.lang.Character)
     */
    @Override
    public void insert(Character c) {
        current.setNext(new Node(current.element(), current.next()));
        current.setElement(c);
        if (tail == current) {
            tail = current.next();
        }
        listSize++;
    }

    /**
     * (non-Javadoc)
     * 
     * @see LinkedListADT#length()
     */
    @Override
    public Integer length() {
        return listSize;
    }

    /**
     * (non-Javadoc)
     * 
     * @see LinkedListADT#moveToStart()
     */
    @Override
    public void moveToStart() {
        current = head.next();
    }

    /**
     * (non-Javadoc)
     * 
     * @see LinkedListADT#next()
     */
    @Override
    public void next() {
        if (current != tail) {
            current = current.next();
        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see LinkedListADT#prev()
     */
    @Override
    public void prev() {
        if (head.next() == current) {
            return;
        }
        Node temp = head;
        while (temp.next() != current) {
            temp = temp.next();
        }
        current = temp;
    }

    /**
     * (non-Javadoc)
     * 
     * @see LinkedListADT#remove()
     */
    // <a,b|d,e,f,g>
    @Override
    public void remove() {
        if (current == tail) {
            return;
        }
        current.setElement(current.next().element());
        if (current.next() == tail) {
            tail = current;
        }
        current.setNext(current.next().next());
        listSize--;
    }

    /**
     * (non-Javadoc)
     * 
     * @see LinkedListADT#select(java.lang.Integer)
     */
    @Override
    public void select(Integer n) {
        Node temp = current;
        for (int j = 0; j < n && temp.next() != tail; j++) {
            temp = temp.next();
        }
        possibleSizeForSelection = n;
    }

    public void sortedInsert(Character c) {
        moveToStart();
        for (int i = 0; i < listSize; i++) {
            if (current == null || current.element() == null) {
                insert(c);
            }
            else if (current.element() <= c) {
                current = current.next();
            }
        }
        insert(c);
        listSize++;
    }

    public String toString() {
        moveToStart();
        String s = "";
        while (current.next() != null) {
            s += current.element();
            current = current.next();
        }
        return s;
    }

}
