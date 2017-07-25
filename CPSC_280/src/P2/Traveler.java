package P2;
/**
 * Class representing a traveler on a trip. A traveler is an immutable object
 * that has a name and an airport of destination and implements the interface
 * Comparable to provide a natural ordering of travelers.
 * 
 * @author Austin
 * @version
 *
 */
public class Traveler implements TravelerADT, Comparable<Traveler> {
    private String name;
    private Airport destination;

    /**
     * Simple constructor setting the name and destination of the Traveler
     * 
     * @param name
     *            the name of the traveler
     * @param destination
     *            the destination of the traveler
     * @throws NullPointerException
     *             is thrown if name or destination is null
     */
    public Traveler(String name, Airport destination)
            throws NullPointerException {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }
        else if (destination == null) {
            throw new NullPointerException("Destination cannot be null");
        }
        else {
            this.name = name;
            this.destination = destination;
        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see TravelerADT#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TravelerADT#getDestination()
     */
    @Override
    public Airport getDestination() {
        return destination;
    }

    /**
     * Returns the hash code of this traveler. The hash code is calculated by
     * the following formula: (32 * hashcode of the name) + hashcode of the
     * destination.
     * 
     * @return Integer reflecting the traveler's hash code.
     */
    @Override
    public int hashCode() {
        return (32 * getName().hashCode()) + getDestination().hashCode();
    }

    /**
     * Identifies whether this traveler is equal to the object provided. Two
     * travelers are considered the same if they have the same name and
     * traveling destination.
     * 
     * @return True if the traveler and the object are the same; false
     *         otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (this.getClass() == obj.getClass()) {
                if (this.getName().equals(((Traveler) obj).getName())
                        && this.getDestination()
                                .equals(((Traveler) obj).getDestination())) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return false;
    }

    /**
     * String representation of a traveler. The string is formatted as
     * "Traveler[name, destination]" where name and destination are the values
     * held in this traveler object.
     * 
     * @return String representation of a traveler.
     */
    @Override
    public String toString() {
        return "Traveler[" + getName() + "," + getDestination() + "]";
    }

    /**
     * Provides the natural order between this traveler and the one provided.
     * Returns a negative integer, zero or a positive depending of whether this
     * traveler compares lower, the same or greater than the specified traveler.
     * Comparisons are made by destination and (if not sufficient) by name.
     * 
     * @param o
     *            Traveler provided for comparison
     */
    @Override
    public int compareTo(Traveler traveler) throws NullPointerException {
        if (traveler == null) {
            throw new NullPointerException("Traveler cannot be null");
        }
        if (this.getDestination().compareTo(traveler.getDestination()) == 0) {
            return this.getName().compareTo(traveler.getName());
        }
        else {
            return this.getDestination().compareTo(traveler.getDestination());
        }
    }
}
