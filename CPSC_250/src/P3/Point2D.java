package P3;

/**
 * Basic class that handles 2D points
 *
 * @author dconner
 * @param <T>
 *            - generic type that extends the Number class
 */
public class Point2D<T extends Number> {

	protected T x;
	protected T y;

	/**
	 * constructor
	 * 
	 * @param _x
	 *            - x coordinate
	 * @param _y
	 *            - y coordinate
	 */
	public Point2D(T _x, T _y) {
		if (_x == null || _y == null) {
			throw new InvalidShapeDataException();
		} else {
			x = _x;
			y = _y;
		}
	}

	/** Return the x-coordinate */
	T getX() {
		return x;
	}

	/** Return the y-coordinate */
	T getY() {
		return y;
	}

	/**
	 * @return the string representation of the Point2D
	 */
	public String toString() {
		String finale = "(" + getX() + "," + getY() + ")";
		return finale;
	}

	/**
	 * 
	 * @param other
	 *            - the other point used for the distance calculation
	 * 
	 * @return the double distance between this point and other point.
	 */
	public double distance(Point2D<T> other) {
		double Bx = other.getX().doubleValue();
		double By = other.getY().doubleValue();

		double distance = Math
				.sqrt(Math.pow((getX().doubleValue() - Bx), 2) + Math.pow((getY().doubleValue() - By), 2));
		return distance;
	}

	/**
	 * @param other
	 *            - the point being compared to this point.
	 * @return the Double representation of the vector between other and this
	 */
	public Vector2D<Double> diff(Point2D<T> other) {
		double deltaX = (Double) other.getX() - (Double) getX();
		double deltaY = (Double) other.getY() - (Double) getY();
		Vector2D<Double> vector = new Vector2D<Double>(deltaX, deltaY);
		return vector;
	}

	/**
	 * 
	 * @param other
	 *            - the other point being compared to this point
	 * @return whether the points are equal or not
	 */
	public boolean equals(Point2D<Double> other) {
		boolean equal = false;
		if (this.getX().doubleValue() == other.getX().doubleValue()
				&& this.getY().doubleValue() == other.getY().doubleValue()) {
			equal = true;
		} else {
			equal = false;
		}
		return equal;
	}
}
