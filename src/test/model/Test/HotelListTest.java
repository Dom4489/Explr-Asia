package model.Test;

import model.Hotel;
import model.HotelList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// This class includes the test suites for the class HotelList
public class HotelListTest {
    private HotelList hl1;
    private HotelList hl2;
    private Hotel h1;
    private Hotel h2;
    private Hotel h3;
    private Hotel h4;
    private Hotel h5;
    private Hotel h6;
    private Hotel h7;
    private Hotel h8;
    private Hotel h9;
    private Hotel h10;
    private Hotel h11;


    @BeforeEach
    public void setup() {
        hl1 = new HotelList("TravelList1");
        hl2 = new HotelList("China");
        h1 = new Hotel("RoseWood", 99, "Beijing");
        h2 = new Hotel("Sheraton", 102, "Guangzhou");
        h3 = new Hotel("yes", 152, "no");
        h4 = new Hotel("in", 121, "out");
        h5 = new Hotel("up", 80, "down");
        h6 = new Hotel("hot", 180, "cold");
        h7 = new Hotel("summer", 125, "winter");
        h8 = new Hotel("ying", 110, "yang");
        h9 = new Hotel("happy", 90, "sad");
        h10 = new Hotel("good", 44, "bad");
        h11 = new Hotel("hot", 78, "cold");

    }

    @Test
    public void testConstructor() {
        assertEquals(0, hl1.length());
        assertEquals("yes", hl1.listEmpty());
        assertTrue(hl1.addHotelToList(h1));
        assertEquals("no", hl1.listEmpty());
        assertEquals("no", hl1.listFull());

    }
    @Test
    public void testAddHotelToList() {
        assertTrue(hl2.addHotelToList(h1));
        assertTrue(hl2.addHotelToList(h2));
        assertTrue(hl2.addHotelToList(h3));
        assertEquals(3, hl2.length());
        assertEquals("no", hl2.listEmpty());
        assertEquals("no", hl2.listFull());
        assertTrue(hl2.addHotelToList(h4));
        assertTrue(hl2.addHotelToList(h5));
        assertTrue(hl2.addHotelToList(h6));
        assertTrue(hl2.addHotelToList(h7));
        assertTrue(hl2.addHotelToList(h8));
        assertTrue(hl2.addHotelToList(h9));
        assertTrue(hl2.addHotelToList(h10));
        assertEquals("yes", hl2.listFull());
        assertFalse(hl2.addHotelToList(h11));
    }
    @Test
    public void testRemoveHotelFromList() {
        hl2.addHotelToList(h1);
        hl2.addHotelToList(h2);
        hl2.addHotelToList(h3);
        assertEquals(3, hl2.length());
        assertEquals("RoseWood", hl2.removeHotelFromList("RoseWood"));
        assertEquals(2, hl2.length());
        assertEquals("Sheraton", hl2.removeHotelFromList("Sheraton"));
        hl2.addHotelToList(h2);
        assertEquals(2, hl2.length());
        assertEquals("Sheraton", hl2.removeHotelFromList("Sheraton"));
        assertEquals(1, hl2.length());
        assertEquals("The hotel you entered could not be found within your list", hl2.removeHotelFromList("UBC"));
    }
    @Test
    public void testGetListName() {
        assertEquals("TravelList1", hl1.getListName());
        assertEquals("China", hl2.getListName());
    }
    @Test
    public void testLength() {
        assertEquals(0, hl2.length());
        hl2.addHotelToList(h1);
        assertEquals(1, hl2.length());
    }
    @Test
    public void testListFull() {
        assertEquals("no", hl1.listFull());
        hl1.addHotelToList(h1);
        assertEquals("no", hl1.listFull());
        hl1.addHotelToList(h2);
        hl1.addHotelToList(h3);
        hl1.addHotelToList(h4);
        hl1.addHotelToList(h5);
        hl1.addHotelToList(h6);
        hl1.addHotelToList(h7);
        hl1.addHotelToList(h8);
        hl1.addHotelToList(h9);
        hl1.addHotelToList(h10);
        assertEquals("yes", hl1.listFull());
        hl1.removeHotelFromList("Sheraton");
        assertEquals("no", hl1.listFull());
    }
    @Test
    public void testListEmpty() {
        assertEquals("yes", hl2.listEmpty());
        hl2.addHotelToList(h1);
        assertEquals("no", hl2.listEmpty());
        hl2.removeHotelFromList("RoseWood");
        assertEquals("yes", hl2.listEmpty());
    }

    @Test
    public void testSetHotelListName() {
        assertEquals("China",  hl2.getListName());
        hl2.setListName("Dom");
        assertEquals("Dom", hl2.getListName());
    }

    @Test
    public void testGetHotelNames() {
        assertEquals(0, hl1.getHotelListNames().size());
        hl1.addHotelToList(h1);
        hl1.addHotelToList(h2);
        assertEquals(2, hl1.getHotelListNames().size());
        List<String> test = new ArrayList<>();
        test.add("RoseWood");
        test.add("Sheraton");
        assertEquals(test, hl1.getHotelListNames());
        hl1.removeHotelFromList("RoseWood");
        test.remove(0);
        assertEquals(1, hl1.getHotelListNames().size());
        assertEquals(test, hl1.getHotelListNames());
    }

    @Test
    public void testGetTotalPrice() {
        assertEquals(0, hl1.getTotalHotelPrices());
        hl1.addHotelToList(h1);
        assertEquals(99, hl1.getTotalHotelPrices());
        hl1.addHotelToList(h2);
        assertEquals(201, hl1.getTotalHotelPrices());
        hl1.removeHotelFromList("RoseWood");
        assertEquals(102, hl1.getTotalHotelPrices());
    }

    @Test
    public void testGetHotelLoations() {
        assertEquals(0, hl1.getHotelLocations().size());
        hl1.addHotelToList(h1);
        hl1.addHotelToList(h2);
        assertEquals(2, hl1.getHotelLocations().size());
        List<String> test = new ArrayList<>();
        test.add("Beijing");
        test.add("Guangzhou");
        assertEquals(test, hl1.getHotelLocations());
        hl1.removeHotelFromList("Sheraton");
        test.remove(1);
        assertEquals(1, hl1.getHotelLocations().size());
        assertEquals(test, hl1.getHotelLocations());
    }



}
