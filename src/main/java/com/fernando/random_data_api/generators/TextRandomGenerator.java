package com.fernando.random_data_api.generators;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("textRandomGenerator")
public class TextRandomGenerator implements RandomGenerator<List<String>, String> {
    @Autowired
    private Random random;

    @Override
    public String generateRandom(List<String> texts) {
        String text = randomText(texts);
        return text;
    }

    private String randomText(List<String> texts) {
        Integer randomIndex = random.nextInt(texts.size() - 0) + 0;
        return texts.get(randomIndex);
    }
}