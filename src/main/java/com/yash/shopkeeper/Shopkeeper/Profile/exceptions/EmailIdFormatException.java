package com.yash.shopkeeper.Shopkeeper.Profile.exceptions;

public class EmailIdFormatException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EmailIdFormatException(String message){
        super(message);
    }

}
