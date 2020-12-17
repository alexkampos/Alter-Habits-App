/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.validators;

import com.webapp.groupproject.SpringContext;
import com.webapp.groupproject.models.CreditDebitCard;
import com.webapp.groupproject.models.RegisterUserDto;
import com.webapp.groupproject.services.CreditDebitCardServiceInterface;
import com.webapp.groupproject.services.MyUserServiceInterface;
import com.webapp.groupproject.services.UserContactInfoServiceInterface;
import org.springframework.validation.Errors;

/**
 *
 * @author alexk
 */
public class ValidatorMethods {

    public ValidatorMethods() {
    }

    private MyUserServiceInterface getMyUserService() {
        return SpringContext.getBean(MyUserServiceInterface.class);
    }

    private UserContactInfoServiceInterface getUserContactInfoService() {
        return SpringContext.getBean(UserContactInfoServiceInterface.class);
    }
    
    private CreditDebitCardServiceInterface getCardServiceInterface() {
        return SpringContext.getBean(CreditDebitCardServiceInterface.class);
    }

    // check if user chose gender
    void checkIfGenderIsChosen(RegisterUserDto registerUserDto, Errors errors) {
            if (registerUserDto.getGender().equals("NONE")) {
                errors.rejectValue("gender", "gender.not.selected");
            }
    }

    // check if username is unique in database
    void checkIfUsernameUnique(RegisterUserDto registerUserDto, Errors errors) {
            if (getMyUserService().findByUsername(registerUserDto.getUsername()) != null) {
                errors.rejectValue("username", "username.not.unique");
            }
    }

    // check if passwords given match
    void checkIfPasswordsMatch(RegisterUserDto registerUserDto, Errors errors) {
            if (!registerUserDto.getPassword().equals(registerUserDto.getMatchingPassword())) {
                errors.rejectValue("matchingPassword", "passwords.not.matching");
            }
    }

    // check if email already exists in database
    void checkIfEmailUnique(RegisterUserDto registerUserDto, Errors errors) {
            if (getUserContactInfoService().checkIfEmailExists(registerUserDto.getEmail())) {
                errors.rejectValue("email", "email.not.unique");
            }
    }
    
    void checkIfMobileNumberUnique(RegisterUserDto registerUserDto, Errors errors) {
            if (getUserContactInfoService().checkIfMobileNumberExists(registerUserDto.getMobileNumber())) {
                errors.rejectValue("mobileNumber", "mobile.number.not.unique");
            }
    }

    
    void checkIfCreditDebitCardCredentialsValid(RegisterUserDto registerUserDto, Errors errors) {
        CreditDebitCard registeredCard = getCardServiceInterface().findByCreditDebitCardNumber(registerUserDto.getCreditDebitCardNumber());
        if(registeredCard.getCreditDebitCardName().equals(registerUserDto.getCreditDebitCardName())
                && registeredCard.getCreditDebitCardExpirationYear() == Integer.parseInt(registerUserDto.getCreditDebitCardExpYear())
                && registeredCard.getCreditDebitCardExpirationMonth() == Integer.parseInt(registerUserDto.getCreditDebitCardExpMonth())) {
            
        }else{
            errors.rejectValue("creditDebitCardNumber", "card.wrong.credentials");
        }
    }
}
