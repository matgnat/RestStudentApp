package com.studentapp.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * Created by magn on 11/9/2017.
 */
public class ReusableSpecyfication {

    public static RequestSpecBuilder requestSpecBuilder;
    public static RequestSpecification requestSpec;

    public static ResponseSpecBuilder responseSpecBuilder;
    public static ResponseSpecification responseSpec;


    public static RequestSpecification getGenericRequestSpec() {
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpec = requestSpecBuilder.build();
        return requestSpec;
    }

    public static ResponseSpecification getGenericResponsSpec() {
        responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectHeader("Content-Type", "application/json;charset=UTF-8");
        responseSpecBuilder.expectHeader("Transfer-Encoding", "chunked");
        //responseSpecBuilder.expectResponseTime()
        responseSpec = responseSpecBuilder.build();
        return responseSpec;
    }
}
