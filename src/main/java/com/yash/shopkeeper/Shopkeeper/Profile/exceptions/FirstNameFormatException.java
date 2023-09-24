package com.yash.shopkeeper.Shopkeeper.Profile.exceptions;

public class FirstNameFormatException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public FirstNameFormatException(String message){
        super(message);
    }

}
