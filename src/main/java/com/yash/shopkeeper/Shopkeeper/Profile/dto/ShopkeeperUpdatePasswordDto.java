package com.yash.shopkeeper.Shopkeeper.Profile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopkeeperUpdatePasswordDto {

    private String emailId;
    private String updatePassword;
    private String updateConfirmPassword;

}
