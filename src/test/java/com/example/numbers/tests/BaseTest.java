package com.example.numbers.tests;

import com.example.numbers.client.api.NumbersClient;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected NumbersClient numbersClient;

    @BeforeEach
    public void setUp() {
        numbersClient = new NumbersClient();
    }
}
