package P2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for Traveler to assure the class is covering its requirements
 * 
 * @author Raymond Sutton
 *
 */
public class TravelerTest {

    /**
     * Test to assure an exception is thrown when receiving a null airport value
     * in the constructor
     */
    @Test(expected = NullPointerException.class)
    public void testIfAnExceptionIsThrownWithNullAirportConstructorValues() {
        Traveler testTravel = new Traveler("Bob", null);
        assertNotNull(testTravel);
    }

    /**
     * Test method to ensure an exception is thrown with a null name parameter
     * value
     */
    @Test(expected = NullPointerException.class)
    public void testIfAnExceptionIsThrownWithNullNameConstructorvalue() {
        Traveler testTravelV2 = new Traveler(null, Airport.LAX);
        assertNotNull(testTravelV2);
    }

    /**
     * This method creates a legal constructor with no exceptions
     */
    @Test
    public void testToCreateAGoodConstructor() {
        Traveler traveler = new Traveler("BB-8", Airport.LAX);
        assertNotNull(traveler);
    }

    /**
     * This method checks if the correct name value is returned from an object
     */
    @Test
    public void testIfTheRightNameIsGettingReturned() {
        Traveler traveler = new Traveler("BB-8", Airport.LAX);
        assertEquals("Incorrect Result", "BB-8", traveler.getName());
    }

    /**
     * This method ensures the correct destination is returned from the
     * contructor value
     */
    @Test
    public void testIfTheCorrectDestinationIsReturned() {
        Traveler traveler = new Traveler("BB-8", Airport.LAX);
        assertEquals("Incorrect Result", Airport.LAX,
                traveler.getDestination());
    }

    /**
     * This method to determine if the correct hash code is returned
     */
    @Test
    public void isTheRightHashCodeReturned() {
        Traveler traveler = new Traveler("BB-8", Airport.LAX);
        int actual = traveler.hashCode();
        assertEquals("Incorrect Result", (32 * traveler.getName().hashCode())
                + traveler.getDestination().hashCode(), actual);
    }

    /**
     * This method will test the equals() method in its entirety
     */
    @Test
    public void testIfEqualsIsCorrect() {
        Traveler traveler = null;
        Traveler traveler2 = new Traveler("BB-8", Airport.LAX);
        Traveler traveler3 = new Traveler("BB-8", Airport.LAX);
        Traveler traveler4 = new Traveler("BB-8", Airport.CLT);
        Traveler traveler5 = new Traveler("Kylo Ren", Airport.LAX);
        Airplane p1 = new Airplane(17);
        assertNull(traveler);
        assertFalse(traveler2.equals(traveler));
        assertTrue(traveler2.equals(traveler3));
        assertFalse(traveler2.equals(p1));
        assertFalse(traveler3.equals(traveler4));
        assertFalse(traveler2.equals(traveler5));
    }

    /**
     * This method assures the toString() method returns correctly
     */
    @Test
    public void doesToStringReturnTheCorrectString() {
        Traveler t1 = new Traveler("BB-8", Airport.LAX);
        assertEquals("Incorrect Result",
                "Traveler[" + t1.getName() + "," + t1.getDestination() + "]",
                t1.toString());
    }

    /**
     * This method tests the compareTo method of null Traveler
     */
    @Test(expected = NullPointerException.class)
    public void testCompareTo() {
        Traveler t1 = new Traveler("BB-8", Airport.LAX);
        t1.compareTo(null);
    }

    /**
     * This method will test compareTo omitting null values
     */
    @Test
    public void testTheRestOfCompareTo() {
        Traveler t1 = new Traveler("BB-8", Airport.LAX);
        Traveler traveler2 = new Traveler("BB-8", Airport.CLT);
        Traveler traveler3 = new Traveler("BB-8", Airport.LAX);
        Traveler t4 = new Traveler("Kylo Ren", Airport.LAX);
        assertTrue(t1.compareTo(traveler2) > 0);
        assertTrue(t1.compareTo(traveler3) == 0);
        assertTrue(t1.compareTo(t4) < 0);
    }
}
