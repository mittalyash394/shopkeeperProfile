package com.yash.shopkeeper.Shopkeeper.Profile.exceptions;

public class ConfirmPasswordFormatException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ConfirmPasswordFormatException(String message){
        super(message);
    }

}
