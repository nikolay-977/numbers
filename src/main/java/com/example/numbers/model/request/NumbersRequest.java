package com.example.numbers.model.request;

import java.util.ArrayList;
import java.util.List;

public class NumbersRequest {
    private List<Integer> numbers;

    public NumbersRequest() {
        this.numbers = new ArrayList<>();
    }

    public NumbersRequest(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
