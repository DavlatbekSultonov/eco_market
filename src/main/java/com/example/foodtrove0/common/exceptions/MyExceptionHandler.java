package com.example.foodtrove0.common.exceptions;


import com.example.foodtrove0.common.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(OtpException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse handleEarlyResentException(OtpException e) {
        return new CommonResponse(e.getMessage(), LocalDateTime.now(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(ProductException.class)
    @ResponseStatus(HttpStatus.CREATED)
    public CommonResponse handleEarlyResentException(ProductException e) {
        return new CommonResponse(e.getMessage(), LocalDateTime.now(), HttpStatus.CREATED.value());
    }
    @ExceptionHandler(TimeOut.class)
    @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
    public CommonResponse handleEarlyResentException(TimeOut e) {
        return new CommonResponse(e.getMessage(), LocalDateTime.now(), HttpStatus.GATEWAY_TIMEOUT.value());
    }
    @ExceptionHandler(WrongInputException.class)
    @ResponseStatus(HttpStatus.CREATED)
    public CommonResponse handleEarlyResentException(WrongInputException e) {
        return new CommonResponse(e.getMessage(), LocalDateTime.now(), HttpStatus.CREATED.value());
    }
    @ExceptionHandler(IncorrectEmail.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommonResponse handleEarlyResentException(IncorrectEmail e) {
        return new CommonResponse(e.getMessage(), LocalDateTime.now(), HttpStatus.NOT_FOUND.value());
    }
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommonResponse handleEarlyResentException(DataNotFoundException e) {
        return new CommonResponse(e.getMessage(), LocalDateTime.now(), HttpStatus.NOT_FOUND.value());
    }
    @ExceptionHandler(IncorrectPassword.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommonResponse handleEarlyResentException(IncorrectPassword e) {
        return new CommonResponse(e.getMessage(), LocalDateTime.now(), HttpStatus.NOT_FOUND.value());
    }

}
