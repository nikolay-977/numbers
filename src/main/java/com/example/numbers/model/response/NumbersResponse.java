package com.example.numbers.model.response;

import java.util.ArrayList;
import java.util.List;

public class NumbersResponse {
    private List<Integer> numbers;

    public NumbersResponse() {
        this.numbers = new ArrayList<>();
    }

    public NumbersResponse(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}