package com.fernando.random_data_api;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import com.fernando.random_data_api.exceptions.EmptyListException;
import com.fernando.random_data_api.exceptions.NullValueException;
import com.fernando.random_data_api.exceptions.OneNumberIsGreatherToOtherNumberException;
import com.fernando.random_data_api.responses.error.ResponseError;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ResponseError> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        StringBuilder messageStringBuilder = new StringBuilder(
            "%s request parameter should be a ".formatted(e.getPropertyName())
        );
        Class<?> requiredTypeClass = e.getRequiredType();
            
        switch (requiredTypeClass.getSimpleName()) {
            case "Integer":
                messageStringBuilder.append("number");
                break;
            case "Boolean":
                messageStringBuilder.append("true or false");
                break;
            default:
                break;
        }
            String message = messageStringBuilder.toString();
            ResponseError responseError = ResponseError.withBadRequest(message, request);
            return ResponseEntity.badRequest().body(responseError);
        }

        @ExceptionHandler(OneNumberIsGreatherToOtherNumberException.class)
        public ResponseEntity<ResponseError> handleOneNumberIsGreatherToOtherNumber(
            OneNumberIsGreatherToOtherNumberException e, 
            HttpServletRequest request) {
            String message = e.getMessage();

            ResponseError responseError = ResponseError.withBadRequest(message, request);
            return ResponseEntity.badRequest().body(responseError);
            
        }
        @ExceptionHandler(NoResourceFoundException.class)
        public ResponseEntity<ResponseError> handleNoResourceFound(NoResourceFoundException exception, HttpServletRequest request) {
            String path = request.getRequestURI();
            String message = "This path is not exists".formatted(path);
            ResponseError responseError = ResponseError.withBadRequest(message, request);
            return ResponseEntity.badRequest().body(responseError);
        }


        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity<ResponseError> handleHttpMessageNotReadable(HttpMessageNotReadableException e, HttpServletRequest request) {
            String message = "The request body is required";
            ResponseError responseError = ResponseError.withBadRequest(message, request);
            return ResponseEntity.badRequest().body(responseError);
        }

        @ExceptionHandler(NullValueException.class)
        public ResponseEntity<ResponseError> handleNullValue(NullValueException exception, HttpServletRequest request) {
            String message = exception.getMessage();

            ResponseError responseError = ResponseError.withBadRequest(message, request);
            return ResponseEntity.badRequest().body(responseError);
        }

        @ExceptionHandler(EmptyListException.class)
        public ResponseEntity<ResponseError> handleEmptyList(EmptyListException exception, HttpServletRequest request) {
            String message = exception.getMessage();

            ResponseError responseError = ResponseError.withBadRequest(message, request);
            return ResponseEntity.badRequest().body(responseError);
        }

        @ExceptionHandler(MissingServletRequestParameterException.class)
        public ResponseEntity<ResponseError> handleMissingServletRequestParameter(
            MissingServletRequestParameterException e, 
            HttpServletRequest request) {
                String parameterName = e.getParameterName();
                String message = "%s is required ".formatted(parameterName);

                ResponseError responseError = ResponseError.withBadRequest(message, request);
                return ResponseEntity.badRequest().body(responseError); 

            }
}