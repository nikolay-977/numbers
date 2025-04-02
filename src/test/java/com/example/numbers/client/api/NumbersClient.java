package com.example.numbers.client.api;

import io.restassured.response.ValidatableResponse;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;

public class NumbersClient extends BaseClient {
    public static final String API_PATH = "/api/numbers";

    public ValidatableResponse calculateNumbersOk(Object request) {
        return getRequestSpecification()
                .body(request)
                .when()
                .post(API_PATH)
                .then()
                .spec(getResponseSpecification())
                .statusCode(SC_OK);
    }

    public ValidatableResponse calculateNumbersBadRequest(Object request) {
        return getRequestSpecification()
                .body(request)
                .when()
                .post(API_PATH)
                .then()
                .spec(getResponseSpecification())
                .statusCode(SC_BAD_REQUEST);
    }
}
