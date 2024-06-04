package com.fernando.random_data_api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fernando.random_data_api.exceptions.EmptyListException;
import com.fernando.random_data_api.exceptions.NullValueException;
import com.fernando.random_data_api.exceptions.OneNumberIsGreatherToOtherNumberException;
import com.fernando.random_data_api.generators.CPFRandomGenerator;
import com.fernando.random_data_api.generators.NumberInRangeRandomGenerator;
import com.fernando.random_data_api.generators.PasswordRandomGenerator;
import com.fernando.random_data_api.generators.TextRandomGenerator;
import com.fernando.random_data_api.generators.NumberInRangeRandomGenerator.NumberRange;
import com.fernando.random_data_api.requests.RandomTextRequestBody;
import com.fernando.random_data_api.responses.RandomCPFResponse;
import com.fernando.random_data_api.responses.RandomNumberInRangeResponse;
import com.fernando.random_data_api.responses.RandomPasswordResponse;
import com.fernando.random_data_api.responses.RandomTextResponse;

@RestController
@RequestMapping("/random")
public class RandomController {
    @Autowired
    private PasswordRandomGenerator passwordRandomGenerator;

    @Autowired
    private TextRandomGenerator textRandomGenerator;


    @Autowired
    private CPFRandomGenerator cpfRandomGenerator;

    @Autowired
    private NumberInRangeRandomGenerator numberRangeRandomGenerator;


    @GetMapping("/password")
    public RandomPasswordResponse getRandomPassword(@RequestParam Integer passwordSize) {
        var randomPassword = passwordRandomGenerator.generateRandom(passwordSize);
        return new RandomPasswordResponse(passwordSize, randomPassword);
    }

    @PostMapping("/text")
    public RandomTextResponse getRandomText(@RequestBody RandomTextRequestBody randomTextRequestBody) {
        List<String> texts = randomTextRequestBody.texts();
        if (texts == null) {
            throw new NullValueException("The texts list is required");
        }
        if (texts.isEmpty()) {
            throw new EmptyListException("The texts list should be not empty");
        }
        String randomText = textRandomGenerator.generateRandom(randomTextRequestBody.texts());
        return new RandomTextResponse(randomText, texts, texts.size(), randomText.length());
    }

    @GetMapping("/cpf")
    public RandomCPFResponse getRandomCPF(
        @RequestParam(name = "hasEspecialCharacters", required = false, defaultValue = "false") Boolean hasEspecialCharacters) {
        String randomCPF = cpfRandomGenerator.generateRandom(hasEspecialCharacters);
        return new RandomCPFResponse(randomCPF, hasEspecialCharacters, randomCPF.length());
    }

    @GetMapping("/numberInRange")
    public RandomNumberInRangeResponse getRandomNumberInRage(
        @RequestParam("fromNumber") Integer fromNumber,
        @RequestParam("toNumber") Integer toNumber) {
            if (fromNumber > toNumber) {
                throw new OneNumberIsGreatherToOtherNumberException("The fromNumber is greather than toNumber");
            }
            NumberRange numberRange = new NumberRange(fromNumber, toNumber);
            Integer randomNumber = numberRangeRandomGenerator.generateRandom(numberRange);
            return new RandomNumberInRangeResponse(fromNumber, toNumber, randomNumber);
        }
}