package P3;
/**
 * basic square class extended from the Rectangle super class
 * 
 * @author Austin
 *
 * @param <T>
 *            - generic type that extends the Number class
 */
public class Square<T extends Number> extends Rectangle<T> {
	/**
	 * basic constructor which uses the protected variables from the rectangle
	 * class
	 * 
	 * @param left
	 *            - the upper left point
	 * @param right
	 *            - the lower right point
	 */
	public Square(Point2D<Double> left, Point2D<Double> right) {
		super("Square");
		double diffX = left.getX().doubleValue() - right.getX().doubleValue();
		double diffY = left.getY().doubleValue() - right.getY().doubleValue();

		if (diffY != diffX) {
			throw new InvalidShapeDataException();
		} else {
			upperLeftPoint = left;
			lowerRightPoint = right;
		}
		super.calculateBoundingCircles();
	}

	/**
	 * @return the String representation of the Square object
	 */
	@Override
	public String toString() {
		String finale = "Name: " + getName() + "\nUpper Left: " + "(" + upperLeftPoint.getX() + ","
				+ upperLeftPoint.getY() + "\nLower Right: " + "(" + lowerRightPoint.getX() + ","
				+ lowerRightPoint.getY();
		return finale;
	}

	/**
	 * determines if this object is equal to object o
	 * 
	 * @param o
	 *            - the object being compared to this object
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		boolean equal = false;
		if (this.getClass() == o.getClass()) {
			if (this.getUpperLeft().equals(((Square<T>) o).getUpperLeft())
					&& this.getLowerRight().equals(((Square<T>) o).getLowerRight())) {
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
	 *            - the object being compared to this object
	 * @return the compareTo value of -1, 0, or 1 determined by the super class
	 *         calling of compareTo
	 */
	@Override
	public int compareTo(Shape<T> o) {
		return super.compareTo(o);
	}
}
