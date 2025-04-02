package com.example.numbers.controller;

import com.example.numbers.model.request.NumbersRequest;
import com.example.numbers.model.response.NumbersResponse;
import com.example.numbers.service.NumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NumbersController {

    @Autowired
    protected NumbersService numbersService;

    @PostMapping("/numbers")
    public ResponseEntity<NumbersResponse> processNumbers(@RequestBody NumbersRequest request) {
        List<Integer> incrementedNumbers = numbersService.incrementNumbers(request.getNumbers());
        return ResponseEntity.ok(new NumbersResponse(incrementedNumbers));
    }
}
