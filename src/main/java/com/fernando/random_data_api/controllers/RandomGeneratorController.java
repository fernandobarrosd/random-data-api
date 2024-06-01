package com.fernando.random_data_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fernando.random_data_api.generators.RandomGenerator;
import com.fernando.random_data_api.responses.RandomPasswordResponse;

@RestController
@RequestMapping("/random")
public class RandomGeneratorController {
    @Autowired
    @Qualifier("passwordRandomGenerator")
    public RandomGenerator<Integer, String> passwordRandomGenerator;


    @GetMapping("/password")
    public RandomPasswordResponse getRandomPassword(@RequestParam("passwordSize") Integer passwordSize) {
        var randomPassword = passwordRandomGenerator.generateRandom(passwordSize);
        return new RandomPasswordResponse(passwordSize, randomPassword);
    }
}