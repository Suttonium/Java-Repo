package P3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test cases for the circle shape
 * 
 * @author Austin
 *
 * @param <T>
 *            - generic type
 */
public class CircleTest<T> {

	/** Simple test of instantiating a Circle object */
	@Test
	public void test1() {
		Circle<Double> circ = new Circle<Double>(new Point2D<Double>(10., 20.), 5.0);
		assertEquals("check x", 10., circ.getCenter().getX(), 10. * 1e-6);
		assertEquals("check y", 20., circ.getCenter().getY(), 20. * 1e-6);
		assertEquals("check r", 5., circ.getRadius(), 5. * 1e-6);

		assertEquals("check centroid x because center = centroid", 10., circ.getCentroid().getX(), 5. * 1e-3);
		assertEquals("check centroid y because center = centroid", 20., circ.getCentroid().getY(), 5. * 1e-3);
	}

	/**
	 * simple test for the getter methods for inscribing and circumscribing
	 * radii because they equal the radius
	 */
	@Test
	public void test2() {
		Circle<Double> circ = new Circle<Double>(new Point2D<Double>(10., 20.), 5.0);
		assertEquals("testing getter method for inscribing radius", 5., circ.getInscribingRadius(), 5. * 1e-3);
		assertEquals("testing getter method for circumscribing radius", 5., circ.getCircumscribingRadius(), 5. * 1e-3);
	}

	/**
	 * simple test to check the equals method return values of true or false
	 */
	@Test
	public void test3() {
		Circle<Double> circ = new Circle<Double>(new Point2D<Double>(10., 20.), 5.0);
		Circle<Double> circ2 = new Circle<Double>(new Point2D<Double>(12., 10.), 7.0);
		assertFalse("should return false", circ.equals(circ2));

		Circle<Double> circ3 = new Circle<Double>(new Point2D<Double>(7., 9.), 4.0);
		Circle<Double> circ4 = new Circle<Double>(new Point2D<Double>(7., 9.), 4.0);
		assertTrue("should return true", circ3.equals(circ4));
	}

	/**
	 * simple test to check the compareTo return values of -1, 0, and 1
	 */
	@Test
	public void test4() {
		Circle<Double> circ = new Circle<Double>(new Point2D<Double>(10., 20.), 5.0);
		Circle<Double> circ2 = new Circle<Double>(new Point2D<Double>(12., 10.), 7.0);
		assertEquals("testing first compareTo method, should return -1", -1, circ.compareTo(circ2), -1);

		Circle<Double> circ3 = new Circle<Double>(new Point2D<Double>(7., 9.), 4.0);
		Circle<Double> circ4 = new Circle<Double>(new Point2D<Double>(7., 9.), 4.0);
		assertEquals("testing second compareTo method, should return 0", 0, circ3.compareTo(circ4), 0);

		Circle<Double> circ5 = new Circle<Double>(new Point2D<Double>(10., 11.), 7.0);
		Circle<Double> circ6 = new Circle<Double>(new Point2D<Double>(9., 8.), 6.0);
		assertEquals("testing third compareTo method, should return 1", 1, circ5.compareTo(circ6), 1);
	}
}
