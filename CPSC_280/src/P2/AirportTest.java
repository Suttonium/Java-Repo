package P2;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class to assure the Airport Enum is being fully covered
 * 
 * @author Austin
 *
 */
public class AirportTest {
    @Test
    public void testToMakeSureTheCorrectCityIsReturned() {
        assertEquals("Incorrect Result", Airport.LAX.getCity(), "Los Angeles");
    }

    @Test
    public void testToStringCorrectResult() {
        assertEquals("Incorrect Result",
                "Airport[" + "LAX" + "," + Airport.LAX.getCity() + "]",
                Airport.LAX.toString());
    }
}
