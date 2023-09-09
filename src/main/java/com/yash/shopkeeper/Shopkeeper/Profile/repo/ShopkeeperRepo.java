package com.yash.shopkeeper.Shopkeeper.Profile.repo;

import com.yash.shopkeeper.Shopkeeper.Profile.entity.ShopkeeperProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

public interface ShopkeeperRepo extends MongoRepository<ShopkeeperProfile, String> {

    @Query("{'emailId' : ?0}")
    ShopkeeperProfile findByEmailId(String emailId);
}
