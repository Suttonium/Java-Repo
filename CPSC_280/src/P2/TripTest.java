package P2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Test class to assure the Trip class if fully covered
 * 
 * @author Austin
 *
 */
public class TripTest {
    /**
     * Test method to throw a NPE when Airplane is null within the Trip
     * parameters
     */
    @Test(expected = NullPointerException.class)
    public void isANullPointerExceptionThrown() {
        Airport[] ports = Airport.values();
        Airplane p1 = null;
        @SuppressWarnings("unused")
        Trip t1 = new Trip(ports, p1);
    }

    /**
     * Test method to throw a NPE when Airports is null within the Trip
     * parameters
     */
    @Test(expected = NullPointerException.class)
    public void isAnotherNullPointerExceptionThrown() {
        Airport[] morePorts = null;
        Airplane p2 = new Airplane(17);
        @SuppressWarnings("unused")
        Trip t2 = new Trip(morePorts, p2);
    }

    /**
     * Test method to throw an IAE when the length of the Trip is less than two
     * airports
     */
    @Test(expected = IllegalArgumentException.class)
    public void isIAEThrownWhenAirportsLengthIsLessThanTwo() {
        Airport[] ports = { Airport.LAX };
        Airplane p1 = new Airplane(17);
        @SuppressWarnings("unused")
        Trip t1 = new Trip(ports, p1);
    }

    /**
     * Test method to throw an IAE when there is a null airport within the
     * airports array
     */
    @Test(expected = IllegalArgumentException.class)
    public void isIAEThrownWhenAnAirportInTheArrayIsNull() {
        Airport[] ports = { Airport.LAX, null, Airport.MIA };
        Airplane p1 = new Airplane(17);
        @SuppressWarnings("unused")
        Trip t1 = new Trip(ports, p1);
    }

    /**
     * Test method to throw an IAE when two consecutive airports are the same
     */
    @Test(expected = IllegalArgumentException.class)
    public void isIAEThrownWhenTwoDuplicateAirportsBackToBack() {
        Airport[] ports = { Airport.CUN, Airport.LAX, Airport.LAX,
                Airport.MIA };
        Airplane p1 = new Airplane(17);
        @SuppressWarnings("unused")
        Trip t1 = new Trip(ports, p1);
    }

    /**
     * Test method to create a legitimate constructor
     */
    @Test
    public void testCorrectConstructor() {
        List<Traveler> travelers = new ArrayList<Traveler>();
        Airport[] ports = Airport.values();
        Airplane p1 = new Airplane(17);
        Trip t1 = new Trip(ports, p1);
        assertNotNull(travelers);
        assertNotNull(t1);
    }

    /**
     * Test method to return the correct list of airports from a trip
     */
    @Test
    public void testgetAirports() {
        Airport[] ports = Airport.values();
        Airplane p1 = new Airplane(17);
        Trip t1 = new Trip(ports, p1);
        List<Airport> portsToGoTo = new ArrayList<Airport>();
        for (int i = 0; i < ports.length; i++) {
            portsToGoTo.add(ports[i]);
        }
        assertEquals("Incorrect Result", portsToGoTo, t1.getAirports());
    }

    /**
     * Test method to return the correct airplane from the trip
     */
    @Test
    public void testGetAirplane() {
        Airport[] ports = Airport.values();
        Airplane p1 = new Airplane(17);
        Trip t1 = new Trip(ports, p1);
        assertEquals("Incorrect Result", p1, t1.getAirplane());
    }

    /**
     * Test method to throw a NPE when adding a null traveler to the trip
     */
    @Test(expected = NullPointerException.class)
    public void isNPEThrownWhenTryingToAddANullTraveler() {
        Traveler t1 = null;
        Airport[] ports = Airport.values();
        Airplane p1 = new Airplane(17);
        Trip trip1 = new Trip(ports, p1);
        trip1.addTraveler(t1);
    }

    /**
     * Test method to assure the getTravelers() method works correctly
     */
    @Test
    public void testIfCorrectTravelerListIsReturned() {
        Traveler t1 = new Traveler("Bob", Airport.LAX);
        List<Traveler> list = new ArrayList<Traveler>();
        Airport[] airports = { Airport.LAX, Airport.MIA };
        Airplane plane = new Airplane(1);
        Trip trip = new Trip(airports, plane);
        trip.addTraveler(t1);

        assertEquals("Incorrect Result", list, trip.getTravelers());
    }

    /**
     * Test method asserting hasRoom is false
     */
    @Test
    public void testHasRoomFalse() {
        Airplane airplane = new Airplane(2);
        Traveler t1 = new Traveler("Bob", Airport.LAX);
        Traveler t2 = new Traveler("Ryan", Airport.MIA);
        Traveler t3 = new Traveler("Sam", Airport.SEA);
        Trip trip = new Trip(Airport.values(), airplane);
        trip.addTraveler(t1);
        trip.addTraveler(t2);
        assertFalse(trip.addTraveler(t3));
    }

    /**
     * Test method asserting hasRoom is true
     */
    @Test
    public void testHasRoomTrue() {
        Airplane airplane = new Airplane(4);
        Traveler t1 = new Traveler("Bob", Airport.LAX);
        Traveler t2 = new Traveler("Ryan", Airport.MIA);
        Traveler t3 = new Traveler("Sam", Airport.SEA);
        Trip trip = new Trip(Airport.values(), airplane);
        trip.addTraveler(t1);
        trip.addTraveler(t2);
        trip.addTraveler(t3);
        assertTrue(trip.hasRoom());
    }

    /**
     * Test method for declaring hasNext is true or false
     */
    @Test
    public void testHasNext() {
        Airplane airplane = new Airplane(17);
        Airport[] airports = { Airport.LAX, Airport.MIA, Airport.SAN };
        int aPos = 0;
        Trip trip = new Trip(airports, airplane);
        if (aPos < airports.length - 1) {
            assertTrue(trip.hasNext());
        }
        else {
            assertFalse(trip.hasNext());
        }
    }
}
