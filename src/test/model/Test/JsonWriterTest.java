package model.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import model.Hotel;
import model.HotelList;
import model.Wallet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            HotelList hl = new HotelList("My hotel list");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testWriterEmptyHotelList() {
        try {
            HotelList hl = new HotelList("My hotel list");
            JsonWriter writer = new JsonWriter("./data/testReaderEmptyHotelList.json");
            writer.open();
            writer.write(hl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testReaderEmptyHotelList.json");
            hl = reader.read();
            assertEquals("My hotel list", hl.getListName());
            assertEquals(0, hl.length());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testWriterGeneralHotelList() {
        try {
            HotelList hl = new HotelList("My hotel list");
            hl.addHotelToList(new Hotel("yes", 20, "UBC"));
            hl.addHotelToList(new Hotel("no", 40, "UofT"));
            JsonWriter writer = new JsonWriter("./data/testReaderGeneralHotelList.json");
            writer.open();
            writer.write(hl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testReaderGeneralHotelList.json");
            hl = reader.read();
            assertEquals("My hotel list", hl.getListName());
            List<Hotel> thingies = hl.getHotels();
            assertEquals(2, thingies.size());
            checkHotel("yes", 20, "UBC", thingies.get(0));
            checkHotel("no", 40, "UofT", thingies.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testWriterGeneralWallet() {
        try {
            Wallet w1 = new Wallet(150);
            w1.addAmount(100);
            w1.addAmount(100);
            JsonWriter writer = new JsonWriter("./data/testReaderGeneralWallet.json");
            writer.open();
            writer.writeWallet(w1);
            writer.close();

            JsonReader reader = new JsonReader("./data/testReaderGeneralWallet.json");
            w1 = reader.readWallet();
            assertEquals(350, w1.getAmount());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
