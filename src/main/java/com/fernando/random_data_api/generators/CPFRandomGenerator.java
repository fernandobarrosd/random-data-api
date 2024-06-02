package com.fernando.random_data_api.generators;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.random_data_api.utils.RandomUtils;

@Service("cpfRandomGenerator")
public class CPFRandomGenerator implements RandomGenerator<Boolean, String> {
    @Autowired
    private Random random;

    private StringBuilder randomCPFBuilder;

    private Character[] numbers = new Character[11];

    private static final Character[] NUMBERS = {
        '0', '1', '2', '3', '4','5', '6', '7', '8', '9'
    };

    @Override
    public String generateRandom(Boolean hasEspecialCharacters) {
        for (int i = 0; i < numbers.length; i ++) {
            numbers[i] = randomNumber();
        }
        
        if (hasEspecialCharacters) {
            randomCPFBuilder = new StringBuilder();
            appendNumbersAndPointToCPFStringBuilder(0, 3, false);
            appendNumbersAndPointToCPFStringBuilder(3, 6, false);
            appendNumbersAndPointToCPFStringBuilder(6, 9, true);
            
            randomCPFBuilder.append("-");
            randomCPFBuilder.append(numbers[9]);
            randomCPFBuilder.append(numbers[10]);
        }
        else {
            randomCPFBuilder = new StringBuilder();
            for (int i = 0; i < numbers.length; i ++) {
                var number = numbers[i];
                randomCPFBuilder.append(number);
            }
        }
        return randomCPFBuilder.toString();
        
    }

    private void appendNumbersAndPointToCPFStringBuilder(Integer initialValue, Integer numbersCount, Boolean isLast) {
        for (int i = initialValue; i < numbersCount; i ++) {
            randomCPFBuilder.append(numbers[i]);
        }

        if (!isLast) {
            randomCPFBuilder.append(".");
        }
    }

    

    private Character randomNumber() {
        return RandomUtils.randomValue(random, NUMBERS);
    }

    

    

}
