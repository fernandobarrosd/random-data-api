package com.fernando.random_data_api.responses;

import java.util.List;

public record RandomTextResponse(
    String text,
    List<String> texts,
    Integer textsSize,
    Integer textSize) {}