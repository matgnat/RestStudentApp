package com.studentapp.cucumber.stepsDef;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.WithTag;

/**
 * Created by magn on 11/16/2017.
 */
public class CucumStudentStep {

    public static Response response;

    @When("^User send a GET request to the list endpoint$")
    public void userSendAGETRequestToTheListEndpoint() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        response = SerenityRest.rest()
                .given()
                .when()
                .get("/list");

    }

    @Then("^Must get back a valid status code (\\d+)$")
    public void mustGetBackAValidStatusCode(int code) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        response
                .then()
                .statusCode(code);
    }
}

