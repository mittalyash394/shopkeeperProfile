package com.yash.shopkeeper.Shopkeeper.Profile.exceptions;

public class WrongCredentialsForShopkeeper extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public WrongCredentialsForShopkeeper(String message){
        super(message);
    }

}
