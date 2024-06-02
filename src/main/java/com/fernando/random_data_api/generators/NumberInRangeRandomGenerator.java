package com.fernando.random_data_api.generators;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.random_data_api.utils.RandomUtils;

@Service("numberInRangeRandomGenerator")
public class NumberInRangeRandomGenerator implements RandomGenerator<NumberInRangeRandomGenerator.NumberRange, Integer>{
    @Autowired
    private Random random;

    @Override
    public Integer generateRandom(NumberRange numberRange) {
        Integer randomNumber = RandomUtils.randomNumber(random, numberRange.fromNumber, numberRange.toNumber);
        return randomNumber;
    }

    static public record NumberRange(Integer fromNumber, Integer toNumber) {}
}