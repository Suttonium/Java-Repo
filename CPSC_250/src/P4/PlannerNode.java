package P4;

/**
 * Node used in planner to track current vertex, current plan, and current cost
 * 
 * @author David Conner (CPSC 250)
 * 
 */
import java.util.ArrayList;

public class PlannerNode {

	private String vertex;
	private int cost;
	private ArrayList<String> current_plan;

	/**
	 * Constructor for PlannerNodes
	 * 
	 * @param vtx
	 * @param _cost
	 * @param old
	 */
	public PlannerNode(String vtx, int _cost, ArrayList<String> planToParent) {
		vertex = vtx;
		cost = _cost;
		// Copy the current plan to this node's parent
		current_plan = new ArrayList<String>();
		for (String str : planToParent)
			current_plan.add(str);

		current_plan.add(vtx);

	}

	// Getters
	public String getVertex() {
		return vertex;
	}

	public int getCost() {
		return cost;
	}

	public ArrayList<String> getCurrentPlan() {
		return current_plan;
	}

	public boolean isGoal(String goal) {
		return vertex.equals(goal);
	}

}
