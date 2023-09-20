package com.yash.shopkeeper.Shopkeeper.Profile.exceptions;

public class UpdatePasswordPayloadException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UpdatePasswordPayloadException(String message){
        super(message);
    }

}
