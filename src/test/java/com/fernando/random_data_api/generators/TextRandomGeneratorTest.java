package com.fernando.random_data_api.generators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TextRandomGeneratorTest {
    @Autowired
    @Qualifier("textRandomGenerator")
    private RandomGenerator<List<String>, String> textRandomGenerator; 

    @Test
    @DisplayName("Should generate random text")
    public void shouldGenerateRandomText() {
        String[] texts = {"Olá mundo", "Queijo", "Olá meu comparca"};
        String text = textRandomGenerator.generateRandom(Arrays.asList(texts));

        assertNotNull(text);
    }
}