package persistence;

import model.Hotel;
import model.Wallet;
import model.HotelList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// this class represents the reader that reads the user's saved Json files
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads hotel list from file and returns it,
    // throws IOException if error occurs while reading file
    public HotelList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseHotelList(jsonObject);
    }

    // EFFECTS: read file as string and stores it
    public String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Json object for hotel list and returns it
    private HotelList parseHotelList(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        HotelList hl = new HotelList(name);
        addHotels(hl, jsonObject);
        return hl;
    }

    // MODIFIES: hl
    // EFFECTS: parses Hotels from JSON object and adds them to HotelList
    private void addHotels(HotelList hl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("hotels");
        for (Object json : jsonArray) {
            JSONObject nextHotel = (JSONObject) json;
            addHotel(hl, nextHotel);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addHotel(HotelList hl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int pricePerNight = jsonObject.getInt("price");
        String location = jsonObject.getString("location");
        Hotel hotel = new Hotel(name, pricePerNight, location);
        hl.addHotelToList(hotel);
    }

}
