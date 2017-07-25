package P4;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SimpleBinaryPlannerTest {

	@Test
	public void testNull() {
		String goal = "test";
		PlannerNode stackPlan = SimpleBinaryPlanner.getPlan(goal, null);
		assertNull(stackPlan);

	}

	@Test
	public void testEmptyStack() {
		String goal = "";
		Fringe fringeStack = new FringeStack();
		PlannerNode stackPlan = SimpleBinaryPlanner.getPlan(goal, fringeStack);

		assertNull(stackPlan);

	}

	@Test
	public void testEmptyQueue() {
		String goal = "";
		Fringe fringeQueue = new FringeQueue();
		PlannerNode queuePlan = SimpleBinaryPlanner.getPlan(goal, fringeQueue);

		assertNull(queuePlan);

	}

	@Test
	public void testInvalidStack() {
		String goal = "test"; // cannot find this goal
		Fringe fringeStack = new FringeStack();
		PlannerNode stackPlan = SimpleBinaryPlanner.getPlan(goal, fringeStack);

		assertNull(stackPlan);
		int test = 0;
		for (int i = 0; i <= 16; i++)
			test += Math.pow(2, i);

		System.out.println(" Number of nodes in tree = " + test);
		assertEquals("max expansions", 131071, fringeStack.getExpansions());

	}

	@Test
	public void testInvalidQueue() {
		String goal = "test";
		Fringe fringeQueue = new FringeQueue();
		PlannerNode queuePlan = SimpleBinaryPlanner.getPlan(goal, fringeQueue);

		assertNull(queuePlan);
		assertEquals("max expansions", 131071, fringeQueue.getExpansions());

	}

	@Test
	public void test0101Queue() {
		String goal = "0101";
		Fringe fringe = new FringeQueue();
		PlannerNode planNode = SimpleBinaryPlanner.getPlan(goal, fringe);
		System.out.println(SimpleBinaryPlanner.toString(goal, planNode, fringe));
		assertEquals("max expansions", 21, fringe.getExpansions());
		assertEquals("cost", 4, planNode.getCost());
		assertEquals("terminal", goal, planNode.getCurrentPlan().get(planNode.getCurrentPlan().size() - 1));

	}

	@Test
	public void test0101Stack() {
		String goal = "0101";
		Fringe fringe = new FringeStack();
		PlannerNode planNode = SimpleBinaryPlanner.getPlan(goal, fringe);
		System.out.println(SimpleBinaryPlanner.toString(goal, planNode, fringe));
		assertEquals("max expansions", 81923, fringe.getExpansions());
		assertEquals("cost", 4, planNode.getCost());
		assertEquals("terminal", goal, planNode.getCurrentPlan().get(planNode.getCurrentPlan().size() - 1));

	}

	@Test
	public void testGoalString() {
		assertEquals("0011", SimpleBinaryPlanner.goalString(3, 4));
		assertEquals("11", SimpleBinaryPlanner.goalString(3, 2));
		assertEquals("1000", SimpleBinaryPlanner.goalString(8, 4));
		assertEquals("0000", SimpleBinaryPlanner.goalString(0, 4));
		assertEquals("0000", SimpleBinaryPlanner.goalString(0, 4));
		assertEquals("1111", SimpleBinaryPlanner.goalString(15, 4));

	}

}
