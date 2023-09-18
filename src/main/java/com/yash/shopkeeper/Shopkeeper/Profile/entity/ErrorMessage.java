package com.yash.shopkeeper.Shopkeeper.Profile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    private int statusCode;
    private String timeStamp;
    private String message;
    private String description;


}
