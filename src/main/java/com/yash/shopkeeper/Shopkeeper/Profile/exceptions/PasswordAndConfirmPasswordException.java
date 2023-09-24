package com.yash.shopkeeper.Shopkeeper.Profile.exceptions;

public class PasswordAndConfirmPasswordException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PasswordAndConfirmPasswordException(String message){
        super(message);
    }

}
