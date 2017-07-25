package P3;
/**
 * Circle class extends Shape and defines a circle by center point and radius
 *
 * @author dconner
 * @param <T>
 *            generic type that extends the Number class
 *
 */
public class Circle<T extends Number> extends Shape<T> {

	protected Point2D<Double> center;
	protected Double radius;

	/**
	 * constructor
	 * 
	 * @param _center
	 *            Point2D for center
	 * @param _radius
	 *            double for radius
	 */
	public Circle(Point2D<Double> _center, Double _radius) {
		super("Circle");
		if (_radius.doubleValue() <= 0) {
			throw new InvalidShapeDataException();
		}
		if (_center == null || _radius == null) {
			throw new InvalidShapeDataException();
		} else {
			center = _center;
			radius = _radius;
		}
		calculateBoundingCircles();
	}

	/**
	 * Get the center of circle
	 * 
	 * @return Point2D center of circle
	 */
	public Point2D<Double> getCenter() {
		return center;
	}

	/**
	 * Get the radius
	 * 
	 * @return radius value
	 */
	public Double getRadius() {
		return radius;
	}

	/**
	 * @return the String representation
	 */
	@Override
	public String toString() {
		center.toString();
		return "Name: " + getName() + "\nCenter Coordinate: " + getCenter() + "\nRadius: " + getRadius();
	}

	/**
	 * @return the centroid
	 */
	@Override
	public Point2D<Double> getCentroid() {
		return center;
	}

	/**
	 * @return the inscribing radius
	 */
	@Override
	public Double getInscribingRadius() {
		return radius;
	}

	/**
	 * @return the circumscribing radius
	 */
	@Override
	public Double getCircumscribingRadius() {
		return radius;
	}

	/**
	 * simple method to call the methods within its scope
	 */
	public void calculateBoundingCircles() {
		getCentroid();
		getInscribingRadius();
		getCircumscribingRadius();
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
			if (this.getCentroid().equals(((Circle<T>) o).getCentroid())) {
				if (this.getRadius().equals(((Circle<T>) o).getRadius())) {
					equal = true;
				} else {
					equal = false;
				}
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
	 * @return the comparison value (-1,0,1) called from the super class
	 */
	@Override
	public int compareTo(Shape<T> o) {
		return super.compareTo(o);
	}
}
