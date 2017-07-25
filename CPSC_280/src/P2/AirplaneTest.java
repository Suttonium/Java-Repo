package P2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for the Airplane class
 * 
 * @author Raymond Sutton
 *
 */
public class AirplaneTest {

    /**
     * Test class for testing whether or not an exception is thrown when
     * capacity is less than one
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIfAnExceptionIsThrownWhenCapacityIsLessThanOne() {
        Airplane testPlane = new Airplane(-1);
        assertNotNull(testPlane);
    }

    /**
     * Test to make sure the contructor creates a plane object correctly
     */
    @Test
    public void testCreatingANewPlane() {
        Airplane testPlane = new Airplane(10);
        assertNotNull(testPlane);
    }

    /**
     * Test to check if the correct capacity value is returned
     */
    @Test
    public void testIfGetCapacityReturnsCorrectValue() {
        Airplane testPlane = new Airplane(10);
        int expected = 10;
        int actual = testPlane.getCapacity();
        assertEquals("Incorrect Result", expected, actual);
    }

    /**
     * Test to assure the corerct hash code is returned
     */
    @Test
    public void testIfHashCodeReturnsCorrectValue() {
        Airplane testPlane = new Airplane(33);
        int expected = 1;
        int actual = testPlane.hashCode();
        assertEquals("Incorrect Value", expected, actual);
    }

    /**
     * Test to assure the true and false assertions work correctly
     */
    @Test
    public void testIfEqualsWorksCorrectly() {
        Airplane plane1 = new Airplane(4);
        Airplane plane2 = new Airplane(4);
        assertTrue(plane1.equals(plane2));

        Airplane plane3 = new Airplane(17);
        Airplane plane4 = new Airplane(12);
        assertFalse(plane3.equals(plane4));
    }

    /**
     * Test whether or not the program recognizes a null assertion
     */
    @Test
    public void testIfAnObjectIsNullWithinEqualsMethod() {
        Airplane plane1 = null;
        Airplane plane2 = new Airplane(13);
        assertFalse(plane2.equals(plane1));
    }

    /**
     * Test to assure both objects are airplanes
     */
    @Test
    public void testIfBothObjectsAreAirplanesButHaveDifferentCapacities() {
        Airplane p1 = new Airplane(13);
        Airplane p2 = new Airplane(14);
        Airplane p3 = new Airplane(17);
        Airplane p4 = new Airplane(14);
        Traveler t1 = new Traveler("BB-8", Airport.LAX);
        assertFalse(p1.equals(t1));
        assertFalse(p1.equals(p3));
        assertTrue(p2.equals(p4));
    }

    /**
     * Test to assure the string representation is returned correctly
     */
    @Test
    public void testIfToStringWorksCorrectly() {
        Airplane testPlane = new Airplane(17);
        assertEquals("Incorrect Result",
                "Airplane[" + testPlane.getCapacity() + "]",
                testPlane.toString());
    }
}
