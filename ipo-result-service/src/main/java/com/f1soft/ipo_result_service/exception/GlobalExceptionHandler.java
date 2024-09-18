package com.f1soft.ipo_result_service.exception;

import com.f1soft.ipo_result_service.entity.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TableEmptyException.class)
    public ResponseEntity<ResponseMessage> handleTableEmptyException(TableEmptyException ex){
        ResponseMessage responseMessage= ResponseMessage.builder().message(ex.getMessage()).allottedQuantity(0).build();

        return new ResponseEntity<>(responseMessage,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IssueIdNotFoundException.class)
    public ResponseEntity<ResponseMessage> handleIssueIdNotException(IssueIdNotFoundException ex){

        ResponseMessage responseMessage= ResponseMessage.builder().message(ex.getMessage()).allottedQuantity(0).build();
        return new ResponseEntity<>(responseMessage,HttpStatus.NOT_FOUND);
    }
}
