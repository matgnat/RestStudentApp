package com.studentapp.features.studentapp;

import com.studentapp.cucumber.serenity.CreateStudentSteps;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.hamcrest.collection.IsMapContaining;
import org.junit.Assert;
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
    static String programme = "ComputerScience";
    static int studenId;


    @Steps
    CreateStudentSteps steps;

    @Title("This test will create the student")
    @Test
    public void A_createStudent() {

        ArrayList<String> courses = new ArrayList<>();
        courses.add("JAVA");
        courses.add("Python");

        steps.createStudent(firstName, lastName, email, programme, courses)
                .statusCode(201);
    }

    @Title("verify if student added to app")
    @Test
    public void B_getStudentTest() {

        String p1 = "findAll{it.firstName=='";
        String p2 = "'}.get(0)";

        HashMap<String, Object> value = steps.getStudentInfo(firstName);

        Assert.assertThat(value, IsMapContaining.hasValue(firstName));
        Assert.assertThat(value, IsMapContaining.hasEntry("firstName", firstName));

        studenId = (int) value.get("id");
    }


    @Title("Update first name")
    @Test
    public void C_updateStudent() {

        ArrayList<String> courses = new ArrayList<>();
        courses.add("JAVA");
        courses.add("Python");

        firstName = firstName + "_update";

        steps.updateStudent(studenId, firstName, lastName, email, programme, courses)
                .statusCode(200);

        HashMap<String, Object> value = steps.getStudentInfo(firstName);
        Assert.assertThat(value, IsMapContaining.hasValue(firstName));
    }

    @Title("Delete student and verify if student is deleted")
    @Test
    public void D_deleteStudent() {

        steps.deleteStudent(studenId);

        steps.getStudentWithID(studenId)
                .statusCode(404);

    }
}
