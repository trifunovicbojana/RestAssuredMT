package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class DynimicJson {
    @Test(dataProvider = "BookData")
    public void addBook(String isbn, String aisle) throws IOException {
        RestAssured.baseURI= "http://216.10.245.166";
        String response = given().log().all().header("Content-Type", "application/json")
                .body(payload.Addbook(isbn,aisle))
               // .body(new String(Files.readAllBytes(Paths.get("C:\\Users\\btrifunovic\\OneDrive - Sixsentix AG\\Desktop\\file.json"))))
                .when()
                .post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        System.out.println(response);
        JsonPath js=ReusableMethods.rowToJson(response);
        String id=js.getString("ID");
        System.out.println(id);

        //DeleteBook
        String deleteReseponse=given().header("Content-Type","application/json")
                .body("{\n" +
                        " \n" +
                        "\"ID\" : \""+id+"\"\n" +
                        " \n" +
                        "} \n")
                .when()
                .post("/Library/DeleteBook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath jsdelete=ReusableMethods.rowToJson(deleteReseponse);
        String message=jsdelete.getString("msg");
        System.out.println(message);

    }
    @DataProvider(name="BookData")
    public Object[][] getData()
    {
      return  new Object [][] {{"dgif","64654"}, {"fffhg","4656"},{"fgkjj","854555"}};
    }
}
//,{"dfyd","54561"},{"hudfh","64563"}};