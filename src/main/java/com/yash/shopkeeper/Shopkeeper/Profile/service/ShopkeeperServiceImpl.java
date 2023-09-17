package com.yash.shopkeeper.Shopkeeper.Profile.service;

import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperLoginDto;
import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperRegisterDto;
import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperUpdatePasswordDto;
import com.yash.shopkeeper.Shopkeeper.Profile.entity.ShopkeeperProfile;
import com.yash.shopkeeper.Shopkeeper.Profile.repo.ShopkeeperRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class ShopkeeperServiceImpl implements ShopkeeperService {

    @Autowired
    private ShopkeeperRepo shopkeeperRepo;

    public static final Logger log = LogManager.getLogger(ShopkeeperServiceImpl.class);

    @Override
    public ShopkeeperProfile register(ShopkeeperRegisterDto shopkeeperRegisterDto) {
        ShopkeeperProfile shopkeeperProfile = new ShopkeeperProfile();
        Date date = new Date();
        ShopkeeperProfile shopkeeperProfileFromDB = shopkeeperRepo.findByEmailId(shopkeeperRegisterDto.getEmailId());
        log.info(shopkeeperProfileFromDB);
        if (shopkeeperProfileFromDB != null) {
            log.info("The shopkeeper is already present in the database");
            throw new RuntimeException("This shopkeeper is already present in the DB");
        } else {
            log.info("This shopKeeper is not present in the DB, saving it with all the details " + shopkeeperRegisterDto);
            shopkeeperProfile.setShopKeeperFirstName(shopkeeperRegisterDto.getShopKeeperFirstName());
            shopkeeperProfile.setShopKeeperLastName(shopkeeperRegisterDto.getShopKeeperLastName());
            shopkeeperProfile.setEmailId(shopkeeperRegisterDto.getEmailId());
            shopkeeperProfile.setPassword(shopkeeperRegisterDto.getPassword());
            shopkeeperProfile.setConfirmPassword(shopkeeperRegisterDto.getConfirmPassword());
            shopkeeperProfile.setOccupationType(shopkeeperRegisterDto.getOccupationType());
            shopkeeperProfile.setBalance(shopkeeperRegisterDto.getBalance());
            shopkeeperProfile.setCreatedAt(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date));
            shopkeeperRepo.save(shopkeeperProfile);
            return shopkeeperProfile;
        }
    }

    @Override
    public ShopkeeperProfile getShopKeeperById(String userId) {
        Optional<ShopkeeperProfile> shopkeeperProfileOptional = shopkeeperRepo.findById(userId);
        log.info("Getting the shopKeeper profile by the userId");
        if (shopkeeperProfileOptional.isEmpty()) {
            log.info("There is no shopkeeper profile found for the given userId");
            throw new RuntimeException("There is no shopkeeper profile by this userId");
        } else {
            log.info("The shopkeeper profile is here");
            return shopkeeperProfileOptional.get();
        }
    }

    @Override
    public List<ShopkeeperProfile> getAllShopKeepers() {
        log.info("Getting the list of all the shopKeepers");
        List<ShopkeeperProfile> shopkeeperProfiles = shopkeeperRepo.findAll();
        if(shopkeeperProfiles.isEmpty()){
            log.info("There is no shopKeepers registered with us");
            return shopkeeperProfiles;
        }
        else {
            log.info("The list for all the shopkeeper is here");
            return shopkeeperProfiles;
        }
    }

    @Override
    public boolean updatePassword(ShopkeeperUpdatePasswordDto shopkeeperUpdatePasswordDto) {
        Date date = new Date();
        log.info("Updating the password, checking for emailId");
        ShopkeeperProfile shopkeeperProfileFromDb = shopkeeperRepo.findByEmailId(shopkeeperUpdatePasswordDto.getEmailId());
        if(shopkeeperProfileFromDb == null){
            log.info("The emailId not found");
            return false;
        }
        else {
            String userId = shopkeeperProfileFromDb.getShopKeeperId();
            Optional<ShopkeeperProfile> shopkeeperProfileByUserId = shopkeeperRepo.findById(userId);
            ShopkeeperProfile shopkeeperProfile = new ShopkeeperProfile();
            shopkeeperProfile.setShopKeeperId(userId);
            shopkeeperProfile.setShopKeeperFirstName(shopkeeperProfileFromDb.getShopKeeperFirstName());
            shopkeeperProfile.setShopKeeperLastName(shopkeeperProfileFromDb.getShopKeeperLastName());
            shopkeeperProfile.setEmailId(shopkeeperProfileFromDb.getEmailId());
            shopkeeperProfile.setOccupationType(shopkeeperProfileFromDb.getOccupationType());
            shopkeeperProfile.setBalance(shopkeeperProfileFromDb.getBalance());
            shopkeeperProfile.setCreatedAt(shopkeeperProfileFromDb.getCreatedAt());
            shopkeeperProfile.setPassword(shopkeeperUpdatePasswordDto.getUpdatePassword());
            shopkeeperProfile.setConfirmPassword(shopkeeperUpdatePasswordDto.getUpdateConfirmPassword());
            shopkeeperProfile.setUpdatedAt(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date));
            shopkeeperRepo.save(shopkeeperProfile);
            log.info("Updating the passwords for the shopkeeper");
            return true;
        }
    }

    @Override
    public boolean deleteShopkeeper(String userId) {
        Optional<ShopkeeperProfile> shopkeeperProfileFromDB = shopkeeperRepo.findById(userId);
        if(shopkeeperProfileFromDB.isEmpty()){
            log.info("The userId does not exist.");
            return false;
        }
        else {
            log.info("Deleting the shopkeeper profile by userId");
            ShopkeeperProfile isDeleted = shopkeeperRepo.deleteByUserId(userId);
            log.info("The shopkeeper profile is deleted");
            return true;
        }
    }

    @Override
    public ShopkeeperProfile loginShopkeeper(ShopkeeperLoginDto shopkeeperLoginDto) {
        ShopkeeperProfile shopkeeperProfile = shopkeeperRepo.findByEmailAndPassword(shopkeeperLoginDto.getEmailId(), shopkeeperLoginDto.getPassword());
        if(shopkeeperProfile == null){
            log.error("The emailId and password is not correct for the user");
            return null;
        }
        else {
            log.info("The details are fetched and the user is logged in");
            return shopkeeperProfile;
        }
    }


}
