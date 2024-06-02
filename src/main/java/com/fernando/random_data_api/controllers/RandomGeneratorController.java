package com.fernando.random_data_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fernando.random_data_api.generators.RandomGenerator;
import com.fernando.random_data_api.generators.NumberInRangeRandomGenerator.NumberRange;
import com.fernando.random_data_api.requests.RandomTextRequestBody;
import com.fernando.random_data_api.responses.RandomCPFResponse;
import com.fernando.random_data_api.responses.RandomNumberInRangeResponse;
import com.fernando.random_data_api.responses.RandomPasswordResponse;
import com.fernando.random_data_api.responses.RandomTextResponse;

@RestController
@RequestMapping("/random")
public class RandomGeneratorController {
    @Autowired
    @Qualifier("passwordRandomGenerator")
    public RandomGenerator<Integer, String> passwordRandomGenerator;

    @Autowired
    @Qualifier("textRandomGenerator")
    public RandomGenerator<List<String>, String> textRandomGenerator;


    @Autowired
    @Qualifier("cpfRandomGenerator")
    public RandomGenerator<Boolean, String> cpfRandomGenerator;

    @Autowired
    @Qualifier("numberInRangeRandomGenerator")
    private RandomGenerator<NumberRange, Integer> numberRangeRandomGenerator;


    @GetMapping("/password")
    public RandomPasswordResponse getRandomPassword(@RequestParam("passwordSize") Integer passwordSize) {
        var randomPassword = passwordRandomGenerator.generateRandom(passwordSize);
        return new RandomPasswordResponse(passwordSize, randomPassword);
    }

    @GetMapping("/text")
    public RandomTextResponse getRandomText(@RequestBody RandomTextRequestBody randomTextRequestBody) {
        List<String> texts = randomTextRequestBody.texts();
        String randomText = textRandomGenerator.generateRandom(randomTextRequestBody.texts());
        return new RandomTextResponse(randomText, texts, texts.size(), randomText.length());
    }

    @GetMapping("/cpf")
    public RandomCPFResponse getRandomCPF(
        @RequestParam(name = "hasEspecialCharacters", required = false, defaultValue = "false") Boolean hasEspecialCharacters) {
        String randomCPF = cpfRandomGenerator.generateRandom(hasEspecialCharacters);
        return new RandomCPFResponse(randomCPF, hasEspecialCharacters, randomCPF.length());
    }

    @GetMapping("/number-in-range")
    public RandomNumberInRangeResponse getRandomNumberInRage(
        @RequestParam("fromNumber") Integer fromNumber,
        @RequestParam("toNumber") Integer toNumber) {

            NumberRange numberRange = new NumberRange(fromNumber, toNumber);
            Integer randomNumber = numberRangeRandomGenerator.generateRandom(numberRange);
            return new RandomNumberInRangeResponse(fromNumber, toNumber, randomNumber);
        }
}