package com.yash.shopkeeper.Shopkeeper.Profile.exceptions;

public class RegisterPayloadException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RegisterPayloadException(String message){
        super(message);
    }
}
