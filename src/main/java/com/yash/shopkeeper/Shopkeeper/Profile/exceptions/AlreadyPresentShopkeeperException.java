package com.yash.shopkeeper.Shopkeeper.Profile.exceptions;

public class AlreadyPresentShopkeeperException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public AlreadyPresentShopkeeperException(String message){
        super(message);
    }
}
