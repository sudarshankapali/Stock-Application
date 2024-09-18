package com.f1soft.user_services.exception;

import com.f1soft.user_services.entity.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseMessage> handleUserNotFoundException(UserNotFoundException ex){
        String message= ex.getMessage();

        ResponseMessage response= ResponseMessage.builder().message(message).data(null).build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
