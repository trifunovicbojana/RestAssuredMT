

import io.restassured.filter.Filter;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.filter.session.SessionFilter;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class priceCall {
    public static void main(String[] args) throws IOException {
        String ProductsNumbers[]={"(524545)","(58585)"};
        given().relaxedHTTPSValidation().log().all().auth().basic("HTTP4HYBRIS", "K6Q&2%tE")
                .header("Content-Type", "application/xml")
                .body(PayloadMT.getPrice(ProductsNumbers))
                .when().post("https://ch00voi5s.eu.mt.mtnet/HttpAdapter/HttpMessageServlet?senderService=O91HYBRIS&senderParty=&agency=&scheme=&interfaceNamespace=urn:mt.com:A:HYBRIS:eCommerce&interface=CustomerPrices_Out_Sync&qos=BE")
                .then().log().all()
                .assertThat().statusCode(200);

    }
}
