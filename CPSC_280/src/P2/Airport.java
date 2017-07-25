package P2;
/**
 * Enumerated type identifying airports (by their code and city) to be used as
 * destinations for trips.
 * 
 * @author Austin
 * @version 2017.01.21
 *
 */
public enum Airport {
    ATL("Atlanta"), CLT("Charlotte"), CUN("Cancun"), IAD("Washington"), LAX(
            "Los Angeles"), MIA("Miami"), PHF("Newport News"), SAN(
                    "San Diego"), SEA("Seattle"), SFO(
                            "San Francisco"), YVR("Vancouver"), YYZ("Toronto");

    private String city;

    /**
     * Assigns the tag to the airport
     * 
     * @param city
     *            the city to be used
     */
    Airport(String city) {
        this.city = city;
    }

    /**
     * Returns the name of the city where this airport is located.
     * 
     * @return Name of the city.
     */
    public String getCity() {
        return city;
    }

    /**
     * String representation of an airport. The string is formatted as
     * "Airport[code, city]."
     * 
     * @return String representation of an airport. The string is formatted as
     *         "Airport[code, city].
     */
    @Override
    public String toString() {
        return "Airport[" + name() + "," + this.getCity() + "]";
    }
}
