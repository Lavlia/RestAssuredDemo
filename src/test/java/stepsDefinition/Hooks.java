package stepsDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;

import utils.Constants;
import utils.TestContext;

public class Hooks {

    @Before("@GetOperation")
    public void initializationGet() {
        RestAssured.baseURI = Constants.ENDPOINTSW;
    }

    @Before("@PostDeleteOperation")
    public void initializationPost() {
        RestAssured.baseURI = Constants.ENDPOINTBOOK;
    }

    @After
    public void tearDown() {
        TestContext.CONTEXT.reset();
    }
}
