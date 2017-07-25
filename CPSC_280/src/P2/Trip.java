package P2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class representing a trip in which travelers are flown from one airport to
 * the next. Each trip has an airplane for traveling, a (potentially empty)
 * number of travelers and a sequence of airports to visit on the trip, where
 * the initial and final airports in the sequence are the departure and
 * destination airports.
 * 
 * @author Raymond Sutton
 * @version 2017.01.21
 *
 */
public class Trip implements TripADT {

    private Airport[] airports;
    private Airplane airplane;
    private List<Traveler> travelers;
    private int airportPosition;

    /**
     * Creates a new trip. A trip is created with an airplane and a sequence of
     * airports, where the first and last airports are the departing and the
     * final destination respectively
     * 
     * @param airports
     *            Sequence of airports visited in this trip.
     * @param airplane
     *            Airplane to be used in this trip.
     * 
     * @throws NullPointerException
     *             If any argument is null (message: "parameter cannot be null"
     *             where parameter is either "Airports" or "Airplane").
     * @throws IllegalArgumentException
     *             If the sequence of airports is ill-formed, which happens if
     *             (a) there are less than 2 airports in the sequence (message:
     *             "Airports cannot be less than 2: found i" where i is the
     *             number of airports), (b) any of the airports is null
     *             (message: "Airport cannot be null: index i" where i is the
     *             index of the null value), or (c) two consecutive airports are
     *             the same (message: "Repeated airport: airport at index i"
     *             where airport is the code of the duplicated airport and i is
     *             the index where it first occurs).
     */
    public Trip(Airport[] airports, Airplane airplane)
            throws NullPointerException, IllegalArgumentException {
        doesConstructorThrowException(airports, airplane);
        travelers = new ArrayList<Traveler>();
        airportPosition = 0;
        this.airplane = airplane;
        this.airports = airports;
    }

    /**
     * Tests whether or not the Constructor throws an exception
     * 
     * @param airports
     *            Sequence of airports visited in this trip.
     * @param airplane
     *            Airplane to be used in this trip.
     */
    private void doesConstructorThrowException(Airport[] airports,
            Airplane airplane) {
        if (airports == null) {
            throw new NullPointerException("Airports cannot be null");
        }
        if (airplane == null) {
            throw new NullPointerException("Airplane cannot be null");
        }
        else if (airports.length < 2) {
            throw new IllegalArgumentException(
                    "Airports cannot be less than 2: found "
                            + airports.length);
        }
        for (int i = 0; i < airports.length; i++) {
            if (airports[i] == null) {
                throw new IllegalArgumentException(
                        "Airport cannot be null: index " + i);
            }
            if (i > 1) {
                if (airports[i] == airports[i - 1]) {
                    throw new IllegalArgumentException("Repeated airport: "
                            + airports[i].name() + " at index " + (i - 1));
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see TripADT#getAirports()
     */
    @Override
    public List<Airport> getAirports() {
        return Arrays.asList(airports);
    }

    /*
     * (non-Javadoc)
     * 
     * @see TripADT#getAirplane()
     */
    @Override
    public Airplane getAirplane() {
        return airplane;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TripADT#getTravelers()
     */
    @Override
    public List<Traveler> getTravelers() {
        return travelers;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TripADT#addTraveler(Traveler)
     */
    @Override
    public boolean addTraveler(Traveler traveler) throws NullPointerException {
        if (traveler == null) {
            throw new NullPointerException("Traveler cannot be null");
        }
        if (travelers.contains(traveler)) {
            return false;
        }
        else if (hasRoom() == false) {
            return false;
        }
        else if (airports[airportPosition] == traveler.getDestination()) {
            return false;
        }
        for (int i = 0; i < airports.length; i++) {
            if (!(traveler.getDestination() == airports[i])) {
                return false;
            }
        }
        travelers.add(traveler);
        return true;

    }

    /*
     * (non-Javadoc)
     * 
     * @see TripADT#hasRoom()
     */
    @Override
    public boolean hasRoom() {
        int hasRoom = getAirplane().getCapacity();
        if (hasRoom - getTravelers().size() <= 0) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TripADT#at()
     */
    @Override
    public Airport at() {
        return airports[airportPosition];
    }

    /*
     * (non-Javadoc)
     * 
     * @see TripADT#next()
     */
    @Override
    public void next() throws NoSuchElementException {
        if (hasNext() == false) {
            throw new NoSuchElementException("No more airports available");
        }
        else {
            airportPosition++;
            int size = travelers.size();
            for (int i = size - 1; i >= 0; i--) {
                if (travelers.get(i).getDestination()
                        .getCity() == airports[airportPosition].getCity()) {
                    travelers.remove(travelers.get(i));
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see TripADT#hasNext()
     */
    @Override
    public boolean hasNext() {
        if (airportPosition < airports.length - 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
