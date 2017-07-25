package P3;
import java.util.ArrayList;

/**
 * Triangle class extends Shape and defines a Triangle using 3 points
 * 
 * @author Austin
 *
 * @param <T>
 *            - generic type that extends the Number class
 */
public class Triangle<T extends Number> extends Shape<T> {

	protected Point2D<Double> firstPoint;
	protected Point2D<Double> secondPoint;
	protected Point2D<Double> thirdPoint;
	protected Point2D<Double> centroid;
	protected Double inscribingRadius;
	protected Double circumscribingRadius;

	/**
	 * basic constructor for triangle object
	 * 
	 * @param first
	 *            - the first point
	 * @param second
	 *            - the second point
	 * @param third
	 *            - the third point
	 */
	public Triangle(Point2D<Double> first, Point2D<Double> second, Point2D<Double> third) {
		super("Triangle");
		firstPoint = first;
		secondPoint = second;
		thirdPoint = third;
		if (first.getX() == second.getX()) {
			if (first.getX() == third.getX()) {
				throw new InvalidShapeDataException();
			}
		}
		if (first.getY() == second.getY()) {
			if (first.getY() == third.getY()) {
				throw new InvalidShapeDataException();
			}
		}
		calculateBoundingCircles();
	}

	/**
	 * @return the string representation of the triangle
	 */
	@Override
	public String toString() {
		String finale = "Name: " + getName() + "\nVertices: " + "(" + firstPoint.getX() + "," + firstPoint.getY() + ")"
				+ "\n(" + secondPoint.getX() + "," + secondPoint.getY() + ")" + "\n(" + thirdPoint.getX() + ","
				+ thirdPoint.getY() + ")";
		return finale;
	}

	/**
	 * determines the centroid using the 3 points as parameters
	 * 
	 * @param firstPoint
	 *            - the first point
	 * @param secondPoint
	 *            - the second point
	 * @param thirdPoint
	 *            - the third point
	 */
	public void calculateCentroid() {
		double X = ((firstPoint.getX().doubleValue() + secondPoint.getX().doubleValue()
				+ thirdPoint.getX().doubleValue()) / 3);
		double Y = ((firstPoint.getY().doubleValue() + secondPoint.getY().doubleValue()
				+ thirdPoint.getY().doubleValue()) / 3);
		centroid = new Point2D<Double>(X, Y);
	}

	/**
	 * @return the calculated centroid
	 */
	@Override
	public Point2D<Double> getCentroid() {
		return centroid;
	}

	/**
	 * determines the inscribing radius using the equation
	 */
	public void calculateInscribingRadius() {
		double Mx = ((firstPoint.getX().doubleValue() + secondPoint.getX().doubleValue())) / 2;
		double My = ((firstPoint.getY().doubleValue() + secondPoint.getY().doubleValue())) / 2;
		Point2D<Double> midPoint = new Point2D<Double>(Mx, My);
		inscribingRadius = midPoint.distance(centroid);
	}

	/**
	 * @return the calculated inscribed radius
	 */
	@Override
	public Double getInscribingRadius() {
		return inscribingRadius;
	}

	/**
	 * determine the circumscribed radius
	 */
	public double calculateCircumscribingRadius() {
		double centroidToFirst = firstPoint.distance(getCentroid());
		double centroidToSecond = secondPoint.distance(getCentroid());
		double centroidToThird = thirdPoint.distance(getCentroid());

		if (centroidToFirst >= centroidToSecond && centroidToFirst >= centroidToThird) {
			circumscribingRadius = centroidToFirst;
		} else if (centroidToSecond >= centroidToThird && centroidToSecond >= centroidToFirst) {
			circumscribingRadius = centroidToSecond;
		} else {
			circumscribingRadius = centroidToThird;
		} // http://keisan.casio.com/exec/system/1223429573
		return getCircumscribingRadius();
	}

	/**
	 * @return the calculated cirumscribed radius
	 */
	@Override
	public Double getCircumscribingRadius() {
		return circumscribingRadius;
	}

	/**
	 * method that calls the calculateCentroid, calculateInscribedRadius, and
	 * calculateCircumscribedRadius methods
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
	 * @return the first point of the shape
	 */
	public Point2D<Double> getFirstPoint() {
		return firstPoint;
	}

	/**
	 * added in case the need arises to return this point
	 * 
	 * @return the second point of the shape
	 */
	public Point2D<Double> getSecondPoint() {
		return secondPoint;
	}

	/**
	 * added in case the need arises to return this point
	 * 
	 * @return the third point of the shape
	 */
	public Point2D<Double> getThirdPoint() {
		return thirdPoint;
	}

	/**
	 * 
	 * @param o
	 *            - the object being compared to this object
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		boolean equal = false;
		ArrayList<Point2D<Double>> data = new ArrayList<Point2D<Double>>();
		data.add(firstPoint);
		data.add(secondPoint);
		data.add(thirdPoint);
		if (this.getClass() == o.getClass()) {
			if (this.getCentroid().equals(((Triangle<T>) o).getCentroid())) {
				for (int i = 0; i < data.size(); i++) {
					if (data.get(i) == firstPoint) {
						firstPoint = data.get(i);
						if (data.get(i) == secondPoint) {
							secondPoint = data.get(i);
							if (data.get(i) == thirdPoint) {
								thirdPoint = data.get(i);
							}
						}
					}
				}
				if (this.getFirstPoint().equals(((Triangle<T>) o).getFirstPoint())) {
					if (this.getSecondPoint().equals(((Triangle<T>) o).getSecondPoint())) {
						if (this.getThirdPoint().equals(((Triangle<T>) o).getThirdPoint())) {
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
	 * @return the compareTo value of -1. 0, or 1 determined by calling the
	 *         super class method
	 */
	@Override
	public int compareTo(Shape<T> o) {
		return super.compareTo(o);
	}

}