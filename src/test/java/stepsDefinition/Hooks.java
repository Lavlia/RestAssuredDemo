package stepsDefinition;

import cucumber.api.java.Before;
import io.restassured.RestAssured;

import utils.Constants;

public class Hooks {
    @Before
    public void initialization() {
        RestAssured.baseURI = Constants.ENDPOINT;

    }
}
