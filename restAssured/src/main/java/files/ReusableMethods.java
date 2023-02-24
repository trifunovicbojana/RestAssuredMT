package files;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMethods {
    public static JsonPath rowToJson (String Response) {
        JsonPath js1=new JsonPath(Response);
        return js1;
    }
}
