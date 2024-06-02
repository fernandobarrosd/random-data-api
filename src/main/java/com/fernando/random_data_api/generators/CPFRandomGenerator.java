package com.fernando.random_data_api.generators;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.random_data_api.utils.RandomUtils;

@Service("cpfRandomGenerator")
public class CPFRandomGenerator implements RandomGenerator<Boolean, String> {
    @Autowired
    private Random random;
    private static final Character[] NUMBERS = {
        '0', '1', '2', '3', '4','5', '6', '7', '8', '9'
    };

    @Override
    public String generateRandom(Boolean hasEspecialCharacters) {
        StringBuilder randomCPFBuilder = new StringBuilder();

        Character[] numbers = new Character[11];

        for (int i = 0; i < numbers.length; i ++) {
            numbers[i] = randomNumber();
        }
        
        if (hasEspecialCharacters) {
            randomCPFBuilder.append(numbers[0]);
            randomCPFBuilder.append(numbers[1]);
            randomCPFBuilder.append(numbers[2]);
            randomCPFBuilder.append(".");
            randomCPFBuilder.append(numbers[3]);
            randomCPFBuilder.append(numbers[4]);
            randomCPFBuilder.append(numbers[5]);
            randomCPFBuilder.append(".");
            randomCPFBuilder.append(numbers[6]);
            randomCPFBuilder.append(numbers[7]);
            randomCPFBuilder.append(numbers[8]);
            randomCPFBuilder.append("-");
            randomCPFBuilder.append(numbers[9]);
            randomCPFBuilder.append(numbers[10]);
        }
        else {
            for (int i = 0; i < numbers.length; i ++) {
                var number = numbers[i];
                randomCPFBuilder.append(number);
            }
        }
        return randomCPFBuilder.toString();
        
    }

    private Character randomNumber() {
        return RandomUtils.randomValue(random, NUMBERS);
    }

}
