package com.yash.shopkeeper.Shopkeeper.Profile.exceptions;

public class LoginPayloadException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public LoginPayloadException(String message){
        super(message);
    }

}
