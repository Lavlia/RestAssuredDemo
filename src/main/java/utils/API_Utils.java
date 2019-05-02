package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Random;

public class API_Utils {
    public static JsonPath rawToJson(Response response) {
        String responseString = response.asString();
        JsonPath json = new JsonPath(responseString);
        return json;
    }

    public static RequestSpecification getRequestSpecification() {
        return RestAssured.given().contentType(ContentType.JSON);
    }

    public static String getRandomId(String data) {
        Random random = new Random();
        int bound = 1000000;
        int randomInteger = random.nextInt(bound);
        int integerFromString = Integer.parseInt(data);
        int intNumber = randomInteger + integerFromString;
        return Integer.toString(intNumber);
    }
}
