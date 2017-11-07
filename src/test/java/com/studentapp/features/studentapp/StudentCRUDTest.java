package com.studentapp.features.studentapp;

import com.studentapp.testbase.TestBase;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

/**
 * Created by magn on 11/6/2017.
 */
public class StudentCRUDTest extends TestBase{

    @Title("This test will create the student")
    @Test
    public void createStudent() {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .when()
                .body("")
                .post();
    }
}
