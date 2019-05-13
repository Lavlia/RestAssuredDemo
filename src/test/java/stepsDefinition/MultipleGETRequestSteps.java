package stepsDefinition;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.API_Utils;
import utils.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MultipleGETRequestSteps extends API_Utils {
    Response response;
    Map<String, Response> responseMap = new HashMap<>();

    @When("User wants to retrieve information about vehicles")
    public void userWantsToRetrieveInformationAboutVehicles(DataTable table) {

        RequestSpecification requestSpecification = new API_Utils().getRequestSpecification();

        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            requestSpecification.pathParam("id", data.get(i).get("id"));
            requestSpecification.queryParam("format", "json");
            response = requestSpecification.get(Constants.MULTIPLE_GET_RESOURCESW);
            response.then().log().all();
            testContext().setResponse(response);
            responseMap.put("TN" + i, testContext().getResponse());
        }
    }

    @Then("User response code should be (\\d+)")
    public void userResponseCodeShouldBe(int statusCode) {
        for (Map.Entry<String, Response> entry : responseMap.entrySet()) {
            Assert.assertEquals(entry.getValue().statusCode(), statusCode);
            SoftAssert softAssert = new SoftAssert();
            String name = API_Utils.rawToJson(entry.getValue()).get("name");
            String model = API_Utils.rawToJson(entry.getValue()).get("model");
            softAssert.assertTrue(!name.equalsIgnoreCase(""), "Name is not blank");
            softAssert.assertTrue(!model.equalsIgnoreCase(""), "Name is not blank");
            softAssert.assertAll();
        }
    }
}

