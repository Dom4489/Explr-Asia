package persistence;

import org.json.JSONObject;

// This class is an interface for data that is writeable in json form
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
