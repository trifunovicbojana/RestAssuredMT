
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.filter.session.SessionFilter;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Node;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class AddToCart {
    public static void main(String[] args) throws IOException {
        CookieFilter cookieFilter = new CookieFilter();
        Filter sessionFilter = new SessionFilter();

        //RestAssured.baseURI = "https://test-us-partner.store.mt.com";


        String loginPage = given().log().all().filter(sessionFilter).filter(cookieFilter)
                .when().get("https://test-us-partner.store.mt.com/login")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        Document logPage = Jsoup.parse(loginPage);
        String csrfTokenLogin = logPage.select("input[name=CSRFToken]").val();
        System.out.println(csrfTokenLogin + "tokenLogin");


        given().log().all().filter(sessionFilter).filter(cookieFilter)
                .contentType("multipart/form-data")
                .multiPart("username", "borko.vranic@sixsentix.com")
                .multiPart("password", "test1234")
                .multiPart("CSRFToken", csrfTokenLogin)
                .when().post("https://test-us-partner.store.mt.com/login_check_process")
                .then().log().all().assertThat().statusCode(302);

        String soldToPage = given().log().all().filter(sessionFilter).filter(cookieFilter)
                .when().get("https://test-us-partner.store.mt.com/login")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        Document soldtoPage = Jsoup.parse(soldToPage);
        String csrfTokenSoldTo = soldtoPage.select("input[name=CSRFToken]").val();
        System.out.println(csrfTokenSoldTo + "tokensoldto");


        given().log().all().filter(sessionFilter).filter(cookieFilter)
                .contentType("multipart/form-data")
                .multiPart("businessPartnerId", "301079906")
                .multiPart("CSRFToken", csrfTokenSoldTo)
                .when().post("https://test-us-partner.store.mt.com/select-sold-to")
                .then().log().all().assertThat().statusCode(302);

        System.out.println(sessionFilter + "sesija" + cookieFilter);
        String homepage = given().log().all().filter(sessionFilter).filter(cookieFilter)
                .when().get("https://test-us-partner.store.mt.com")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        Document homePage = Jsoup.parse(homepage);
        String csrfTokenHomepage = homePage.select("input[name=CSRFToken]").val();
        System.out.println(csrfTokenHomepage);


        String productsHTMLPLP = given().log().all().filter(sessionFilter).filter(cookieFilter)
                .when().get("https://test-us-partner.store.mt.com/Products/Laboratory-Weighing/Micro-Ultra-Balances/c/990005")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();


        Document productsHTMLPLPDoc = Jsoup.parse(productsHTMLPLP);
        String productsPLP = productsHTMLPLPDoc.select(("span.code")).text();
        System.out.println(productsPLP);

//Converting String to Array

        String[] productsIDArray = productsPLP.split("[()]+");
        List<String> list = new ArrayList<>();
        for (int i = 1; i < productsIDArray.length; i += 2) {
            list.add(productsIDArray[i]);
        }
        String[] array = list.toArray(new String[0]);
        System.out.println(array[0]);

    String getPriceResponse=given().relaxedHTTPSValidation().log().all().auth().basic("HTTP4HYBRIS", "K6Q&2%tE")
                .header("Content-Type", "application/xml")
                .body(PayloadMT.getPrice(array))
                .when().post("https://ch00voi5s.eu.mt.mtnet/HttpAdapter/HttpMessageServlet?senderService=O91HYBRIS&senderParty=&agency=&scheme=&interfaceNamespace=urn:mt.com:A:HYBRIS:eCommerce&interface=CustomerPrices_Out_Sync&qos=BE")
                .then().log().all()
                .assertThat().statusCode(200).extract().response().asString();

XmlPath getPriceResponseXml=new XmlPath(getPriceResponse);
        String firstProductWithPrice = getPriceResponseXml.get("n0:CustomerPrices_Res.ITEM.findAll{it.ERRORCODE==200}.PRODUCT[0]");
        System.out.println(firstProductWithPrice);

   String addToCartHtml= given().log().all().filter(sessionFilter).filter(cookieFilter)
                .contentType("multipart/form-data")
                .multiPart("CSRFToken", csrfTokenHomepage)
                .multiPart("qty", "1")
                .multiPart("productCodePost", firstProductWithPrice)
                .when().post("https://test-us-partner.store.mt.com/cart/add")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

if (addToCartHtml.contains("Added to Cart")) {
            System.out.println("Added to Cart");

        }
    }

}






