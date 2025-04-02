package com.example.numbers.tests;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DecimalTest extends BaseTest {

    private static Stream<TestData> testData() {
        return Stream.of(
                new TestData("positive decimal", List.of(0.1), List.of(1.0)),
                new TestData("negative decimal", List.of(-1.9), List.of(0.0))
        );
    }

    @ParameterizedTest(name = "Check {0}")
    @MethodSource("testData")
    public void testProcessNumbers(TestData testData) {
        TestRequest request = new TestRequest(testData.numbers);
        ValidatableResponse response = numbersClient.calculateNumbersOk(request);
        List<Double> numbersList = response.extract().jsonPath().getList("numbers", Double.class);

        assertThat(numbersList).containsExactlyElementsOf(testData.expectedValues);
    }

    private static class TestData {
        String checkName;
        List<Double> numbers;
        List<Double> expectedValues;

        public TestData(String checkName, List<Double> numbers, List<Double> expectedValues) {
            this.checkName = checkName;
            this.numbers = numbers;
            this.expectedValues = expectedValues;
        }

        public String toString() {
            return checkName;
        }
    }

    private static class TestRequest {
        private List<Double> numbers;

        public TestRequest(List<Double> numbers) {
            this.numbers = numbers;
        }

        public List<Double> getNumbers() {
            return numbers;
        }
    }
}
