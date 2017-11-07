package com.studentapp.features.studentapp;

import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.testbase.TestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by magn on 11/6/2017.
 */
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentCRUDTest extends TestBase{

    static String randomStr = TestUtils.getRandomValue();
    static String firstName = "SMOKEE" + randomStr;
    static String lastName = "TABACOO" + randomStr;
    static String email = randomStr + "somketaba@gmail.com";
    static String programme = "ComputerSience";




    @Title("This test will create the student")
    @Test
    public void A_createStudent() {

        ArrayList<String> courses = new ArrayList<>();
        courses.add("JAVA");
        courses.add("Python");

        StudentClass student = new StudentClass();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);


        SerenityRest.rest()
                .given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .body(student)
                .post()
                .then()
                .log()
                .all()
                .statusCode(201);

    }

    @Title("verify if student added to app")
    @Test
    public void B_getStudentTest() {

        String p1 = "findAll{it.firstName=='";
        String p2 = "'}.get(0)";

        HashMap<String, Object> value = SerenityRest.rest().given()
                .when()
                .get("/list")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .path(p1 + firstName + p2);

        System.out.println(" ------------------> " + value);


    }
}
