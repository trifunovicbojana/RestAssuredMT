import files.ReusableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class Basics {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        //Create Place
        String response = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(payload.AddPlace())
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
       // System.out.println(response);

        JsonPath js = new JsonPath(response); //for parsing Json
       String placeId=js.getString("place_id");
        System.out.println(placeId);

        //Update Place
        String newAddress="Summer Walk, Africa";

given().log().all().queryParam("key","qaclick123").
      header("Content-Type", "application/json")
        .body("{\n" +
                "\"place_id\":\""+placeId+"\",\n" +
                "\"address\":\""+newAddress+"\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}")
        .when().put("maps/api/place/update/json")
        .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

      //Get Place
       String getPlaceResponse= given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId ).
                when().get("/maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js1=ReusableMethods.rowToJson(getPlaceResponse);
        String actualAddress= js1.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress,newAddress);

    }

}
