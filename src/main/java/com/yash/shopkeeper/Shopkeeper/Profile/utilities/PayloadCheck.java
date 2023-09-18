package com.yash.shopkeeper.Shopkeeper.Profile.utilities;

import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperRegisterDto;
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
}
