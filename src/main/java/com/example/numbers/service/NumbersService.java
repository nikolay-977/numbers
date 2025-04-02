package com.example.numbers.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NumbersService {

    private static final Logger logger = LoggerFactory.getLogger(NumbersService.class);

    public List<Integer> incrementNumbers(List<Integer> numbers) {
        logger.info("Received numbers for increment: {}", numbers);

        if (numbers == null) {
            logger.warn("Input numbers list is null, returning an empty list.");
            return List.of();
        }

        List<Integer> incrementedNumbers = numbers.stream()
                .map(number -> {
                    if (number == null) {
                        logger.warn("Encountered null value in the list, returning null for this entry.");
                        return null;
                    }
                    int incrementedValue = number + 1;
                    logger.debug("Incremented {} to {}", number, incrementedValue);
                    return incrementedValue;
                })
                .collect(Collectors.toList());

        logger.info("Incremented numbers: {}", incrementedNumbers);
        return incrementedNumbers;
    }
}
