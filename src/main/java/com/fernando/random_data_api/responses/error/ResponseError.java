package com.fernando.random_data_api.responses.error;

import org.springframework.http.HttpStatus;

import jakarta.servlet.http.HttpServletRequest;

public class ResponseError {
    private String message, path;
    private Integer statusCode;

    public ResponseError() {
    }

    public ResponseError(String message, String path, Integer statusCode) {
        this.message = message;
        this.path = path;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public static ResponseError withBadRequest(String message, HttpServletRequest request) {
        String path = request.getRequestURI();
        Integer statusCode = HttpStatus.BAD_REQUEST.value();
        return new ResponseError(message, path, statusCode);
    }

}