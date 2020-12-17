/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.validators;

import com.webapp.groupproject.models.RegisterUserDto;
import com.webapp.groupproject.services.CreditDebitCardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author alexk
 */
@Component
public class RegisterUserValidator implements Validator {

    @Autowired
    CreditDebitCardServiceInterface creditDebitCardServiceInterface;

    @Override
    public boolean supports(Class<?> type) {

        return RegisterUserDto.class.equals(type);

    }

    @Override
    public void validate(Object o, Errors errors) {

        RegisterUserDto registerUserDto = (RegisterUserDto) o;
        ValidatorMethods validatorMethods = new ValidatorMethods();
        validatorMethods.checkIfGenderIsChosen(registerUserDto, errors);
        validatorMethods.checkIfUsernameUnique(registerUserDto, errors);
        validatorMethods.checkIfPasswordsMatch(registerUserDto, errors);
        validatorMethods.checkIfEmailUnique(registerUserDto, errors);
        validatorMethods.checkIfMobileNumberUnique(registerUserDto, errors);
        if (creditDebitCardServiceInterface.checkIfCreditDebitCardNumberExists(registerUserDto.getCreditDebitCardNumber())) {
            validatorMethods.checkIfCreditDebitCardCredentialsValid(registerUserDto, errors);
        }
    }

}
