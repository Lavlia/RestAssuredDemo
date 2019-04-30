package stepsDefinition;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.API_Utils;
import utils.Constants;
import utils.Result;
import utils.SW;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GETRequestSteps {

    Response response;
    SW sw;

    @When("^User wants to get a list of starships from different([^\"]*)$")
    public void userWantsToGetAListOfStarshipsFromDifferentPageNumbers(String pageNumber) {

        RequestSpecification requestSpecification = new API_Utils().getRequestSpecification();

        //Set the query parameters
        requestSpecification.queryParam("format", "json");
        requestSpecification.queryParam("page", pageNumber);

        response = requestSpecification.get(Constants.GET_RESOURCE);

        sw = response.as(SW.class, ObjectMapperType.GSON);
    }

    @Then("Status code should be (\\d+)")
    public void statusCodeShouldBe(int statusCode) {

        Assert.assertEquals(response.statusCode(), statusCode);
        int size = API_Utils.rawToJson(response).get("results.size()");

        for (int i = 0; i < size; i++) {
            String name = API_Utils.rawToJson(response).get("results[" + i + "].name");
            System.out.println(name);
        }

        Assert.assertTrue(response.getTimeIn(TimeUnit.SECONDS) <= 10, "Response time is not within limit");

        SoftAssert softAssert = new SoftAssert();

        List<Result> results = sw.getResults();
        for (Result result : results) {
            softAssert.assertTrue(!result.getName().equalsIgnoreCase(""), "Name is not blank");
            softAssert.assertTrue(!result.getModel().equalsIgnoreCase(""), "Model is not blank");
        }

        softAssert.assertAll();
    }
}
