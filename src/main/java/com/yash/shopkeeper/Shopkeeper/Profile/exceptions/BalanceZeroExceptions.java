package com.yash.shopkeeper.Shopkeeper.Profile.exceptions;

public class BalanceZeroExceptions extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BalanceZeroExceptions(String message){
        super(message);
    }

}
