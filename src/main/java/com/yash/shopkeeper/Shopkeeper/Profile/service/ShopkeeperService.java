package com.yash.shopkeeper.Shopkeeper.Profile.service;

import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperRegisterDto;
import com.yash.shopkeeper.Shopkeeper.Profile.entity.ShopkeeperProfile;

import java.util.List;

public interface ShopkeeperService {
    ShopkeeperProfile register(ShopkeeperRegisterDto shopkeeperRegisterDto);

    ShopkeeperProfile getShopKeeperById(String userId);

    List<ShopkeeperProfile> getAllShopKeepers();
}
