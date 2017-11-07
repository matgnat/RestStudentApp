package com.studentapp.testbase;

import com.gargoylesoftware.htmlunit.javascript.host.ReadableStream;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by magn on 11/6/2017.
 */
public class TestBase {
    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost:8080/student/";
    }
}
