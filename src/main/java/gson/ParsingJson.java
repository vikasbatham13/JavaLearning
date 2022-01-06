package gson;
import java.util.List;
import com.google.gson.*;

public class ParsingJson {

    public static void main(String args[]){
        String jsonStr = "{\"requestId\":\"12344556753435433553\",\"providerIds\": [\"RW-BOOST\",\"DISH\",\"SLING\"]}";
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(jsonStr);
        if(jsonElement.isJsonObject()) {
            JsonObject studentObj = jsonElement.getAsJsonObject();
            System.out.println("requestId is: " + studentObj.get("requestId"));
            JsonArray jsonArray = studentObj.getAsJsonArray("providerIds");
            for (int i =0 ; i<jsonArray.size();i++){
                System.out.println(jsonArray.get(i));
            }
            System.out.println("providerIds:" + jsonArray);
        }
    }
}
