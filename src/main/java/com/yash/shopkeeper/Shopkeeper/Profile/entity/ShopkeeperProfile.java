package com.yash.shopkeeper.Shopkeeper.Profile.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ShopkeeperProfile {

    @Id
    private String shopKeeperId;
    private String shopKeeperFirstName;
    private String shopKeeperLastName;
    private String emailId;
    private String password;
    private String confirmPassword;
    private String occupationType;
    private String balance;
    private String createdAt;
    private String updatedAt;

}
