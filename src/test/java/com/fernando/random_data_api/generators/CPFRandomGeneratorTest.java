package com.fernando.random_data_api.generators;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CPFRandomGeneratorTest {
    @Autowired
    @Qualifier("cpfRandomGenerator")
    private RandomGenerator<Boolean, String> cpfRandomGenerator;

    @Test
    @DisplayName("Should generate random CPF with special characters")
    public void shouldGenerateRandomCPFWithSpecialCharacters() {
        var cpfWithspecialCharactersLength = 14;

        String randomCPF = cpfRandomGenerator.generateRandom(true);
        assertEquals(cpfWithspecialCharactersLength, randomCPF.length());
    }

    @Test
    @DisplayName("Should generate random CPF with not special characters")
    public void shouldGenerateRandomCPFWithNotSpecialCharacters() {
        var cpfWithNotspecialCharactersLength = 11;

        String randomCPF = cpfRandomGenerator.generateRandom(false);
        assertEquals(cpfWithNotspecialCharactersLength, randomCPF.length());
    }
}