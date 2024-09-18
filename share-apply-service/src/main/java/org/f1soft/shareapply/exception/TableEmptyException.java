package org.f1soft.shareapply.exception;

public class TableEmptyException extends RuntimeException{

    public TableEmptyException(){}
    public TableEmptyException(String message){
        super(message);
    }
}
