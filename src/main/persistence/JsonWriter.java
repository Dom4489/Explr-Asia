package persistence;

import model.HotelList;
import model.Wallet;
import org.json.JSONObject;

// this class represents the json writer that writes the chosen data in json format
import javax.swing.plaf.metal.MetalBorders;
import java.io.*;

public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of hotel list to file
    public void write(HotelList hl) {
        JSONObject json = hl.toJson();
        saveToFile(json.toString(TAB));
    }

    public void writeWallet(Wallet w1) {
        JSONObject json =  w1.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
