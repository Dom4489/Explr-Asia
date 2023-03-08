package persistence;

import model.Hotel;

import static org.junit.Assert.assertEquals;

public class JsonTest {
    protected void checkHotel(String name, int pricePerNight, String location, Hotel hotel) {
        assertEquals(name, hotel.getName());
        assertEquals(pricePerNight, hotel.getPricePerNight());
        assertEquals(location, hotel.getLocation());
    }
}
