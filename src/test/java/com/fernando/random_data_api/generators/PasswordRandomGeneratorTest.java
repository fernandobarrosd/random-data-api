package com.fernando.random_data_api.generators;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordRandomGeneratorTest {
    @Autowired
    @Qualifier("passwordRandomGenerator")
    private RandomGenerator<Integer, String> passwordRandomGenerator;

    
    @Test
    @DisplayName("Should generate random password")
    public void shouldGenerateRandomPassword() {
        var passwordSize = 10;
        String randomPassword = passwordRandomGenerator.generateRandom(passwordSize);
        
        assertEquals(passwordSize, randomPassword.length());

    }
}