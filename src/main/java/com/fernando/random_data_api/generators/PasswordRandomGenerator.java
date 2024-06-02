package com.fernando.random_data_api.generators;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fernando.random_data_api.utils.RandomUtils;


@Service
public class PasswordRandomGenerator implements RandomGenerator<Integer, String> {
    private static final Character[] characters = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
        'K','L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
        'U','V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
        'e','f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
        'o','p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
        'y','z', '0', '1', '2', '3', '4', '5', '6', '7', 
        '8', '9', '@', '#', '-', '_', '+', '&', '*', '$', 
        '!'
    };

    @Autowired
    private Random random;

    @Override
    public String generateRandom(Integer passwordSize) {
        String randomPassword = "";
        for (int i = 0; i < passwordSize; i ++) {
            Character character = RandomUtils.randomValue(random, characters);
            randomPassword += character;   
        }
        return randomPassword;
    }
}