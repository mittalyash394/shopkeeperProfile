package com.yash.shopkeeper.Shopkeeper.Profile.exceptions;

public class EmailIdNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EmailIdNotFoundException(String message){
        super(message);
    }

}
