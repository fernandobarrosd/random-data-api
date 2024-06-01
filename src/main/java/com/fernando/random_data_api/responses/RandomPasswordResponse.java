package com.fernando.random_data_api.responses;

public record RandomPasswordResponse(
    Integer passwordSize,
    String password 
) {}