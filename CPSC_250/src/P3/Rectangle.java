package P3;
/**
 * Rectangle class extends Shape and defines a rectangle using an upperLeft
 * point and a lowerRight point
 * 
 * @author Austin
 *
 * @param <T>
 *            generic type that extends the Number class
 */
public class Rectangle<T extends Number> extends Shape<T> {

	protected Point2D<Double> upperLeftPoint;
	protected Point2D<Double> lowerRightPoint;
	protected Point2D<Double> centroid;
	protected Double inscribingRadius;
	protected Double circumscribingRadius;
	protected String name;

	/**
	 * @param left
	 *            - the upperLeft point for the rectangle
	 * @param right
	 *            - the lowerRight point for rectangle
	 */
	public Rectangle(Point2D<Double> left, Point2D<Double> right) {
		super("Rectangle");
		if (left == null || right == null) {
			throw new InvalidShapeDataException();
		}
		if (left == right) {
			throw new InvalidShapeDataException();
		}
		if (left.getX() >= right.getX() || left.getY() <= right.getY()) {
			throw new InvalidShapeDataException();
		} else {
			upperLeftPoint = left;
			lowerRightPoint = right;
		}
		calculateBoundingCircles();
	}

	/**
	 * constructor
	 * 
	 * @param string
	 *            - the name of the object
	 */
	public Rectangle(String string) {
		super(string);
	}

	/**
	 * Basic toString method
	 * 
	 * @return the String representation of the Rectangle Object
	 */
	@Override
	public String toString() {
		String finale = "Name: " + "\nUpper Left: " + "(" + upperLeftPoint.getX() + "," + upperLeftPoint.getY() + ")"
				+ "\nLower Right: " + "(" + lowerRightPoint.getX() + "," + lowerRightPoint.getY() + ")";
		return finale;
	}

	/**
	 * determining the centroid of a rectangle using the constructor's
	 * upperLeftPoint and lowerRightPoint
	 * 
	 * @param lowerRightPoint2
	 * @param upperLeftPoint2
	 */
	public void calculateCentroid() {
		double X = (upperLeftPoint.getX().doubleValue() + lowerRightPoint.getX().doubleValue()) / 2;
		double Y = (lowerRightPoint.getY().doubleValue() + upperLeftPoint.getY().doubleValue()) / 2;

		centroid = new Point2D<Double>(X, Y);
	}

	/**
	 * @return the centroid calculated in the calculateCentroid method
	 */
	@Override
	public Point2D<Double> getCentroid() {
		return centroid;
	}

	/**
	 * determine the inscribing radius of the circle
	 */
	public void calculateInscribingRadius() {
		Point2D<Double> upperRightPoint = new Point2D<Double>(lowerRightPoint.getX(), upperLeftPoint.getY());
		// double diameter = upperLeftPoint.distance(getCentroid());
		double midX = (upperRightPoint.getX().doubleValue() + upperLeftPoint.getX().doubleValue()) / 2;
		double midY = (upperRightPoint.getY().doubleValue() + upperLeftPoint.getY().doubleValue()) / 2;
		Point2D<Double> midPoint = new Point2D<Double>(midX, midY);
		double radius = centroid.distance(midPoint);
		inscribingRadius = radius;
	}

	/**
	 * @return the inscribed radius mentioned in the calculateInscribedRadius
	 *         method
	 */
	@Override
	public Double getInscribingRadius() {
		return inscribingRadius;
	}

	/**
	 * determine the circumscribing radius of the circumcircle
	 */
	public void calculateCircumscribingRadius() {
		Double centroidToEitherPointDistance = centroid.distance(upperLeftPoint);
		// Double centroidToLowerRightPoint =
		// centroid.distance(lowerRightPoint2);
		// same distance means either can be circumscribingradius distance
		circumscribingRadius = centroidToEitherPointDistance;
	}

	/**
	 * @return the circumcircle's radius calculated in the
	 *         calculateCircumscribingRadius method
	 */
	@Override
	public Double getCircumscribingRadius() {
		return circumscribingRadius;
	}

	/**
	 * calls the calculateCentroid, calculateInscribingRadius, and
	 * calculateCircumscribingRadius method
	 */
	@Override
	public void calculateBoundingCircles() {
		calculateCentroid();
		calculateInscribingRadius();
		calculateCircumscribingRadius();
	}

	/**
	 * added in case the need arises to return this point
	 * 
	 * @return the specified upper left point of the shape
	 */
	public Point2D<Double> getUpperLeft() {
		return upperLeftPoint;
	}

	/**
	 * added in case the need arises to return this point
	 * 
	 * @return the specified lower right point of the shape
	 */
	public Point2D<Double> getLowerRight() {
		return lowerRightPoint;
	}

	/**
	 * determines if this object and object o are equal to one another
	 * 
	 * @param -
	 *            o - the object being compared to this object
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		boolean equal = false;
		if (this.getClass() == o.getClass()) {
			if (this.getUpperLeft().equals(((Rectangle<T>) o).getUpperLeft())
					&& this.getLowerRight().equals(((Rectangle<T>) o).getLowerRight())) {
				equal = true;
			} else {
				equal = false;
			}
		} else {
			equal = false;
		}
		return equal;
	}

	/**
	 * @param o
	 *            - the shape object being compared to this object based on
	 *            circumscribing radius and centroid
	 * @return the compareTo value of -1, 0, or 1 called from the super class
	 */
	@Override
	public int compareTo(Shape<T> o) {
		return super.compareTo(o);
	}
}
