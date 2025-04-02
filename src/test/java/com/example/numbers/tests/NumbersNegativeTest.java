package com.example.numbers.tests;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersNegativeTest extends BaseTest {

    private static Stream<TestData> testData() {
        return Stream.of(
                new TestData("int", "{\"numbers\": 1}", "An error occurred: JSON parse error: Cannot deserialize value of type `java.util.ArrayList<java.lang.Integer>` from Integer value (token `JsonToken.VALUE_NUMBER_INT`)"),
                new TestData("string", "{\"numbers\": \"1\"}", "An error occurred: JSON parse error: Cannot deserialize value of type `java.util.ArrayList<java.lang.Integer>` from String value (token `JsonToken.VALUE_STRING`)"),
                new TestData("string []", "{\"numbers\": [\"o\"]}", "An error occurred: JSON parse error: Cannot deserialize value of type `java.lang.Integer` from String \"o\": not a valid `java.lang.Integer` value"),
                new TestData("out of range of int", "{\"numbers\": [321321321321321321.32131]}", "An error occurred: JSON parse error: Numeric value (321321321321321321.32131) out of range of int (-2147483648 - 2147483647)")
        );
    }

    @ParameterizedTest(name = "Check {0}")
    @MethodSource("testData")
    public void testProcessNumbers(TestData testData) {
        ValidatableResponse response = numbersClient.calculateNumbersBadRequest(testData.jsonRequest);

        String errorMessage = response.extract().jsonPath().getString("message");

        assertThat(errorMessage).isEqualTo(testData.expectedErrorMessage);
    }

    private static class TestData {
        String checkName;
        String jsonRequest;
        String expectedErrorMessage;

        public TestData(String checkName, String jsonRequest, String expectedErrorMessage) {
            this.checkName = checkName;
            this.jsonRequest = jsonRequest;
            this.expectedErrorMessage = expectedErrorMessage;
        }

        public String toString() {
            return checkName;
        }
    }
}
