package com.yash.shopkeeper.Shopkeeper.Profile.controller;

import com.yash.shopkeeper.Shopkeeper.Profile.entity.ErrorMessage;
import com.yash.shopkeeper.Shopkeeper.Profile.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestControllerAdvice
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    Date date = new Date();

    @ExceptionHandler(RegisterPayloadException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage registerPayloadExceptions(RegisterPayloadException registerPayloadException) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                registerPayloadException.getMessage(),
                "The payload is not correct for registration"
        );
    }

    @ExceptionHandler(FirstNameNullExceptions.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage firstNameNullExceptions(FirstNameNullExceptions firstNameNullExceptions) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                firstNameNullExceptions.getMessage(),
                "Null or empty error for firstName value"
        );
    }

    @ExceptionHandler(LastNameNullExceptions.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage lastNameNullExceptions(LastNameNullExceptions lastNameNullExceptions) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                lastNameNullExceptions.getMessage(),
                "Null or empty error for lastName value"
        );
    }

    @ExceptionHandler(EmailIdNullExceptions.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage emailIdNullExceptions(EmailIdNullExceptions emailIdNullExceptions) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                emailIdNullExceptions.getMessage(),
                "Null or empty error for emaildId value"
        );
    }

    @ExceptionHandler(PasswordNullExceptions.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage passwordNullExceptions(PasswordNullExceptions passwordNullExceptions) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                passwordNullExceptions.getMessage(),
                "Null or empty error for password value"
        );
    }

    @ExceptionHandler(ConfirmPasswordNullExceptions.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage confirmPasswordNullExceptions(ConfirmPasswordNullExceptions confirmPasswordNullExceptions) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                confirmPasswordNullExceptions.getMessage(),
                "Null or empty error for confirmPassword value"
        );
    }

    @ExceptionHandler(OccupationTypeNullExceptions.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage occupationNullExceptions(OccupationTypeNullExceptions occupationTypeNullExceptions) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                occupationTypeNullExceptions.getMessage(),
                "Null or empty error for occupation value"
        );
    }

    @ExceptionHandler(BalanceNullExceptions.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage balanceNullExceptions(BalanceNullExceptions balanceNullExceptions) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                balanceNullExceptions.getMessage(),
                "Null or empty error for balance value"
        );
    }

    @ExceptionHandler(AlreadyPresentShopkeeperException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage alreadyPresentShopkeeperExceptions(AlreadyPresentShopkeeperException alreadyPresentShopkeeperException) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                alreadyPresentShopkeeperException.getMessage(),
                "The duplicate values are not allowed."
        );
    }

    @ExceptionHandler(WrongCredentialsForShopkeeper.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage wrongCredentialsForShopkeeper(WrongCredentialsForShopkeeper wrongCredentialsForShopkeeper) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                wrongCredentialsForShopkeeper.getMessage(),
                "Unable to login"
        );
    }

    @ExceptionHandler(LoginPayloadException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage loginPayloadException(LoginPayloadException loginPayloadException) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                loginPayloadException.getMessage(),
                "The Payload is not correct for login"
        );
    }

    @ExceptionHandler(UserIdNullException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage userIdNullException(UserIdNullException userIdNullException) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                userIdNullException.getMessage(),
                "The payload for getting or deleting API by userId is not correct"
        );
    }

    @ExceptionHandler(ShopkeeperNotFound.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage shopKeeperNotFoundException(ShopkeeperNotFound shopkeeperNotFound) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                shopkeeperNotFound.getMessage(),
                "The shopkeeper is not found with this emailId"
        );
    }

    @ExceptionHandler(UpdatePasswordNullExceptions.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage updatePasswordNullExceptions(UpdatePasswordNullExceptions updatePasswordNullExceptions) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                updatePasswordNullExceptions.getMessage(),
                "The updatePassword cannot be null"
        );
    }

    @ExceptionHandler(UpdateConfirmPasswordNullExceptions.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage shopKeeperNotFoundException(UpdateConfirmPasswordNullExceptions updateConfirmPasswordNullExceptions) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                updateConfirmPasswordNullExceptions.getMessage(),
                "The updateConfirmPassword cannot be null"
        );
    }

    @ExceptionHandler(UpdatePasswordPayloadException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage updatePasswordPayloadException(UpdatePasswordPayloadException updatePasswordPayloadException) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                updatePasswordPayloadException.getMessage(),
                "The updatePassword payload is not correct"
        );
    }

    @ExceptionHandler(EmailIdNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage emailIdNotFoundException(EmailIdNotFoundException emailIdNotFoundException) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                emailIdNotFoundException.getMessage(),
                "The emailId not found for the user"
        );
    }
}
