package com.yash.shopkeeper.Shopkeeper.Profile.controller;

import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperLoginDto;
import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperRegisterDto;
import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperUpdatePasswordDto;
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
        if(list.isEmpty()){
            return list;
        }
        else {
            log.info("The shopKeepers list is here");
            return list;
        }
    }


    @PutMapping(value = "/updatePassword", headers = "Accept=application/json")
    public boolean updatePassword(@RequestBody ShopkeeperUpdatePasswordDto shopkeeperUpdatePasswordDto){
        log.info("Updating the password");
        boolean isUpdated = shopkeeperService.updatePassword(shopkeeperUpdatePasswordDto);
        if(isUpdated){
            return true;
        }
        else {
            return false;
        }
    }


    @DeleteMapping(value = "/deleteShopkeeperProfileByUserId/{userId}", headers = "Accept=application/json")
    public boolean deleteShopkeeperProfileByUserId(@PathVariable String userId){
        log.info("Deleting the shopkeeper profile by the userId");
        boolean isDeleted = shopkeeperService.deleteShopkeeper(userId);
        if(isDeleted){
            log.info("The user is deleted");
            return true;
        }
        else {
            log.error("The user is not deleted");
            return false;
        }
    }

    @PostMapping(value = "/login", headers = "Accept=application/json")
    public ShopkeeperProfile loginShopkeeper(@RequestBody ShopkeeperLoginDto shopkeeperLoginDto){
        ShopkeeperProfile shopkeeperProfile = shopkeeperService.loginShopkeeper(shopkeeperLoginDto);
        if(shopkeeperProfile == null){
            log.error("Unable to login");
            return null;
        }
        else {
            log.info("The login is successful");
            return shopkeeperProfile;
        }
    }

}
