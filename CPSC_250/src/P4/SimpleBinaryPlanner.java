package P4;

/**
 * Implements a planner for a binary graph with two-branches per node
 * Graph vertices are labeled with parent node label and "0" or "1" suffix.
 * E.g. "0101" is on fourth layer from root, then "0", "01", "010", and finally "0101".
 * 
 * @author David Conner (CPSC 250)
 *
 */

import java.util.ArrayList;

public class SimpleBinaryPlanner {

	/**
	 * Returns a path through the binary tree from root vertex to the goal node
	 * 
	 * @param goal
	 *            - String value of the binary vertex (e.g. "00101")
	 * @param fringe
	 *            - approach to search (e.g. particular implementation of Fringe
	 *            interface)
	 * @return plan - ArrayList of strings from root to goal
	 */
	public static PlannerNode getPlan(String goal, Fringe fringe) {
		if (fringe == null)
			return null;

		if (goal.equals(""))
			return null;

		if (goal.length() > 16) {
			System.out.println(" Limited to 16-bits!  (" + goal + ")");
			return null;
		}
		// Insert the root node into the fringe
		fringe.insert(new PlannerNode("", 0, new ArrayList<String>()));

		// Planner loop
		while (!fringe.isEmpty()) {
			PlannerNode node = fringe.pop();
			if (node.isGoal(goal)) { // We
				return node;
			}

			// System.out.println(" Expanding node "+node.getVertex());

			// Binary tree has two child nodes for each vertex
			if (node.getVertex().length() < 16) {
				fringe.insert(new PlannerNode(node.getVertex() + "0", node.getCost() + 1, node.getCurrentPlan()));
				fringe.insert(new PlannerNode(node.getVertex() + "1", node.getCost() + 1, node.getCurrentPlan()));
			}
			// else
			// {
			// System.out.println(" reached terminal depth of 16-bit number");
			// }
		}

		// If we get here, we failed to find a new plan
		return null;
	}

	/**
	 * print the current plan
	 * 
	 * @param current
	 *            plan to be printed
	 */
	public static String toString(String goal, PlannerNode pn, Fringe fringe) {
		System.out.println();
		String str = " --- Goal=" + goal + " ---\n plan=[ ";
		if (pn != null) {
			ArrayList<String> plan = pn.getCurrentPlan();
			for (int i = 1; i < plan.size(); i++) // don't bother with printing
													// root vertex
			{
				str += plan.get(i);
				if (i < plan.size() - 1)
					str += ", ";

				if (plan.size() > 10 && i % 8 == 0 && i != plan.size() - 1)
					str += "\n        "; // add newline every so often unless
											// short or end of line

			}
		}
		str += " ] cost=" + pn.getCost();
		str += "\n  Fringe Statistics: " + fringe;
		return str;
	}

	/**
	 * goalString - returns binary value string with leading zeros
	 * 
	 * @param value
	 * @param length
	 * @return String
	 */
	public static String goalString(int value, int length) {
		String str = Integer.toBinaryString(value);
		while (str.length() < length)
			str = "0" + str;
		return str;
	}

	/**
	 * Main method to test the planner system
	 * 
	 * @param args
	 *            command line arguments; first argument is number to search for
	 *            in binary form
	 */

	public static void main(String[] args) {

		// For n-bit with leading 0, we need to add that ourselves
		String goal = "1" + Integer.toBinaryString(6);// 218);//48758);

		if (args.length > 0)
			goal = args[0];

		System.out.println(" Searching for " + goal);

		// Demonstrate with Stack based planning fringe
		Fringe fringeStack = new FringeStack();
		PlannerNode stackPlan = SimpleBinaryPlanner.getPlan(goal, fringeStack);
		System.out.println(SimpleBinaryPlanner.toString(goal, stackPlan, fringeStack));

		// Demonstrate with a Queue based planning fringe
		Fringe fringeQueue = new FringeQueue();
		PlannerNode queuePlan = SimpleBinaryPlanner.getPlan(goal, fringeQueue);
		System.out.println(SimpleBinaryPlanner.toString(goal, queuePlan, fringeQueue));

	}

}
