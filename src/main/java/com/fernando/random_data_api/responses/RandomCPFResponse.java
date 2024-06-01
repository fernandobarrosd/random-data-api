package com.fernando.random_data_api.responses;

public record RandomCPFResponse(
    String cpf,
    Boolean hasEspecialCharacters) {}