package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Utils {
    public static JsonPath rawToJson(Response response) {
        String responseString = response.asString();
        JsonPath json = new JsonPath(responseString);
        return json;
    }

    public static RequestSpecification getRequestSpecification() {
        return RestAssured.given().contentType(ContentType.JSON);
    }
}
