package com.yash.shopkeeper.Shopkeeper.Profile.controller;

import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperRegisterDto;
import com.yash.shopkeeper.Shopkeeper.Profile.entity.ShopkeeperProfile;
import com.yash.shopkeeper.Shopkeeper.Profile.service.ShopkeeperService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopKeeper")
public class ShopkeeperController {

    public static final Logger log = LogManager.getLogger(ShopkeeperController.class);

    @Autowired
    private ShopkeeperService shopkeeperService;
    @Value("${spring.application.name}")
    String applicationName;

    @GetMapping("/root")
    public String root(){
        log.info("The application name is " + applicationName);
        return "This is a shopkeeper and the application name " + applicationName;
    }

    @PostMapping(value = "/register", headers = "Accept=application/json")
    public ShopkeeperProfile register(@RequestBody ShopkeeperRegisterDto shopkeeperRegisterDto){
        log.info("Registration of a shopkeeper profile");
        ShopkeeperProfile shopkeeperProfile = shopkeeperService.register(shopkeeperRegisterDto);
        return shopkeeperProfile;
    }

    @GetMapping(value = "/shopKeeperById/{userId}", headers = "Accept=application/json")
    public ShopkeeperProfile getShopKeeperById(@PathVariable String userId){
        log.info("Getting the shopKeeper profile by the userId");
        ShopkeeperProfile shopkeeperProfile = shopkeeperService.getShopKeeperById(userId);
        log.info("The shopKeeperProfile is here");
        return shopkeeperProfile;
    }

    @GetMapping(value = "/allShopKeepers", headers = "Accept=application/json")
    public List<ShopkeeperProfile> getAllShopKeepers(){
        log.info("Getting all the shopkeepers present in the DB");
        List<ShopkeeperProfile> list = shopkeeperService.getAllShopKeepers();
        log.info("The shopKeepers list is here");
        return list;
    }

}
