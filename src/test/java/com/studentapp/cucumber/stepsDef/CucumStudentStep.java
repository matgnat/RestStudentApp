package com.studentapp.cucumber.stepsDef;

import com.studentapp.cucumber.steps.CreateStudentSteps;
import com.studentapp.utils.TestUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.collection.IsMapContaining;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by magn on 11/16/2017.
 */
public class CucumStudentStep {

    public static Response response;
    public static String randomEmail;

    @Steps
    CreateStudentSteps createStudentSteps;


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

    @When("^I send POST request for student's creation with parameter (.*), (.*), (.*), (.*), (.*)$")
    public void iSendPOSTRequestForStudentSCreationWithParameterFirstNameLastNameEmailProgrammeCourse(String firstName, String lastName, String email, String programme, String course) throws Throwable {
        List<String> courses = new ArrayList<>();
        courses.add(course);

        randomEmail = TestUtils.getRandomValue();
        email = randomEmail + email;
        createStudentSteps.createStudent(firstName, lastName, email, programme, courses)
                .assertThat()
                .statusCode(201);
    }


    @Then("^New possition student (.*) should be created$")
    public void newPossitionStudentFirstNameShouldBeCreated(String firstName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        HashMap<String, Object> studentInfo = createStudentSteps.getStudentInfo(firstName);

        Assert.assertThat(studentInfo, IsMapContaining.hasValue(firstName));
    }
}

