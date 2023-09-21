package com.yash.shopkeeper.Shopkeeper.Profile.controller;

import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperLoginDto;
import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperRegisterDto;
import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperUpdatePasswordDto;
import com.yash.shopkeeper.Shopkeeper.Profile.entity.ShopkeeperProfile;
import com.yash.shopkeeper.Shopkeeper.Profile.exceptions.*;
import com.yash.shopkeeper.Shopkeeper.Profile.service.ShopkeeperService;
import com.yash.shopkeeper.Shopkeeper.Profile.utilities.PayloadCheck;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/shopKeeper")
public class ShopkeeperController {

    public static final Logger log = LogManager.getLogger(ShopkeeperController.class);

    @Autowired
    private ShopkeeperService shopkeeperService;

    @Autowired(required = true)
    private PayloadCheck payloadCheck;

    public static String REGISTER_PAYLOAD_WRONG = "THE REGISTER PAYLOAD IS NOT CORRECT FOR THE SHOPKEEPER";

    public static String LOGIN_PAYLOAD_WRONG = "THE LOGIN PAYLOAD IS NOT CORRECT FOR THE SHOPKEEPER";

    public static String WRONG_CREDENTIALS_FOR_THE_USER = "The emailId or password is incorrect for the user";

    public static String ALREADY_PRESENT_SHOPKEEPER = "This shopkeeper is already present in the DB";

    public static String USERID_PAYLOAD_WRONG = "The payload for getShopkeeperById is not correct";

    public static String SHOPKEEPER_NOT_FOUND = "The shopkeeper is not found";

    public static String UPDATE_PASSWORD_PAYLOAD_WRONG = "The update password payload is not correct";

    public static String EMAILID_NOT_FOUND = "The shopkeeper emailId not found.";
    @Value("${spring.application.name}")
    String applicationName;

    @GetMapping("/root")
    public String root() {
        log.info("The application name is " + applicationName);
        return "This is a shopkeeper and the application name " + applicationName;
    }

    @PostMapping(value = "/register", headers = "Accept=application/json")
    public ShopkeeperProfile register(@Valid @RequestBody ShopkeeperRegisterDto shopkeeperRegisterDto) {
        ShopkeeperProfile shopkeeperProfile = null;
        log.info("Checking for the payload of registration of a shopkeeper");
        if (!payloadCheck.isRegisterPayloadValid(shopkeeperRegisterDto)) {
            throw new RegisterPayloadException(REGISTER_PAYLOAD_WRONG);
        }
        try {
            log.info("Registration of a shopkeeper profile");
            shopkeeperProfile = shopkeeperService.register(shopkeeperRegisterDto);
        } catch (AlreadyPresentShopkeeperException alreadyPresentShopkeeperException) {
            log.error(alreadyPresentShopkeeperException.toString());
            throw new AlreadyPresentShopkeeperException(ALREADY_PRESENT_SHOPKEEPER);
        }
        log.info(shopkeeperProfile);
        return shopkeeperProfile;
    }

    @GetMapping(value = "/shopKeeperById/{userId}", headers = "Accept=application/json")
    public ShopkeeperProfile getShopKeeperById(@PathVariable String userId) {
        log.info("Checking for the payload for getShopkeeper by ID API");
        ShopkeeperProfile shopkeeperProfile = null;
        if(!payloadCheck.isUserIdValid(userId)){
            log.info("The userId is not valid for the getShopkeeperById");
            throw new UserIdNullException(USERID_PAYLOAD_WRONG);
        }
        try {
            log.info("Getting the shopKeeper profile by the userId");
            shopkeeperProfile = shopkeeperService.getShopKeeperById(userId);
        }catch (ShopkeeperNotFound shopkeeperNotFound){
            log.info("The shopkeeper is not found for this.");
            throw new ShopkeeperNotFound(SHOPKEEPER_NOT_FOUND);
        }
        log.info("The shopKeeperProfile is here");
        return shopkeeperProfile;
    }

    @GetMapping(value = "/allShopKeepers", headers = "Accept=application/json")
    public List<ShopkeeperProfile> getAllShopKeepers() {
        log.info("Getting all the shopkeepers present in the DB");
        List<ShopkeeperProfile> list = shopkeeperService.getAllShopKeepers();
        if (list.isEmpty()) {
            return list;
        } else {
            log.info("The shopKeepers list is here");
            return list;
        }
    }


    @PutMapping(value = "/updatePassword", headers = "Accept=application/json")
    public boolean updatePassword(@RequestBody ShopkeeperUpdatePasswordDto shopkeeperUpdatePasswordDto) {
        log.info("Checking for the payload for updating the password");
        boolean isUpdated = false;
        if(!payloadCheck.isUpdatePasswordPayloadValid(shopkeeperUpdatePasswordDto)){
            log.info("The update password payload is not valid");
            throw new UpdatePasswordPayloadException(UPDATE_PASSWORD_PAYLOAD_WRONG);
        }
        try {
            log.info("Updating the password");
             isUpdated = shopkeeperService.updatePassword(shopkeeperUpdatePasswordDto);
        }catch (EmailIdNotFoundException e){
            log.error("The emailId not found for the user");
            throw new EmailIdNotFoundException(EMAILID_NOT_FOUND);
        }
        return true;
    }


    @DeleteMapping(value = "/deleteShopkeeperProfileByUserId/{userId}", headers = "Accept=application/json")
    public boolean deleteShopkeeperProfileByUserId(@PathVariable String userId) {
        boolean isDeleted = false;
        log.info("Checking for the payload of deleteShopkeeperByUserId");
        if(!payloadCheck.isDeleteShopkeeperByUserIdValid(userId)){
            log.info("The userId is not valid for the getShopkeeperById");
            throw new UserIdNullException(USERID_PAYLOAD_WRONG);
        }
        try {
            log.info("Deleting the shopkeeper profile by the userId");
            isDeleted = shopkeeperService.deleteShopkeeper(userId);
        }catch (ShopkeeperNotFound shopkeeperNotFound){
            throw new ShopkeeperNotFound("There is no shopkeeper profile by this userId");
        }
        return true;
    }

    @PostMapping(value = "/login", headers = "Accept=application/json")
    public ShopkeeperProfile loginShopkeeper(@RequestBody ShopkeeperLoginDto shopkeeperLoginDto) {
        log.info("Checking for the payload of login API");
        ShopkeeperProfile shopkeeperProfile = null;
        if(!payloadCheck.isLoginPayloadValid(shopkeeperLoginDto)){
            log.info("The login payload is not valid");
            throw new LoginPayloadException(LOGIN_PAYLOAD_WRONG);
        }
        try {
            log.info("The login payload for the shopkeeper is correct");
            shopkeeperProfile = shopkeeperService.loginShopkeeper(shopkeeperLoginDto);
        }catch (ShopkeeperNotFound shopkeeperNotFound){
            log.error("The emailId not found for the user");
            throw new ShopkeeperNotFound(SHOPKEEPER_NOT_FOUND);
        }
        catch (WrongCredentialsForShopkeeper wrongCredentialsForShopkeeper){
            log.info("The emailId or password is incorrect");
            throw new WrongCredentialsForShopkeeper(WRONG_CREDENTIALS_FOR_THE_USER);
        }
        log.info("The login is successful");
        return shopkeeperProfile;
    }

}
