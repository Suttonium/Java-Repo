package P3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * test classes to test the rectangle shape
 * 
 * @author Austin
 * @param <T>
 *            - generic type
 */
public class RectangleTest<T> {
	/**
	 * testing the centroid determinations
	 */
	@Test
	public void testRectangleCentroid() {
		Rectangle<Double> rec = new Rectangle<Double>(new Point2D<Double>(2., 3.), new Point2D<Double>(3., 1.));
		assertEquals("checking centroid x", 2.5, rec.getCentroid().getX(), 2.5 * 1e-3);
		assertEquals("checking centroid y", 2., rec.getCentroid().getY(), 2. * 1e-3);

		Rectangle<Double> rec2 = new Rectangle<Double>(new Point2D<Double>(3., 3.), new Point2D<Double>(4., 1.));
		assertEquals("checking centroid x", 3.5, rec2.getCentroid().getX(), 3.5 * 1e-3);
		assertEquals("checking centroid y", 2., rec2.getCentroid().getY(), 2. * 1e-3);

		Rectangle<Double> rec3 = new Rectangle<Double>(new Point2D<Double>(7., 5.), new Point2D<Double>(9., 4.));
		assertEquals("checking centroid x", 8., rec3.getCentroid().getX(), 8. * 1e-3);
		assertEquals("checking centroid y", 4.5, rec3.getCentroid().getY(), 4.5 * 1e-3);
	}

	/**
	 * testing the circumscribing radius determinations
	 */
	@Test
	public void testCircumscribingRadius() {
		Rectangle<Double> rec = new Rectangle<Double>(new Point2D<Double>(2., 3.), new Point2D<Double>(3., 1.));
		assertEquals("checking circumscribing radius", 1.118, rec.getCircumscribingRadius(), 1.118 * 1e-3);

		Rectangle<Double> rec2 = new Rectangle<Double>(new Point2D<Double>(3., 3.), new Point2D<Double>(4., 2.));
		assertEquals("checking circumscribing radius", 0.707, rec2.getCircumscribingRadius(), 0.707 * 1e-3);

		Rectangle<Double> rec3 = new Rectangle<Double>(new Point2D<Double>(10., 5.), new Point2D<Double>(14., 4.));
		assertEquals("checking circumscribing radius", 2.061, rec3.getCircumscribingRadius(), 2.061 * 1e-3);

	}

	/**
	 * testing the inscribing radius determinations
	 */
	@Test
	public void testInscribingRadius() {
		Rectangle<Double> rec = new Rectangle<Double>(new Point2D<Double>(2., 3.), new Point2D<Double>(3., 1.));
		assertEquals("checking inscribing radius", 1.000, rec.getInscribingRadius(), 1.000 * 1e-3);

		Rectangle<Double> rec2 = new Rectangle<Double>(new Point2D<Double>(4., 3.), new Point2D<Double>(5., 2.));
		assertEquals("checking inscribing radius", 0.707, rec2.getCircumscribingRadius(), 0.707 * 1e-3);

		Rectangle<Double> rec3 = new Rectangle<Double>(new Point2D<Double>(7., 5.), new Point2D<Double>(9., 4.));
		assertEquals("checking inscribing radius", 0.5, rec3.getInscribingRadius(), 0.5 * 1e-3);
	}

	/**
	 * simple test to check whether or not the shapes are equal
	 */
	@Test
	public void testEquals() {
		Rectangle<Double> rec = new Rectangle<Double>(new Point2D<Double>(2., 3.), new Point2D<Double>(3., 1.));
		Rectangle<Double> rec2 = new Rectangle<Double>(new Point2D<Double>(2., 3.), new Point2D<Double>(3., 1.));
		assertTrue("should return true", rec.equals(rec2));

		Rectangle<Double> rec3 = new Rectangle<Double>(new Point2D<Double>(2., 3.), new Point2D<Double>(3., 1.));
		Rectangle<Double> rec4 = new Rectangle<Double>(new Point2D<Double>(7., 5.), new Point2D<Double>(9., 4.));
		assertFalse("should return false", rec3.equals(rec4));
	}

	/**
	 * simple test to compare the two shapes
	 */
	@Test
	public void testCompareTo() {
		Rectangle<Double> rec = new Rectangle<Double>(new Point2D<Double>(2., 3.), new Point2D<Double>(3., 1.));
		Rectangle<Double> rec2 = new Rectangle<Double>(new Point2D<Double>(2., 3.), new Point2D<Double>(3., 1.));
		assertEquals("testing first compareTo method", 0, rec.compareTo(rec2), 0);

		Rectangle<Double> rec3 = new Rectangle<Double>(new Point2D<Double>(2., 3.), new Point2D<Double>(3., 1.));
		Rectangle<Double> rec4 = new Rectangle<Double>(new Point2D<Double>(7., 5.), new Point2D<Double>(9., 4.));
		assertEquals("testing second compareTo method", -1, rec3.compareTo(rec4), -1);

		Rectangle<Double> rec5 = new Rectangle<Double>(new Point2D<Double>(20., 18.), new Point2D<Double>(22., 17.));
		Rectangle<Double> rec6 = new Rectangle<Double>(new Point2D<Double>(7., 5.), new Point2D<Double>(9., 4.));
		assertEquals("testing third compareTo method", 1, rec5.compareTo(rec6), 1);

	}
}
