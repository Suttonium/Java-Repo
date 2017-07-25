package P2;
/**
 * Class representing an airplane with the capacity to accommodate travelers.
 * 
 * @author Austin
 * @version 2017.01.21
 *
 */
public class Airplane implements AirplaneADT {

    private int capacity;

    /**
     * Constructs a new airplane with the given traveler capacity.
     * 
     * @param capacity
     *            Travelers this airplane can accommodate.
     * @throws IllegalArgumentException
     *             If the given capacity is less than 1.
     */
    public Airplane(int capacity) throws IllegalArgumentException {
        if (capacity < 1) {
            throw new IllegalArgumentException(
                    "Capacity cannot be less than 1");
        }
        this.capacity = capacity;

    }

    /*
     * (non-Javadoc)
     * 
     * @see AirADT#getCapacity()
     */
    @Override
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns the hash code of this airplane. The hash code is the value of the
     * airplance's capacity modulus 16.
     * 
     * @return Integer reflecting the aiplanes's hash code.
     */
    @Override
    public int hashCode() {
        return capacity % 16;
    }

    /**
     * Identifies whether this airplane is equal to the object provided. Two
     * airplanes are considered the same if they have the same capacity.
     * 
     * @param obj
     *            the object being compared to this object
     * @return True if the airplane and object are the same; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            return ((this.getClass() == obj.getClass())
                    && this.getCapacity() == ((Airplane) obj).getCapacity());
        }
        return false;
    }

    /**
     * String representation of an airplane. The string is formatted as
     * "Airplane[capacity]" where capacity is the capacity of this airplane.
     * 
     * @return String representation of an airplane.
     */
    @Override
    public String toString() {
        return "Airplane[" + this.getCapacity() + "]";
    }
}
