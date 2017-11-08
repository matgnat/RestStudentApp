package com.studentapp.cucumber.serenity;

import com.studentapp.model.StudentClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by magn on 11/8/2017.
 */
public class CreateStudentSteps
{

    @Step("Create student with firstName: {0}, lastName: {1}, email: {2}, programme: {3}, courses: {4}")
    public ValidatableResponse createStudent(String firstName, String lastName, String email, String programme, ArrayList<String> courses) {

        StudentClass studentClass = new StudentClass();
        studentClass.setFirstName(firstName);
        studentClass.setLastName(lastName);
        studentClass.setEmail(email);
        studentClass.setProgramme(programme);
        studentClass.setCourses(courses);

        return SerenityRest.rest()
                .given()
                .contentType(ContentType.JSON)
                .when()
                .body(studentClass)
                .post()
                .then();
    }

    @Step("Getting the student info with firstName: {0}")
    public HashMap<String, Object> getStudentInfo(String firstName) {

        String p1 = "findAll{it.firstName=='";
        String p2 = "'}.get(0)";

        return SerenityRest.rest().given()
                .when()
                .get("/list")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .path(p1 + firstName + p2);
    }

    @Step("Update the existing student with id: {0} and firstName: {1}")
    public ValidatableResponse updateStudent(int studenId, String firstName, String lastName, String email, String programme, ArrayList<String> courses) {


        StudentClass student = new StudentClass();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);


        return SerenityRest.rest()
                .given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .body(student)
                .put("/" + studenId)
                .then()
                .log()
                .all();

    }



    @Step("Delete student with id: {0}")
    public Response deleteStudent(int studenId) {

        return SerenityRest.rest()
                .given()
                .when()
                .delete("/" + studenId);
    }



    @Step("Find student with id: {0}")
    public ValidatableResponse getStudentWithID(int studentId) {

        return SerenityRest.rest()
                .given()
                .when()
                .get("/" + studentId)
                .then()
                .log()
                .all();
    }

}
