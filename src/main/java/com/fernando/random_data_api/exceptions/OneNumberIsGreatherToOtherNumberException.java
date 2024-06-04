package com.fernando.random_data_api.exceptions;

public class OneNumberIsGreatherToOtherNumberException extends RuntimeException{
    public OneNumberIsGreatherToOtherNumberException(String message) {
        super(message);
    }
}