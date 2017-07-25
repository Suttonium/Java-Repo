package P4;

public class SimpleLinkedList<T> {
	public Node<T> first;
	public Node<T> last;

	public SimpleLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void add(int index, T value) {
		// box to store new data
		Node<T> node = new Node<T>(value);

		if (index == 0) { // adding at index 0
			if (first == null) { // list is empty
				first = node;
				last = node;
			} else { // list is not empty
						// node links to first
				node.next = first;
				first = node;
			}
		} else { // adding to non-zero index
			Node<T> current = first;
			// take current to the node at index - 1
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			// node links to node at index (current.next)
			node.next = current.next;
			// node at index-1 (current) links to node
			current.next = node;
			last = node;
		}
	}

	public T remove(int index) {
		Node<T> node = null;

		if (index == 0) { // removing from index 0
			node = first;
			if (first == last) {
				last = null;
			}
			if (first != null) {
				first = first.next;
			}
		} else { // removing from any other index
			Node<T> current = first;
			// take current to the node at index-1
			for (int i = 0; i < index - 1 && current != null; i++) {
				current = current.next;
			}
			// have the node at index-1 (current) link to
			// the node at index+1 (current.next.next)
			if (current != null) {
				node = current.next;
				current.next = current.next.next;
				// last = current;
				// } else if (last.value == null) {
				// last = current;
			} else {
				System.out.println(" Null removing index=" + index);
				last = null;
			}
		}
		if (node != null) {
			return node.value; // return the removed value
		}
		return null;
	}

	@Override
	public String toString() {
		String str = "[";
		Node<T> node = first;
		while (node != null) {
			str += node.value.toString();
			if (node.next != null)
				str += ", ";

			node = node.next;
		}
		str += "]";

		return str;

	}
}