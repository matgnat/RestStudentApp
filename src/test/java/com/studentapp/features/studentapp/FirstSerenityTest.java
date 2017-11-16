package com.studentapp.features.studentapp;

import com.studentapp.testbase.TestBase;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.WithTag;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by magn on 11/3/2017.
 */
//@RunWith(SerenityRunner.class)
public class FirstSerenityTest extends TestBase{

//    @BeforeClass
//    public static void init() {
//        RestAssured.baseURI="http://localhost:8080/student";
//    }


    @Test
    public void getAllStudents() {
        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void thisIsFailing() {
        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .log()
                .all()
                .statusCode(500);
    }

    /**
     * pending test - not complete yet
     * decorator provide by serenity
     */
    @Pending
    @Test
    public void thisIsPendingTest() {

    }

    /**
     * ignore test
     * decorator provide by junit
     */
    @Ignore
    @Test
    public void thisIsSkippTest() {

    }


    @Test
    public void thisIsError() {
        System.out.println(5/0);
    }

    @Test
    public void fileDoesNotExist() throws FileNotFoundException {
        File file = new File("C://some.txt");
        FileReader fileReader = new FileReader(file);
    }

    @Manual
    @Test
    public void thisIsManulaTest(){

    }

}
