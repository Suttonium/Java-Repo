package P3;
/**
 * Basic class that handles 2D vectors
 *
 * @author dconner
 * @param <T>
 *            - generic type that extends the Number class
 */
public class Vector2D<T extends Number> {

	protected T dx;
	protected T dy;

	/**
	 * simple constructor setting DX and DX to null
	 */
	public Vector2D() {
		dx = null;
		dy = null;
	}

	/**
	 * constructor
	 * 
	 * @param _dx
	 *            - the change in x
	 * @param _dy
	 *            - the change in y
	 */
	public Vector2D(T _dx, T _dy) {
		dx = _dx;
		dy = _dy;
	}

	/**
	 * Format string to display vector quantities
	 * 
	 * @return String v(dx,dy) form
	 */
	@Override
	public String toString() {
		return String.format(" v(%.3f,%.3f)", dx, dy);
	}

	/**
	 * 
	 * @return the change in x
	 */
	T getDX() {
		return dx;
	}

	/**
	 * 
	 * @return the change in y
	 */
	T getDY() {
		return dy;
	}

	/**
	 * @return the magnitude of the correspdonding vector
	 */
	public double magnitude() {
		double DX = getDX().doubleValue();
		double DY = getDY().doubleValue();
		double magnitude = Math.sqrt((DX * DX) + (DY * DY));
		return magnitude;
	}
}
