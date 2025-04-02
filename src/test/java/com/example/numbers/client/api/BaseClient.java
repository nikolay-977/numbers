package com.example.numbers.client.api;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class BaseClient {

    protected RequestSpecification getRequestSpecification() {
        return given()
                .contentType(ContentType.JSON)
                .log().all();
    }

    protected ResponseSpecification getResponseSpecification() {
        return expect().contentType(ContentType.JSON);
    }
}
