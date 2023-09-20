package com.yash.shopkeeper.Shopkeeper.Profile.utilities;

import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperLoginDto;
import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperRegisterDto;
import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperUpdatePasswordDto;
import com.yash.shopkeeper.Shopkeeper.Profile.exceptions.*;
import org.springframework.stereotype.Component;

@Component
public class PayloadCheck {

    public boolean isRegisterPayloadValid(ShopkeeperRegisterDto shopkeeperRegisterDto) {
        if (shopkeeperRegisterDto.getShopKeeperFirstName() == null || shopkeeperRegisterDto.getShopKeeperFirstName().isEmpty()) {
            throw new FirstNameNullExceptions("The first name cannot be null or empty");
        }
        if (shopkeeperRegisterDto.getShopKeeperLastName() == null || shopkeeperRegisterDto.getShopKeeperLastName().isEmpty()) {
            throw new LastNameNullExceptions("The last name cannot be null or empty");
        }
        if (shopkeeperRegisterDto.getEmailId() == null || shopkeeperRegisterDto.getEmailId().isEmpty()) {
            throw new EmailIdNullExceptions("The emailId cannot be null or empty");
        }
        if (shopkeeperRegisterDto.getPassword() == null || shopkeeperRegisterDto.getPassword().isEmpty()) {
            throw new PasswordNullExceptions("The password cannot be null or empty");
        }
        if (shopkeeperRegisterDto.getConfirmPassword() == null || shopkeeperRegisterDto.getConfirmPassword().isEmpty()) {
            throw new ConfirmPasswordNullExceptions("The confirm password cannot be null or empty");
        }
        if (shopkeeperRegisterDto.getOccupationType() == null || shopkeeperRegisterDto.getOccupationType().isEmpty()) {
            throw new OccupationTypeNullExceptions("The occupation cannot be null or empty");
        }
        if (shopkeeperRegisterDto.getBalance() == null || shopkeeperRegisterDto.getBalance().isEmpty()) {
            throw new BalanceNullExceptions("The balance cannot be null or empty");
        }
        return true;
    }

    public boolean isLoginPayloadValid(ShopkeeperLoginDto shopkeeperLoginDto) {
        if(shopkeeperLoginDto.getEmailId() == null || shopkeeperLoginDto.getEmailId().isEmpty()){
            throw new EmailIdNullExceptions("The emailId cannot be null or empty");
        }
        if (shopkeeperLoginDto.getPassword() == null || shopkeeperLoginDto.getPassword().isEmpty()){
            throw new PasswordNullExceptions("The password cannot be null or empty");
        }
        return true;
    }

    public boolean isUserIdValid(String userId) {
        if(userId==null || userId.isEmpty()){
            throw new UserIdNullException("The userId cannot be null or empty");
        }
        return true;
    }

    public boolean isUpdatePasswordPayloadValid(ShopkeeperUpdatePasswordDto shopkeeperUpdatePasswordDto) {
        if (shopkeeperUpdatePasswordDto.getEmailId() == null || shopkeeperUpdatePasswordDto.getEmailId().isEmpty()) {
            throw new EmailIdNullExceptions("The emailId cannot be null or empty");
        }
        if (shopkeeperUpdatePasswordDto.getUpdatePassword() == null || shopkeeperUpdatePasswordDto.getUpdatePassword().isEmpty()) {
            throw new UpdatePasswordNullExceptions("The update password cannot be null or empty");
        }
        if (shopkeeperUpdatePasswordDto.getUpdateConfirmPassword() == null || shopkeeperUpdatePasswordDto.getUpdateConfirmPassword().isEmpty()) {
            throw new UpdateConfirmPasswordNullExceptions("The update confirm password cannot be null or empty");
        }
        return true;
    }

    public boolean isDeleteShopkeeperByUserIdValid(String userId) {
        if(userId==null || userId.isEmpty()){
            throw new UserIdNullException("The userId cannot be null or empty");
        }
        return true;
    }
}
