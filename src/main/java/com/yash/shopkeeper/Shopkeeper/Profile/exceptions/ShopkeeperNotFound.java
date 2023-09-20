package com.yash.shopkeeper.Shopkeeper.Profile.exceptions;

public class ShopkeeperNotFound extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ShopkeeperNotFound(String message){
        super(message);
    }

}
