/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.models.CreditDebitCard;
import com.webapp.groupproject.models.ImageDto;
//import com.webapp.groupproject.models.Lala;
import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.RegisterUserDto;
import com.webapp.groupproject.models.Role;
import com.webapp.groupproject.models.UserAppointments;
import com.webapp.groupproject.models.UserContactInfo;
import com.webapp.groupproject.models.UserPersonalInfo;
import com.webapp.groupproject.repositories.MyUserRepository;
import com.webapp.groupproject.services.CreditDebitCardServiceInterface;
import com.webapp.groupproject.services.MyUserServiceInterface;
import com.webapp.groupproject.services.RoleServiceInterface;
import com.webapp.groupproject.services.UserAppointmentsServiceInterface;
import com.webapp.groupproject.services.UserContactInfoServiceInterface;
import com.webapp.groupproject.services.UserPersonalInfoServiceInterface;
import com.webapp.groupproject.utils.BookingUtils;
import com.webapp.groupproject.utils.PersistenceUtils;
import com.webapp.groupproject.validators.RegisterUserValidator;
import java.io.File;
import java.io.IOException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author alexk
 */
@RestController
@RequestMapping("/register")
public class RegisterUserRestController {
    
    
    @Autowired
    RegisterUserValidator registerUserValidator;

    @Autowired
    MyUserServiceInterface myUserServiceInterface;

    @Autowired
    UserContactInfoServiceInterface userContactServiseInterface;
    
    @Autowired
    RoleServiceInterface roleServiceInterface;

    @Autowired
    UserPersonalInfoServiceInterface userPersonalServiceInterface;
    
    @Autowired
    CreditDebitCardServiceInterface creditDebitCardServiceInterface;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    MyUserRepository myUserRepository;

    @Autowired
    BookingUtils bookingUtils;
    
    @Autowired
    UserAppointmentsServiceInterface userAppointmentsServiceInterface;
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(registerUserValidator);
    }

    @PostMapping(value = "/submit")
    public String registerUserToDatabase(@Valid @RequestBody RegisterUserDto registerUserDto) {
        
        registerUserDto.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        MyUser myuser = PersistenceUtils.fillMyUserProperties(registerUserDto);
        
        //withdraw role by name from database and add it to user based on his subscription
        Role roleAssigned = roleServiceInterface.findByRoleName("ROLE_"+registerUserDto.getRole());
        myuser.setRoleId(roleAssigned);
        
        myUserServiceInterface.saveMyUser(myuser);

        //take the userId from the database
        MyUser insertedUser = myUserServiceInterface.findByUsername(myuser.getUsername());
         
        //give the appointments to the inserted userr
        UserAppointments userAppointments=new UserAppointments(
              insertedUser,  bookingUtils.showInitialAppointments(insertedUser)
        );
        userAppointmentsServiceInterface.giveTheInitialAppointments(userAppointments);
        
        CreditDebitCard insertedCreditDebitCard;
        
        if(creditDebitCardServiceInterface.checkIfCreditDebitCardNumberExists(registerUserDto.getCreditDebitCardNumber())) {
            insertedCreditDebitCard = creditDebitCardServiceInterface.findByCreditDebitCardNumber(registerUserDto.getCreditDebitCardNumber());
        }else{
         // insert new user's credit/debit card
            CreditDebitCard creditDebitCard = PersistenceUtils.fillCreditDebitCardInfo(registerUserDto);
            creditDebitCardServiceInterface.saveCreditDebitCard(creditDebitCard);
            insertedCreditDebitCard = creditDebitCardServiceInterface.findByCreditDebitCardNumber(creditDebitCard.getCreditDebitCardNumber());
        }
        
        // adding the relationship between user and credit/debit card
        insertedUser.getCreditDebitCardCollection().add(insertedCreditDebitCard);
        myUserServiceInterface.saveMyUser(insertedUser);

        // insert data to user_contact_info_table
        UserContactInfo userContactInfo = PersistenceUtils.fillUserContactInfoProperties(registerUserDto, myuser);
        userContactServiseInterface.saveUserContactInfo(userContactInfo);

        //insert data to user_personal _info table
        UserPersonalInfo userPersonalInfo = PersistenceUtils.fillUserPersonalInfoProperties(registerUserDto, myuser);
        userPersonalServiceInterface.saveUserPersonalInfo(userPersonalInfo);
        
        return "registered";

    }

}
