package persistence;


import model.Hotel;
import model.HotelList;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class JsonReaderTest extends JsonTest {
    @Test
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            HotelList hl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // test passed
        }
    }

    @Test
    public void testReaderEmptyHotelList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyHotelList.json");
        try {
            HotelList hl = reader.read();
            assertEquals("My hotel list", hl.getListName());
            assertEquals(0, hl.length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderGeneralHotelList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralHotelList.json");
        try {
            HotelList hl = reader.read();
            assertEquals("My hotel list", hl.getListName());
            List<Hotel> thingies = hl.getHotels();
            assertEquals(2, thingies.size());
            checkHotel("yes", 20, "UBC", thingies.get(0));
            checkHotel("no", 40, "UofT", thingies.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
