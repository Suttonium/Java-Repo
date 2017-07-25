package P3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * test cases to test square criteria
 * 
 * @author Austin
 * @param <T>
 *            - generic type
 */
public class SquareTest<T> {

	/**
	 * test the squares centroid
	 */
	@Test
	public void testSquareCentroid() {
		Square<Double> square = new Square<Double>(new Point2D<Double>(2., 2.), new Point2D<Double>(1., 1.));
		assertEquals("checking centroid x", 1.5, square.getCentroid().getX(), 1. * 1e-3);
		assertEquals("checking centroid y", 1.5, square.getCentroid().getY(), 1. * 1e-3);

		Square<Double> square2 = new Square<Double>(new Point2D<Double>(5., 5.), new Point2D<Double>(2., 2.));
		assertEquals("checking centroid x", 3.5, square2.getCentroid().getX(), 3.5 * 1e-3);
		assertEquals("checking centroid y", 3.5, square2.getCentroid().getY(), 3.5 * 1e-3);

		Square<Double> square3 = new Square<Double>(new Point2D<Double>(20., 20.), new Point2D<Double>(7., 7.));
		assertEquals("checking centroid x", 13.5, square3.getCentroid().getX(), 6.5 * 1e-3);
		assertEquals("checking centroid y", 13.5, square3.getCentroid().getY(), 6.5 * 1e-3);
	}

	/**
	 * test the inscribing radius calculations
	 */
	@Test
	public void testInscribingRadius() {
		Square<Double> square = new Square<Double>(new Point2D<Double>(2., 2.), new Point2D<Double>(1., 1.));
		assertEquals("checking inscribing radius", 0.5, square.getInscribingRadius(), 1. * 1e-3);

		Square<Double> square2 = new Square<Double>(new Point2D<Double>(5., 5.), new Point2D<Double>(2., 2.));
		assertEquals("checking inscribing radius", 1.5, square2.getInscribingRadius(), 1.5 * 1e-3);

		Square<Double> square3 = new Square<Double>(new Point2D<Double>(20., 20.), new Point2D<Double>(7., 7.));
		assertEquals("checking inscribing radius", 6.5, square3.getInscribingRadius(), 6.5 * 1e-3);
	}

	/**
	 * test the squares calculated circumscribing radius
	 */
	@Test
	public void testCircumscribingRadius() {
		Square<Double> square = new Square<Double>(new Point2D<Double>(2., 2.), new Point2D<Double>(1., 1.));
		assertEquals("checking circumscribing radius", 0.707, square.getCircumscribingRadius(), 0.707 * 1e-3);

		Square<Double> square2 = new Square<Double>(new Point2D<Double>(5., 5.), new Point2D<Double>(2., 2.));
		assertEquals("checking circumscriing radius", 2.121, square2.getCircumscribingRadius(), 2.121 * 1e-3);

		Square<Double> square3 = new Square<Double>(new Point2D<Double>(20., 20.), new Point2D<Double>(7., 7.));
		assertEquals("checking circumscribing radius", 9.192, square3.getCircumscribingRadius(), 9.192 * 1e-3);

	}

	/**
	 * simple test to determine if two shapes are equal or not
	 */
	@Test
	public void testEquals() {
		Square<Double> square = new Square<Double>(new Point2D<Double>(2., 2.), new Point2D<Double>(1., 1.));
		Square<Double> square2 = new Square<Double>(new Point2D<Double>(2., 2.), new Point2D<Double>(1., 1.));
		assertTrue("should return true", square.equals(square2));

		Square<Double> square3 = new Square<Double>(new Point2D<Double>(2., 2.), new Point2D<Double>(1., 1.));
		Square<Double> square4 = new Square<Double>(new Point2D<Double>(3., 3.), new Point2D<Double>(1., 1.));
		assertFalse("should return false", square3.equals(square4));
	}

	/**
	 * simple test to compare the two shapes
	 */
	@Test
	public void testCompareTo() {
		Square<Double> square = new Square<Double>(new Point2D<Double>(2., 2.), new Point2D<Double>(1., 1.));
		Square<Double> square2 = new Square<Double>(new Point2D<Double>(2., 2.), new Point2D<Double>(1., 1.));
		assertEquals("testing first compareTo method", 0, square.compareTo(square2), 0);

		Square<Double> square3 = new Square<Double>(new Point2D<Double>(2., 2.), new Point2D<Double>(1., 1.));
		Square<Double> square4 = new Square<Double>(new Point2D<Double>(3., 3.), new Point2D<Double>(1., 1.));
		assertEquals("testing second compareTo method", -1, square3.compareTo(square4), -1);

		Square<Double> square5 = new Square<Double>(new Point2D<Double>(20., 20.), new Point2D<Double>(7., 7.));
		Square<Double> square6 = new Square<Double>(new Point2D<Double>(3., 3.), new Point2D<Double>(1., 1.));
		assertEquals("testing third compareTo method", 1, square5.compareTo(square6), 1);
	}

}
