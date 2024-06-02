package com.fernando.random_data_api.generators;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import static com.fernando.random_data_api.generators.NumberInRangeRandomGenerator.NumberRange;

@SpringBootTest
public class NumberInRangeRandomGeneratorTest {
    @Autowired
    @Qualifier("numberInRangeRandomGenerator")
    private RandomGenerator<NumberRange, Integer> numberRangeRandomGenerator;


    @Test
    @DisplayName("Should test generate random number in range")
    public void shouldTestGenerateRandomNumberInRange() {
        NumberRange numberRange = new NumberRange(0, 10);
        List<Integer> numbersRange = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10); 
        Integer randomNumber = numberRangeRandomGenerator.generateRandom(numberRange);

        assertTrue(numbersRange.contains(randomNumber));
    }
}