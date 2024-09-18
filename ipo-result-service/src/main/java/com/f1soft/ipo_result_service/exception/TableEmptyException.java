package com.f1soft.ipo_result_service.exception;

public class TableEmptyException extends RuntimeException{

    public TableEmptyException(String message){
         super(message);
    }
}
