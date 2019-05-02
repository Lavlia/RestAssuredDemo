package stepsDefinition;

import cucumber.api.java.Before;
import io.restassured.RestAssured;

import utils.Constants;

public class Hooks {

    @Before("@GetOperation")
    public void initializationGet() {
        RestAssured.baseURI = Constants.ENDPOINTSW;
    }

    @Before("@PostDeleteOperation")
    public void initializationPost() {
        RestAssured.baseURI = Constants.ENDPOINTBOOK;
    }
}
