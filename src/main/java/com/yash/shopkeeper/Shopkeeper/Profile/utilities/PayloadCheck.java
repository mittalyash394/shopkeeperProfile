package com.yash.shopkeeper.Shopkeeper.Profile.utilities;

import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperLoginDto;
import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperRegisterDto;
import com.yash.shopkeeper.Shopkeeper.Profile.dto.ShopkeeperUpdatePasswordDto;
import com.yash.shopkeeper.Shopkeeper.Profile.exceptions.*;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PayloadCheck {

    public boolean isRegisterPayloadValid(ShopkeeperRegisterDto shopkeeperRegisterDto) {

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        String passwordRegex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        String nameRegex= "[A-Z][a-z]*";

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
        if (shopkeeperRegisterDto.getBalance() <= 0) {
            throw new BalanceZeroExceptions("The balance cannot be equal or less than 0");
        }

        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailPatternMatcher = emailPattern.matcher(shopkeeperRegisterDto.getEmailId());
        if(!emailPatternMatcher.matches()){
            throw new EmailIdFormatException("EmailId is not in proper format");
        }

        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(shopkeeperRegisterDto.getPassword());
        if(!passwordMatcher.matches()){
            throw new PasswordFormatException("The password is not in proper format");
        }

        Pattern confirmPasswordPattern = Pattern.compile(passwordRegex);
        Matcher confirmPasswordMatcher = confirmPasswordPattern.matcher(shopkeeperRegisterDto.getConfirmPassword());
        if(!confirmPasswordMatcher.matches()){
                throw new ConfirmPasswordFormatException("The confirmPassword is not in correct format");
        }

        if(!shopkeeperRegisterDto.getPassword().equals(shopkeeperRegisterDto.getConfirmPassword())){
            throw new PasswordAndConfirmPasswordException("Password & ConfirmPassword don't match");
        }

        Pattern namePattern = Pattern.compile(nameRegex);
        Matcher firstNameMatcher = namePattern.matcher(shopkeeperRegisterDto.getShopKeeperFirstName());
        if(!firstNameMatcher.matches()){
            throw new FirstNameFormatException("The first name is not in correct format");
        }

        Matcher lastNameMatcher = namePattern.matcher(shopkeeperRegisterDto.getShopKeeperLastName());
        if(!lastNameMatcher.matches()){
            throw new LastNameFormatException("The last name is not in correct format");
        }

        return true;
    }

    public boolean isLoginPayloadValid(ShopkeeperLoginDto shopkeeperLoginDto) {

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        String passwordRegex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        if(shopkeeperLoginDto.getEmailId() == null || shopkeeperLoginDto.getEmailId().isEmpty()){
            throw new EmailIdNullExceptions("The emailId cannot be null or empty");
        }
        if (shopkeeperLoginDto.getPassword() == null || shopkeeperLoginDto.getPassword().isEmpty()){
            throw new PasswordNullExceptions("The password cannot be null or empty");
        }
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailPatternMatcher = emailPattern.matcher(shopkeeperLoginDto.getEmailId());
        if(!emailPatternMatcher.matches()){
            throw new EmailIdFormatException("EmailId is not in proper format");
        }

        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(shopkeeperLoginDto.getPassword());
        if(!passwordMatcher.matches()){
            throw new PasswordFormatException("The password is not in proper format");
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

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        String passwordRegex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        if (shopkeeperUpdatePasswordDto.getEmailId() == null || shopkeeperUpdatePasswordDto.getEmailId().isEmpty()) {
            throw new EmailIdNullExceptions("The emailId cannot be null or empty");
        }
        if (shopkeeperUpdatePasswordDto.getUpdatePassword() == null || shopkeeperUpdatePasswordDto.getUpdatePassword().isEmpty()) {
            throw new UpdatePasswordNullExceptions("The update password cannot be null or empty");
        }
        if (shopkeeperUpdatePasswordDto.getUpdateConfirmPassword() == null || shopkeeperUpdatePasswordDto.getUpdateConfirmPassword().isEmpty()) {
            throw new UpdateConfirmPasswordNullExceptions("The update confirm password cannot be null or empty");
        }

        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailPatternMatcher = emailPattern.matcher(shopkeeperUpdatePasswordDto.getEmailId());
        if(!emailPatternMatcher.matches()){
            throw new EmailIdFormatException("EmailId is not in proper format");
        }

        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(shopkeeperUpdatePasswordDto.getUpdatePassword());
        if(!passwordMatcher.matches()){
            throw new PasswordFormatException("The password is not in proper format");
        }
        Pattern confirmPasswordPattern = Pattern.compile(passwordRegex);
        Matcher confirmPasswordMatcher = confirmPasswordPattern.matcher(shopkeeperUpdatePasswordDto.getUpdateConfirmPassword());
        if(!confirmPasswordMatcher.matches()){
            throw new ConfirmPasswordFormatException("The confirmPassword is not in correct format");
        }
        if(!shopkeeperUpdatePasswordDto.getUpdatePassword().equals(shopkeeperUpdatePasswordDto.getUpdateConfirmPassword())){
            throw new PasswordAndConfirmPasswordException("Password & ConfirmPassword don't match");
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
