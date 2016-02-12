package com.linroutingsystems.routedisttimecomp;


import java.io.*;
import java.util.*;
import android.util.JsonReader;

/**
 * Created by Chow on 2/11/2016.
 */
public class JSONParser {
    void JSONParser(){
        // Null constructor
    }

    public List readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readMessagesArray(reader);
        }
        finally {
            reader.close();
        }
    }

    public List readMessagesArray(JsonReader reader) throws IOException {
        List messages = new ArrayList();

        reader.beginArray();
        while (reader.hasNext()) {
            messages.add(readMessage(reader));
        }
        reader.endArray();
        return messages;
    }

    public DataPoints readMessage(JsonReader reader) throws IOException {
        List<String> origin_addresses = null;
        List<String> destination_addresses = null;
        ArrayList distance = new ArrayList<Integer>();
        ArrayList duration = new ArrayList<Integer>();



        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("destination_addresses")) {
                destination_addresses = readPlaces(reader);
/*            } else if (name.equals("text")) {
                text = reader.nextString();
            } else if (name.equals("geo") && reader.peek() != JsonToken.NULL) {
                geo = readDoublesArray(reader);
            } else if (name.equals("user")) {
                user = readUser(reader);
 */           } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new DataPoints(origin_addresses, destination_addresses, distance, duration);
    }

    public List readPlaces(JsonReader reader) throws IOException{
        List<String> locations = new ArrayList();

        reader.beginArray();
        while (reader.hasNext()){
            locations.add(reader.nextString());
        }

        return locations;
    }



}
