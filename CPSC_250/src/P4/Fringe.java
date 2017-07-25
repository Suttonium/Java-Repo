package P4;
/**
 * Interface for the Fringe class that handles coordinating the planner nodes to
 * the planner
 * 
 * @author dconner
 *
 */
public interface Fringe {

	/**
	 * Return the maximum size of the fringe during planning (This will require
	 * you to keep track of this when inserting elements)
	 * 
	 * @return maximum fringe size during planning
	 */
	public int getMaxFringe();

	/**
	 * Return the total number of expansions (pops) during planning
	 * 
	 * @return number of expansions
	 */
	public int getExpansions();

	/**
	 * Return the current size of the fringe
	 * 
	 * @return size of fringe
	 */
	public int getSize();

	/**
	 * insert a planner node into the fringe The planner node contains a
	 * reference to the graph vertex, current cost from start, and current path
	 * 
	 * @param pn
	 */
	public void insert(PlannerNode pn);

	/***
	 * Get the next planning node from the current fringe
	 * 
	 * @return
	 */
	public PlannerNode pop();

	/**
	 * Check if there are elements in the fringe
	 * 
	 * @return true if fringe is empty
	 */
	public boolean isEmpty();

	/**
	 * Return string that reports the implementation type (e.g. Stack/Queue) and
	 * planning statistics (expansions, max fringe size, current fringe size)
	 * 
	 * @return formated string with data
	 */
	public String toString();
}
