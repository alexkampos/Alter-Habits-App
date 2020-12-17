/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.utils;

import com.webapp.groupproject.models.CreditDebitCard;
import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.RegisterUserDto;
import com.webapp.groupproject.models.UserContactInfo;
import com.webapp.groupproject.models.UserPersonalInfo;

/**
 *
 * @author alexk
 */
public class PersistenceUtils {

    public static MyUser fillMyUserProperties(RegisterUserDto registerUserDto) {

        MyUser newMyUser = new MyUser();
        newMyUser.setUserPassword(registerUserDto.getPassword());
        newMyUser.setUsername(registerUserDto.getUsername());
        return newMyUser;

    }

    public static UserContactInfo fillUserContactInfoProperties(RegisterUserDto registerUserDto, MyUser myUserInserted) {

        UserContactInfo newUserContactInfo = new UserContactInfo();
        newUserContactInfo.setEmail(registerUserDto.getEmail());
        newUserContactInfo.setMobileNumber(registerUserDto.getMobileNumber());
        newUserContactInfo.setPhoneNumber(registerUserDto.getPhoneNumber());
        newUserContactInfo.setUserId(myUserInserted);
        return newUserContactInfo;

    }

    public static UserPersonalInfo fillUserPersonalInfoProperties(RegisterUserDto registerUserDto, MyUser myUserInserted) {

        UserPersonalInfo newUserPersonalInfo = new UserPersonalInfo();
        newUserPersonalInfo.setFirstName(registerUserDto.getName());
        newUserPersonalInfo.setDateOfBirth(HelperMethods.parseStringToDate(registerUserDto.getDateOfBirth()));
        newUserPersonalInfo.setLastName(registerUserDto.getSurname());
        newUserPersonalInfo.setGender(registerUserDto.getGender());
        newUserPersonalInfo.setUserId(myUserInserted);
        return newUserPersonalInfo;

    }

    public static CreditDebitCard fillCreditDebitCardInfo(RegisterUserDto registerUserDto) {

        CreditDebitCard newCreditDebitCard = new CreditDebitCard();
        newCreditDebitCard.setCreditDebitCardNumber(registerUserDto.getCreditDebitCardNumber());
        newCreditDebitCard.setCreditDebitCardName(registerUserDto.getCreditDebitCardName());
        newCreditDebitCard.setCreditDebitCardExpirationMonth(Integer.parseInt(registerUserDto.getCreditDebitCardExpMonth()));
        newCreditDebitCard.setCreditDebitCardExpirationYear(Integer.parseInt(registerUserDto.getCreditDebitCardExpYear()));
        return newCreditDebitCard;

    }
}
