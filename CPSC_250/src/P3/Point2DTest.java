package P3;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * test classes to test the Point2D class
 * 
 * @author Austin
 * @param <T>
 *            - generic type
 */
public class Point2DTest<T> {
	/**
	 * simple tests for testing the distance method with integers
	 */
	@Test
	public void testIntegerForDistance() {
		Point2D<Integer> disPoint1Int = new Point2D<Integer>(0, 0);
		Point2D<Integer> disPoint2Int = new Point2D<Integer>(1, 1);
		int distance = (int) disPoint1Int.distance(disPoint2Int);
		assertEquals("checking first distance with integers, (0,0) -> (1,1)", (int) Math.sqrt(2), distance,
				(int) Math.sqrt(2));

		Point2D<Integer> disPoint3Int = new Point2D<Integer>(1, 1);
		Point2D<Integer> disPoint4Int = new Point2D<Integer>(5, 5);
		int distance2 = (int) disPoint3Int.distance(disPoint4Int);
		assertEquals("checking second distance with integers, (1,1) -> (5,5)", (int) 6, distance2, (int) 6);

		Point2D<Integer> disPoint5Int = new Point2D<Integer>(3, 6);
		Point2D<Integer> disPoint6Int = new Point2D<Integer>(10, 12);
		int distance3 = (int) disPoint5Int.distance(disPoint6Int);
		assertEquals("checking third distance with integers, (3,6) -> (10, 12)", (int) 9, distance3, (int) 9);
	}

	/**
	 * simple test for testing the distance method with doubles
	 */
	@Test
	public void testDoubleForDistance() {
		Point2D<Double> disPoint1Double = new Point2D<Double>(0.0, 0.0);
		Point2D<Double> disPoint2Double = new Point2D<Double>(1.1, 1.1);
		assertEquals("checking first distance with doubles, (0.0, 0.0) -> (1.1, 1.1)", 1.555,
				disPoint1Double.distance(disPoint2Double), 1.555 * 1e-3);

		Point2D<Double> disPoint3Double = new Point2D<Double>(2.7, -8.9);
		Point2D<Double> disPoint4Double = new Point2D<Double>(-10.5, 25.7);
		assertEquals("checking second distance with doubles, (2.7, -8.9) -> (-10.5,25.7)", 37.032,
				disPoint3Double.distance(disPoint4Double), 37.032 * 1e-3);

		Point2D<Double> disPoint5Double = new Point2D<Double>(3.4, 6.9);
		Point2D<Double> disPoint6Double = new Point2D<Double>(4.3, -11.7);
		assertEquals("checking third distance with doubles, (3.4, 6.9) -> (4.3, -11.7)", 18.621,
				disPoint5Double.distance(disPoint6Double), 18.621 * 1e-3);
	}

	/**
	 * simple test for testing the magnitude method with integers
	 */
	@Test
	public void testIntegerForMagnitude() {
		Vector2D<Integer> vector1 = new Vector2D<Integer>(1, 1);
		assertEquals("checking magnitude of vector1", Math.sqrt(2), vector1.magnitude(), Math.sqrt(2));

		Vector2D<Integer> vector2 = new Vector2D<Integer>(5, 10);
		assertEquals("checking magnitude of vector2", 11, vector2.magnitude(), 11);

		Vector2D<Integer> vector3 = new Vector2D<Integer>(25, 33);
		assertEquals("checking magnitude of vector3", 41, vector3.magnitude(), 41);
	}

	/**
	 * simple test for testing the magnitude method with doubles
	 */
	@Test
	public void testDoubleForMagnitude() {
		Vector2D<Double> vector4 = new Vector2D<Double>(1.0, 1.0);
		assertEquals("checking magnitude of vector4", Math.sqrt(2), vector4.magnitude(), Math.sqrt(2) * 1e-6);

		Vector2D<Double> vector5 = new Vector2D<Double>(6.7, 8.2);
		assertEquals("checking magnitude of vector5", 10.589, vector5.magnitude(), 10 * 1e-3);

		Vector2D<Double> vector6 = new Vector2D<Double>(-45.6, 38.6);
		assertEquals("checking magnitude of vector6", 59.743, vector6.magnitude(), 59. * 1e-3);
	}

}
