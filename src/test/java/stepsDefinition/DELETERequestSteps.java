package stepsDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import utils.API_Utils;
import utils.Constants;
import utils.Data;

public class DELETERequestSteps {
    Response response;

    @When("User wants to remove a book with valid id")
    public void userWantsToRemoveABookWithValidId() {
        RequestSpecification requestSpecification = new API_Utils().getRequestSpecification();
        requestSpecification.body("{\"ID\":" + Data.getId() + "\"}");
        response = requestSpecification.post(Constants.DELETE_RESOURCEBOOK);
    }

    @Then("Response should have status code (\\d+)")
    public void responseShouldHaveStatusCode(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }
}
