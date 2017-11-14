package com.studentapp.features.studentapptest;

import com.studentapp.testbase.TestBase;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

/**
 * Created by magn on 11/14/2017.
 */
public class TagTest extends TestBase{


    @Title("Provide a 405 status code when incorrect HTTP method is used to access resources")
    @Test
    public void inValidMethod() {
        SerenityRest
                .rest()
                .given()
                .when()
                .post("/list")
                .then()
                .statusCode(405)
                .log()
                .all();
    }

    @Title("Verify if GET method will return status code 200")
    @Test
    public void verifyIfTheStatusCodeIs200() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

    @Title("Test will provide incorrect status code 400 becouse of fake resource")
    @Test
    public void incorrectResource() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/listfake")
                .then()
                .statusCode(400)
                .log()
                .all();
    }
}
