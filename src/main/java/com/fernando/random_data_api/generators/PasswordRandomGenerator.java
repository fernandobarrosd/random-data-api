package com.fernando.random_data_api.generators;

import java.util.Random;
import org.springframework.stereotype.Service;

@Service("passwordRandomGenerator")
public class PasswordRandomGenerator implements RandomGenerator<Integer, String> {
    private static final char[] characters = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
        'K','L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
        'U','V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
        'e','f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
        'o','p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
        'y','z', '0', '1', '2', '3', '4', '5', '6', '7', 
        '8', '9', '@', '#', '-', '_', '+', '&', '*', '$', 
        '!'
    };

    private static Random random = new Random();

    @Override
    public String generateRandom(Integer passwordSize) {
        String randomPassword = "";
        for (int i = 0; i < passwordSize; i ++) {
            Integer randomIndex = random.nextInt(characters.length - 0) + 0;
            char character = characters[randomIndex];
            randomPassword += character;   
        }
        return randomPassword;
    }
}