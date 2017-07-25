package P2;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Interface for the Trip class
 * 
 * @author Raymond Sutton
 * @version 2017.01.21
 *
 */
public interface TripADT {

    /**
     * Returns all airports given to this trip.
     * 
     * @return List with all airports in this trip.
     */
    public List<Airport> getAirports();

    /**
     * Returns the airplane used in this trip.
     * 
     * @return An airplane object.
     */
    public Airplane getAirplane();

    /**
     * Returns the current travelers in sorted order.
     * 
     * @return List with all current travelers in sorted order.
     */
    public List<Traveler> getTravelers();

    /**
     * Adds a new traveler to the trip. The traveler is added to the trip if (a)
     * it is not already on the trip, (b) the airport of travel is one of the
     * airports yet to be traveled on this trip or (c) there is room in the
     * airplane to seat another traveler.
     * 
     * @param traveler
     *            Traveler to add to the trip.
     * @return True if the traveler was added; false otherwise.
     * @throws NullPoinerException
     *             If the parameter is null (message: "Traveler cannot be null")
     */
    public boolean addTraveler(Traveler traveler) throws NullPointerException;

    /**
     * Indicates whether there are places available in this trip. Availability
     * is given by the difference between number of travelers and airplane
     * capacity.
     * 
     * @return True if another traveler can be added; false otherwise.
     */
    public boolean hasRoom();

    /**
     * Returns the current airport in this trip. If the trip has not started
     * then this airport is the first airport in the trip. If the trip has ended
     * then it is the last airport in the trip.
     * 
     * @return Current airport in this trip.
     */
    public Airport at();

    /**
     * Advances the trip to the next airport. An exception is thrown if the trip
     * has reached its last airport already. Once this method is executed, all
     * passengers whose destination match the reached airport are removed from
     * the list of travelers.
     * 
     * @throws NoSuchElementException
     *             If there is no next airport to reach, i.e., the trip is over
     *             (message: "No more airports available").
     */
    public void next() throws NoSuchElementException;

    /**
     * Indicates whether there is at least one airport yet to be reached in this
     * trip.
     * 
     * @return True if we could travel to another airport next; false if we have
     *         reached the end of the trip.
     */
    public boolean hasNext();

}
