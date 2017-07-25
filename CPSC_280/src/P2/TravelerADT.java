package P2;
/**
 * Interface for the Traveler class
 * 
 * @author Austin
 * @version
 *
 */
public interface TravelerADT {
    /**
     * Returns the destination of this traveler.
     * 
     * @return Airport of destination.
     */
    public Airport getDestination();

    /**
     * Returns the name of this traveler.
     * 
     * @return String with the traveler's name.
     */
    public String getName();

}
