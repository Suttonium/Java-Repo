package P3;
/**
 * Super class that defines generic 2D shapes and implements the Comparable
 * interface
 * 
 * @author dconner
 * @param <T>
 *            - generic type that extends the Number class
 */
public abstract class Shape<T extends Number> implements Comparable<Shape<T>> {
	private String name;

	/**
	 * constructor
	 * 
	 * @param _name
	 *            - the name of the object
	 */
	protected Shape(String _name) {
		name = _name;
	}

	/**
	 * @return the name of the object
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the string representation of the Shape
	 */
	public String toString() {
		String finale = getName();
		return finale;
	}

	/**
	 * abstract method to determine the centroid of the specified shape that
	 * returns the centroid of the specified shape
	 */
	public abstract Point2D<Double> getCentroid();

	/**
	 * abstract method for returning the inscribing radius that returns the
	 * inscribing radius of the specified shape
	 */
	public abstract Double getInscribingRadius();

	/**
	 * abstract method for returning the circumscribing radius that returns the
	 * circumscribing radius of the specified shape
	 */
	public abstract Double getCircumscribingRadius();

	/**
	 * blank method to be called by the constructor of each type
	 */
	protected void calculateBoundingCircles() {
	}

	/**
	 * this method is called from every subclass
	 * 
	 * @param o
	 *            - the object being compared to this object
	 * @return the compareTo value of -1, 0, or 1
	 */
	public int compareTo(Shape<T> o) {
		int answer = 0;
		if (this.getCentroid().getX() < (o.getCentroid().getX())) {
			answer = -1;
		} else if (this.getCentroid().getX() > o.getCentroid().getX()) {
			answer = 1;
		} else if (this.getCentroid().getX().equals(o.getCentroid().getX())) {
			if (this.getCentroid().getY() < o.getCentroid().getY()) {
				answer = -1;
			} else if (this.getCentroid().getY() > o.getCentroid().getY()) {
				answer = 1;
			} else if (this.getCentroid().getY().equals(o.getCentroid().getY())) {
				if (this.getCircumscribingRadius() < o.getCircumscribingRadius()) {
					answer = -1;
				} else if (this.getCircumscribingRadius() > o.getCircumscribingRadius()) {
					answer = 1;
				} else {
					answer = 0;
				}
			}
		}
		return answer;
	}
}
