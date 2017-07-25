package P4;
/**
 * The FringeStack class implements the Fringe interface and uses the methods to
 * work with stacks
 * 
 * @author Austin
 *
 */
public class FringeStack implements Fringe {
	private SimpleListStack<PlannerNode> stack;
	private int size;
	private int maxSize;
	private int expansions;

	/**
	 * basic constructor which instantiates a stack from the SimpleListStack
	 * class
	 */
	public FringeStack() {
		stack = new SimpleListStack<PlannerNode>();
	}

	/**
	 * @return the max size of the fringe within the binary search tree
	 */
	@Override
	public int getMaxFringe() {
		return maxSize;
	}

	/**
	 * @return the number of expansions in the binary search tree
	 */
	@Override
	public int getExpansions() {
		return expansions;
	}

	/**
	 * @return the size of fringe after a push into the stack
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * inserts a PlannerNode into the binary search tree
	 * 
	 * @param PlannerNode
	 *            - the node to be inserted into the stack
	 */
	@Override
	public void insert(PlannerNode pn) {
		stack.push(pn);
		size++;
		if (size > maxSize) {
			maxSize = size;
		}
	}

	/**
	 * removes or pops the top value from the stack
	 * 
	 * @return the value popped from the stack
	 */
	@Override
	public PlannerNode pop() {
		expansions++;
		size--;
		return stack.pop();
	}

	/**
	 * @return the whether or not the stack is empty
	 */
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

}
