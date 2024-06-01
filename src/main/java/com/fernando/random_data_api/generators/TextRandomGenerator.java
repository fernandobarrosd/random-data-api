package com.fernando.random_data_api.generators;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service("textRandomGenerator")
public class TextRandomGenerator implements RandomGenerator<List<String>, String> {
    private static final Random RANDOM = new Random();

    @Override
    public String generateRandom(List<String> texts) {
        String text = randomText(texts);
        return text;
    }

    private String randomText(List<String> texts) {
        Integer randomIndex = RANDOM.nextInt(texts.size() - 0) + 0;
        return texts.get(randomIndex);
    }
    
}