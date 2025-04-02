package com.example.numbers.tests;

import com.example.numbers.model.request.NumbersRequest;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.EMPTY_LIST;
import static org.assertj.core.api.Assertions.assertThat;

public class NumbersPositiveTest extends BaseTest {

    private static Stream<TestData> testData() {
        return Stream.of(
                new TestData("max value", List.of(Integer.MAX_VALUE), List.of(Integer.MIN_VALUE)),
                new TestData("min value", List.of(Integer.MIN_VALUE), List.of(Integer.MIN_VALUE + 1)),
                new TestData("null in list", Arrays.asList(null, 1), Arrays.asList(null, 2)),
                new TestData("negative numbers", List.of(-1, -2, -3, -4, -5, -6, -7, -8, -9, -10), List.of(0, -1, -2, -3, -4, -5, -6, -7, -8, -9)),
                new TestData("positive numbers", List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), List.of(2, 3, 4, 5, 6, 7, 8, 9, 10)),
                new TestData("zero", List.of(0), List.of(1)),
                new TestData("repeated numbers", List.of(21, 21, 21, 21, 21, 21, 21), List.of(22, 22, 22, 22, 22, 22, 22)),
                new TestData("empty list", EMPTY_LIST, EMPTY_LIST),
                new TestData("mixed numbers", List.of(-1, 0, 1, 2), List.of(0, 1, 2, 3)),
                new TestData("mixed numbers", List.of(-1, 0, 1, 2), List.of(0, 1, 2, 3)),
                new TestData("large list", List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20), List.of(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21))
        );
    }

    @ParameterizedTest(name = "Check {0}")
    @MethodSource("testData")
    public void testProcessNumbers(TestData testData) {
        NumbersRequest request = new NumbersRequest(testData.numbers);
        ValidatableResponse response = numbersClient.calculateNumbersOk(request);
        List<Integer> numbersList = response.extract().jsonPath().getList("numbers", Integer.class);

        assertThat(numbersList).containsExactlyElementsOf(testData.expectedValues);
    }

    private static class TestData {
        String checkName;
        List<Integer> numbers;
        List<Integer> expectedValues;

        public TestData(String checkName, List<Integer> numbers, List<Integer> expectedValues) {
            this.checkName = checkName;
            this.numbers = numbers;
            this.expectedValues = expectedValues;
        }

        public String toString() {
            return checkName;
        }
    }
}
