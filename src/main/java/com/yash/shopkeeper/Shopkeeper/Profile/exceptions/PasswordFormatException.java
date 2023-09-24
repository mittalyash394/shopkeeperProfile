package com.yash.shopkeeper.Shopkeeper.Profile.exceptions;

public class PasswordFormatException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PasswordFormatException(String message){
        super(message);
    }

}
