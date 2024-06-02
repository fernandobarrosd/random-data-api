package com.fernando.random_data_api.responses;

public record RandomNumberInRangeResponse(
    Integer fromNumber,
    Integer toNumber,
    Integer randomNumber) {}