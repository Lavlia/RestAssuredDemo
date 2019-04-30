package stepsDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import utils.API_Utils;
import utils.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class POSTRequestSteps {
    Response response;

    @When("User sets the following payload and sends POST request")
    public void userSetsTheFollowingPayloadAndSedsPOSTRequest(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        HashMap<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("name", data.get(0).get("name"));
        jsonObject.put("isbn", data.get(0).get("isbn"));
        jsonObject.put("aisle", data.get(0).get("aisle"));
        jsonObject.put("author", data.get(0).get("author"));

        RequestSpecification requestSpecification = new API_Utils().getRequestSpecification();
        requestSpecification.body(jsonObject);
        response = requestSpecification.post(Constants.POST_RESOURCEBOOK);
    }

    @Then("The status code should be (\\d+)")
    public void theStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }
}
