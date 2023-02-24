package model.Test;

import model.Hotel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelTest {
    private Hotel h1;
    private Hotel h2;

    @BeforeEach
    public void setup() {
        h1 = new Hotel("Ritz-Carlton", 90, "TianHe");
        h2 = new Hotel("Langham", 88, "HaiZhou");
    }

    @Test
    public void testConstructor() {
        assertEquals("Ritz-Carlton", h1.getName());
        assertEquals(90, h1.getPricePerNight());
        assertEquals("TianHe", h1.getLocation());
    }

    @Test
    public void testGetName() {
        assertEquals("Langham", h2.getName());
        assertEquals("Ritz-Carlton", h1.getName());
    }

    @Test
    public void testGetPricePerNight() {
        assertEquals(90, h1.getPricePerNight());
        assertEquals(88, h2.getPricePerNight());
    }

    @Test
    public void testGetLocation() {
        assertEquals("TianHe", h1.getLocation());
        assertEquals("HaiZhou", h2.getLocation());
    }
}