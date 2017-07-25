package P3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * test classes to test the triangle shape
 * 
 * @author Austin
 *
 * @param <T>
 */
public class TriangleTest<T> {

	/**
	 * simple test to certify the correct centroid is being returned
	 */
	@Test
	public void testTriangleCentroid() {
		Triangle<Double> tri = new Triangle<Double>(new Point2D<Double>(1., 1.), new Point2D<Double>(2., 2.),
				new Point2D<Double>(1., 2.));
		assertEquals("checking centroid x", 1.333, tri.getCentroid().getX(), 1.333 * 1e-3);
		assertEquals("checking centroid y", 1.667, tri.getCentroid().getY(), 1.667 * 1e-3);

		Triangle<Double> tri2 = new Triangle<Double>(new Point2D<Double>(2., 3.), new Point2D<Double>(5., 6.),
				new Point2D<Double>(7., 8.));
		assertEquals("checking centroid x", 4.6667, tri2.getCentroid().getX(), 4.6667 * 1e-3);
		assertEquals("checking centroid y", 5.6667, tri2.getCentroid().getY(), 5.6667 * 1e-3);
	}

	/**
	 * simple test to assure the correct inscribing radius is being returned
	 */
	@Test
	public void testTriangleInscribingRadius() {
		Triangle<Double> tri = new Triangle<Double>(new Point2D<Double>(1., 1.), new Point2D<Double>(2., 2.),
				new Point2D<Double>(1., 2.));
		assertEquals("checking inscribing radius", 0.2357, tri.getInscribingRadius(), 0.2357 * 1e-3);

		Triangle<Double> tri2 = new Triangle<Double>(new Point2D<Double>(2., 3.), new Point2D<Double>(5., 6.),
				new Point2D<Double>(7., 8.));
		assertEquals("checking inscribing radius", 1.649, tri2.getInscribingRadius(), 1.649 * 1e-3);
	}

	/**
	 * simple test to assure the correct circumscribing radius is being returned
	 */
	@Test
	public void testTriangleCircumscribingRadius() {
		Triangle<Double> tri = new Triangle<Double>(new Point2D<Double>(1., 1.), new Point2D<Double>(2., 2.),
				new Point2D<Double>(1., 2.));
		assertEquals("checking circumscribing radius", 0.745, tri.calculateCircumscribingRadius(), 0.745 * 1e-3);

		Triangle<Double> tri2 = new Triangle<Double>(new Point2D<Double>(2., 3.), new Point2D<Double>(5., 6.),
				new Point2D<Double>(7., 8.));
		assertEquals("checking circumscribing radius", 3.771, tri2.getCircumscribingRadius(), 3.771 * 1e-3);
	}

	/**
	 * simple test to determine whether or not two triangles are equal
	 */
	@Test
	public void testEquals() {
		Triangle<Double> tri = new Triangle<Double>(new Point2D<Double>(1., 1.), new Point2D<Double>(2., 2.),
				new Point2D<Double>(1., 2.));
		Triangle<Double> tri2 = new Triangle<Double>(new Point2D<Double>(1., 1.), new Point2D<Double>(2., 2.),
				new Point2D<Double>(1., 2.));
		assertTrue("should return true", tri.equals(tri2));

		Triangle<Double> tri3 = new Triangle<Double>(new Point2D<Double>(1., 1.), new Point2D<Double>(2., 2.),
				new Point2D<Double>(1., 2.));
		Triangle<Double> tri4 = new Triangle<Double>(new Point2D<Double>(2., 3.), new Point2D<Double>(5., 6.),
				new Point2D<Double>(7., 8.));
		assertFalse("should return false", tri3.equals(tri4));
	}

	/**
	 * simple test to compare two triangles
	 */
	@Test
	public void testCompareTo() {
		Triangle<Double> tri = new Triangle<Double>(new Point2D<Double>(1., 1.), new Point2D<Double>(2., 2.),
				new Point2D<Double>(1., 2.));
		Triangle<Double> tri2 = new Triangle<Double>(new Point2D<Double>(1., 1.), new Point2D<Double>(2., 2.),
				new Point2D<Double>(1., 2.));
		assertEquals("checking first compareTo method", 0, tri.compareTo(tri2), 0);

		Triangle<Double> tri3 = new Triangle<Double>(new Point2D<Double>(1., 1.), new Point2D<Double>(2., 2.),
				new Point2D<Double>(1., 2.));
		Triangle<Double> tri4 = new Triangle<Double>(new Point2D<Double>(1.5, 1.5), new Point2D<Double>(2., 2.),
				new Point2D<Double>(1.5, 2.));
		assertEquals("checking first compareTo method", -1, tri3.compareTo(tri4), -1);

		Triangle<Double> tri5 = new Triangle<Double>(new Point2D<Double>(2., 3.), new Point2D<Double>(5., 6.),
				new Point2D<Double>(7., 8.));
		Triangle<Double> tri6 = new Triangle<Double>(new Point2D<Double>(1., 1.), new Point2D<Double>(2., 2.),
				new Point2D<Double>(1., 2.));
		assertEquals("checking first compareTo method", 1, tri5.compareTo(tri6), 1);

	}
}
