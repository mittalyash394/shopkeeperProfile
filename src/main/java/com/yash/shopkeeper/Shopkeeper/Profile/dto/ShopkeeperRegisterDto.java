package com.yash.shopkeeper.Shopkeeper.Profile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopkeeperRegisterDto {

    private String shopKeeperFirstName;
    private String shopKeeperLastName;
    private String emailId;
    private String password;
    private String confirmPassword;
    private String occupationType;
    private String balance;
}
