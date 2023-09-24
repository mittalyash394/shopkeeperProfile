package com.yash.shopkeeper.Shopkeeper.Profile.repo;

import com.yash.shopkeeper.Shopkeeper.Profile.entity.ShopkeeperProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ShopkeeperRepo extends MongoRepository<ShopkeeperProfile, String> {

    @Query("{'emailId' : ?0}")
    ShopkeeperProfile findByEmailId(String emailId);

    @Query(value="{'_id' : ?0}", delete = true)
    ShopkeeperProfile deleteByUserId(String userId);

    @Query("{'emailId' : ?0 , 'password' : ?1}")
    ShopkeeperProfile findByEmailAndPassword(String emailId, String password);
}
