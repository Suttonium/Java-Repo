package P4;
/**
 * The FringeQueue class implements the Fringe interface and uses the methods to
 * work with queues
 * 
 * @author Austin
 *
 */
public class FringeQueue implements Fringe {
	private SimpleListQueue<PlannerNode> queue;
	private int size;
	private int maxSize;
	private int expansions;

	/**
	 * basic constructor which instatiates a queue from the SimpleListQueue
	 * class
	 */
	public FringeQueue() {
		queue = new SimpleListQueue<PlannerNode>();
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
	 * @return the size of the fringe after an enqueue into the queue
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * inserts a PlannerNode into the binary search tree
	 * 
	 * @param PlannerNode
	 *            - the node to be inserted into the queue
	 */
	@Override
	public void insert(PlannerNode pn) {
		queue.enqueue(pn);
		size++;
		if (size > maxSize) {
			maxSize = size;
		}
	}

	/**
	 * removes or dequeues the value from the queue
	 * 
	 * @return the value dequeued from the queue
	 */
	@Override
	public PlannerNode pop() {
		expansions++;
		size--;
		return queue.dequeue();
	}

	/**
	 * @return whether or not the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
