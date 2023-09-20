package com.yash.shopkeeper.Shopkeeper.Profile.exceptions;

public class UserIdNullException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UserIdNullException(String message){
        super(message);
    }

}
