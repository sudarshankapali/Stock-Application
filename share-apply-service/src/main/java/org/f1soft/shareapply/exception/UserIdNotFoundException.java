package org.f1soft.shareapply.exception;

public class UserIdNotFoundException extends RuntimeException{

    public UserIdNotFoundException(){}
    public UserIdNotFoundException(String message){
        super(message);
    };
}
