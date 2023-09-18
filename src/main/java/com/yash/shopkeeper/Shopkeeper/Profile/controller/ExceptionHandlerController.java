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
                "The payload is not correct"
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

}
