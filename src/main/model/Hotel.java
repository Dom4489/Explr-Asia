package model;

import org.json.JSONObject;
import persistence.Writable;

// This class represents each hotel listing
public class Hotel implements Writable {

    private String name; // Name of the hotel
    private int price; // Price of the hotel in CAD
    private String location; // Location of the Hotel



    // REQUIRES: String has to be English, price has to be >0, location has to be English
    // MODIFIES: this
    // EFFECTS: Constructs a Hotel with given name, price, and location

    public Hotel(String name, int pricePerNight, String location) {
        this.name = name;
        this.price = pricePerNight;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getPricePerNight() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("price", price);
        json.put("location", location);
        return json;
    }
}
