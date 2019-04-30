package stepsDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.API_Utils;
import utils.Constants;
import utils.Result;
import utils.SW;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GETRequestSteps {

    Response response;
    SW sw;

    @When("User wants to get a list of starships")
    public void userWantsToGetAListOfStarships() {
        RequestSpecification requestSpecification = new API_Utils().getRequestSpecification();
        response = requestSpecification.get(Constants.GET_RESOURCE);
        requestSpecification.queryParam("format", "json").queryParam("page", "1");
        sw = response.as(SW.class, ObjectMapperType.GSON);
    }

    @Then("Status code should be (\\d+)")
    public void statusCodeShouldBe(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
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
