
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.filter.session.SessionFilter;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class Login {

    public static void main(String[] args) throws IOException {
        CookieFilter cookieFilter = new CookieFilter();
        Filter sessionFilter = new SessionFilter();

        RestAssured.baseURI = "https://test-us-partner.store.mt.com";


        String loginPage = given().log().all().filter(sessionFilter).filter(cookieFilter)
                .when().get("/login")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        Document logPage = Jsoup.parse(loginPage);
        String csrfTokenLogin = logPage.select("input[name=CSRFToken]").val();
        System.out.println(csrfTokenLogin);


        given().log().all().filter(sessionFilter).filter(cookieFilter)
                .contentType("multipart/form-data")
                .multiPart("username", "borko.vranic@sixsentix.com")
                .multiPart("password", "test1234")
                .multiPart("CSRFToken", csrfTokenLogin)
                .when().post("/login_check_process")
                .then().log().all().assertThat().statusCode(302);


        given().log().all().filter(sessionFilter).filter(cookieFilter)
                .contentType("multipart/form-data")
                .multiPart("businessPartnerId", "301079906")
                .multiPart("CSRFToken", "csrfTokenLogin")
                .when().post("/select-sold-to")
                .then().log().all().assertThat().statusCode(302);

    String homepage = given().log().all().filter(sessionFilter).filter(cookieFilter)
                .when().get("")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        Document homePage= Jsoup.parse(homepage);
        String csrfTokenHomepage = homePage.select("input[name=CSRFToken]").val();
        System.out.println(csrfTokenHomepage);


      String customerpage= given().log().all().filter(sessionFilter).filter(cookieFilter)
                .queryParam("companyName1", "Sixsentix")
                .queryParam("companyName2", "Firma")
                .queryParam("addressLine1","Milutina Milankovica")
                .queryParams("addressLine2","Sabacka")
                .queryParam("industryLevel1","1004")
                .queryParam("industryLevel2","2008")
                .queryParam("city", "Belgrade")
                .queryParam("state", "DE")
                .queryParam("postalCode", "12345")
                .queryParam("country", "US")
                .queryParam("language", "en_US")
                .queryParam("firstName", "Bojana")
                .queryParam("contactLanguage", "en_US")
                .queryParam("lastName", "Trifunovic")
                .queryParam("workplace", "IT")
                .queryParam("email", "single.10acnt@gmail.com")
                .queryParam("phoneNumber", "123456789693")
                .queryParam("CSRFToken",csrfTokenHomepage)
                //.header("Cookie", cookie)
                .when().get("/createLead/customerInfo")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        Document customerPage= Jsoup.parse(customerpage);
        String csrfTokenCustomerpage = customerPage.select("input[name=CSRFToken]").val();
        System.out.println(csrfTokenCustomerpage);


        given().log().all().filter(sessionFilter).filter(cookieFilter).contentType("multipart/form-data")
                .multiPart("description", "Deskripcija")
                .multiPart("qualificationLevel", "Hot")
                .multiPart("sbu", "MD")
                .multiPart("territoryKey", "RENTAL")
                .multiPart("assignTo", "507040008")
                .multiPart("isEmailSendToLeadMan", "on")
                .multiPart("notes", "bl bla")
                .multiPart("CSRFToken", csrfTokenCustomerpage)
                .when().post("/createLead/lead-details")
                .then().log().all().assertThat().statusCode(200);


    }
}

