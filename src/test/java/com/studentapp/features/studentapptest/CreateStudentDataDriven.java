package com.studentapp.features.studentapptest;

import com.studentapp.cucumber.steps.CreateStudentSteps;
import com.studentapp.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by magn on 11/9/2017.
 */
@Concurrent(threads = "4x")
@UseTestDataFrom("C:\\Users\\magn.MOBICAPL\\IdeaProjects\\StudentApp\\src\\test\\resorces\\dataFile\\studentData.csv")
//@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentDataDriven extends TestBase{

    public String firstName;
    public String lastName;
    public String email;
    public String programme;
    public String course;
    public ArrayList<String> courses;
    /*    @Qualifier
    public String qualifier() {
        return firstName + "=>" + lastName + "=>" + email + "=>" + programme;
    }*/

    @Steps
    CreateStudentSteps studentSteps;

    @Title("DataDriven for adding multiple number of student for app")
    @Test
    public void createMultipleStudent() {

    ArrayList<String> courses = new ArrayList<>();
    courses.add(course);


    studentSteps.createStudent(firstName, lastName, email, programme, courses)
                .statusCode(201).log().all();

    }
}
