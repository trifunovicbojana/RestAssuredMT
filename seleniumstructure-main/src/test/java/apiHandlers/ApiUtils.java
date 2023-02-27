package apiHandlers;

import apiPOJO.billingService.auth.AuthResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sixsentix.qa.util.Resources;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONException;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static apiHandlers.testDataBuilder.login.LoginAuth.loginAuthorization;
import static io.restassured.RestAssured.given;

public class ApiUtils {

    private static RequestSpecification req;
    private static PrintStream log;


    /**
     * @return the configuration for timeout before the error is thrown.
     */
    private static RestAssuredConfig apiTimeout() {
        RestAssuredConfig config;

        config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout", 10000)
                        .setParam("http.connection.timeout", 10000));

        return config;
    }

    /**
     * Write everything into logging.text file.
     */
    static {
        try {
            log = new PrintStream(new FileOutputStream("logging.text"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getToken() {
        String resource = AuthResources.login.getResource();
        RestAssured.baseURI = Resources.stagingAPIConnection.getResource();

        String responseForToken = POST(AddPayloadWithObject(loginAuthorization("admin")), resource, 200).asString();

        JsonPath accessToken = new JsonPath(responseForToken);
        return accessToken.getString("access_token");
    }

    public static String getToken(String accountType) {
        String resource = AuthResources.login.getResource();
        RestAssured.baseURI = Resources.stagingAPIConnection.getResource();

        String responseForToken = POST(AddPayloadWithObject(loginAuthorization(accountType)), resource, 200).asString();

        JsonPath accessToken = new JsonPath(responseForToken);
        return accessToken.getString("access_token");
    }

    public static RequestSpecification requestSpecificationWithHeader() {
        req = null;
        req = new RequestSpecBuilder().setBaseUri(Resources.stagingAPIConnection.getResource())
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON)
                .build()
                .header("Authorization", "Bearer " + getToken());
        return req;
    }

    public static RequestSpecification requestSpecificationWithHeader(String accountType) {
        req = null;
        req = new RequestSpecBuilder().setBaseUri(Resources.stagingAPIConnection.getResource())
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON)
                .build()
                .header("Authorization", "Bearer " + getToken(accountType));
        return req;
    }

    public static RequestSpecification requestSpecification() {
        req = null;
        req = new RequestSpecBuilder().setBaseUri(Resources.stagingAPIConnection.getResource())
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON)
                .build();
        return req;
    }

    private static RequestSpecification requestSpecificationWithQueryParam(String paramName, String paramValue) {
        if (req == null) {
            req = new RequestSpecBuilder().setBaseUri(Resources.stagingAPIConnection.getResource())
                    .addQueryParam(paramName, paramValue)
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON)
                    .build();
            return req;
        }
        return req;
    }

    public static RequestSpecification requestSpecWithQueryParams(String parameterName, String parameterValue) {
        RequestSpecification requestSpecification = null;

        try {
            requestSpecification = given().config(apiTimeout()).spec(requestSpecificationWithQueryParam(parameterName, parameterValue));
        } catch (Exception e) {
            Assert.fail(e.getMessage() + " We didn't get response in set timeout period.");
        }

        return requestSpecification;
    }

    public static RequestSpecification requestSpecWithDataBuilder(Object object, String token) {
        RequestSpecification requestSpecification = null;

        try {
            requestSpecification = given()
                    .config(apiTimeout())
                    .spec(requestSpecificationWithHeader())
                    .body(object);
        } catch (Exception e) {
            Assert.fail(e.getMessage() + " We didn't get response in set timeout period.");
        }

        return requestSpecification;
    }

    public static RequestSpecification requestSpecificationForGETWithHeader() {
        RequestSpecification requestSpecification = null;

        try {
            requestSpecification = given().config(apiTimeout()).spec(requestSpecificationWithHeader());
        } catch (Exception e) {
            Assert.fail(e.getMessage() + " We didn't get response in set timeout period.");
        }

        return requestSpecification;
    }

    public static RequestSpecification requestSpecificationForGET() {
        RequestSpecification requestSpecification = null;

        try {
            requestSpecification = given().config(apiTimeout()).spec(requestSpecification());
        } catch (Exception e) {
            Assert.fail(e.getMessage() + " We didn't get response in set timeout period.");
        }

        return requestSpecification;
    }

    public static RequestSpecification AddPayload(Object object, String token) {
        RequestSpecification requestSpecification = null;

        try {
            requestSpecification = given().config(apiTimeout()).spec(requestSpecification().header("Authorization", "Bearer " + token)).body(object);
        } catch (Exception e) {
            Assert.fail(e.getMessage() + " We didn't get response in set timeout period.");
        }

        return requestSpecification;
    }

    public static RequestSpecification AddPayloadWithObject(Object object) {
        RequestSpecification requestSpecification = null;

        try {
            requestSpecification = given().config(apiTimeout()).spec(requestSpecification()).body(object);
        } catch (Exception e) {
            Assert.fail(e.getMessage() + " We didn't get response in set timeout period.");
        }

        return requestSpecification;
    }

    public static RequestSpecification AddPayloadWithObjectTest(String accountType, Object object) {
        RequestSpecification requestSpecification = null;

        try {
            requestSpecification = given().config(apiTimeout()).spec(requestSpecification()).header("Authorization", "Bearer " + getToken(accountType)).body(object);
        } catch (Exception e) {
            Assert.fail(e.getMessage() + " We didn't get response in set timeout period.");
        }

        return requestSpecification;
    }

    public static RequestSpecification authorizeWithToken(String token) {
        RequestSpecification requestSpecification = null;

        try {
            requestSpecification = given().config(apiTimeout()).spec(requestSpecification().header("Authorization", "Bearer " + token));
        } catch (Exception e) {
            Assert.fail(e.getMessage() + " We didn't get response in set timeout period.");
        }

        return requestSpecification;
    }

    private static ResponseSpecification responseSpecification(int statusCode) {
        return new ResponseSpecBuilder().expectStatusCode(statusCode).build();
    }


    public static Response POST(RequestSpecification requestSpec, String resource, int statusCode) {
        Response response = null;
        try {
            response = requestSpec.when().config(apiTimeout()).post(resource).then().spec(responseSpecification(statusCode)).extract().response();
        } catch (Exception e) {
            Assert.fail(e.getMessage() + " We didn't get response in set timeout period.");
        }
        return response;
    }

    public static Response DELETE(String accountType, RequestSpecification requestSpec, String resource, int statusCode) {
        Response response = null;
        try {
            response = given().spec(requestSpec).header("Authorization", "Bearer " + getToken(accountType)).when().config(apiTimeout()).delete(resource).then().spec(responseSpecification(statusCode)).extract().response();
        } catch (Exception e) {
            Assert.fail(e.getMessage() + " We didn't get response in set timeout period.");
        }
        return response;
    }


    public static Response POST(Object object, String token, String resource, int statusCode) {
        Response response = null;
        try {
            response = AddPayload(object, token).config(apiTimeout()).when().post(resource).then().spec(responseSpecification(statusCode)).extract().response();
        } catch (Exception e) {
            Assert.fail(e.getMessage() + " We didn't get response in set timeout period.");
        }

        return response;
    }

    public static Response PUT(RequestSpecification requestSpec, String resource, int statusCode) {
        Response response = null;

        try {
            response = requestSpec.when().put(resource).then().spec(responseSpecification(statusCode)).extract().response();
        } catch (Exception e) {
            Assert.fail(e.getMessage() + " We didn't get response in set timeout period.");
        }

        return response;
    }

    public static Response GET(RequestSpecification requestSpec, String resource, int statusCode) {
        Response response = null;

        try {
            response = requestSpec.when().config(apiTimeout()).get(resource).then().spec(responseSpecification(statusCode)).extract().response();
        } catch (Exception e) {
            Assert.fail(e.getMessage() + " We didn't get response in set timeout period.");
        }

        return response;
    }

    public static Response GET(String token, String resource, int statusCode) {
        Response response = null;

        try {
            response = authorizeWithToken(token).when().get(resource).then().spec(responseSpecification(statusCode)).extract().response();
        } catch (Exception e) {
            Assert.fail(e.getMessage() + " We didn't get response in set timeout period.");
        }

        return response;
    }

    protected static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    public static boolean compareTwoJsonFilesAndIgnoreOneParam(String expected, String actual, String path) {
        //Path example: "[*].id"
        try {
            JSONAssert.assertEquals(expected, actual,
                    new CustomComparator(JSONCompareMode.STRICT,
                            new Customization(path, (o1, o2) -> true)));
        } catch (JSONException e) {
            Assert.fail(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * @param response   expected response from request.
     * @param modelClass class that you are working with and from which you want to use getter.
     * @return type is Object, you can use it after to iterate through and extract desired value.
     */
    public static <T> Object deserializeResponse(Response response, Class<T> modelClass) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        return objectMapper.readValue(response.asString(), modelClass);
    }

}
