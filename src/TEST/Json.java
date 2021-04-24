package TEST;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Json {
    public  void createJsonObject(Object a){



    }
    public static void main(String[] args) throws IOException {
        String json
                = "{\"name\":\"Tom\",\"age\":25,\"address\":[\"Poland\",\"5th avenue\"]}";
        JsonFactory jfactory = new JsonFactory();
        JsonParser jParser = jfactory.createParser(json);
        String parsedName = null;
        Integer parsedAge = null;
        List<String> addresses = new LinkedList<>();
        while (jParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jParser.getCurrentName();
            if ("name".equals(fieldname)) {
                jParser.nextToken();
                parsedName = jParser.getText();
            }
            if ("age".equals(fieldname)) {
                jParser.nextToken();
                parsedAge = jParser.getIntValue();
            }
            if ("address".equals(fieldname)) {
                jParser.nextToken();
                while (jParser.nextToken() != JsonToken.END_ARRAY) {
                    addresses.add(jParser.getText());
                }
            }
        }
        jParser.close();
        System.out.println(parsedName);
        System.out.println(parsedAge);
        System.out.println(addresses);
    }

}
