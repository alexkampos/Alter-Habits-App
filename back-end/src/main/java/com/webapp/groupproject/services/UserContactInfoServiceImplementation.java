/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.UserContactInfo;
import com.webapp.groupproject.repositories.UserContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vaggelis
 */
@Service
public class UserContactInfoServiceImplementation implements UserContactInfoServiceInterface{
    
    @Autowired
    UserContactInfoRepository userContactInfoRepository;
    
    @Override
    public boolean checkIfEmailExists(String email){
    UserContactInfo user=userContactInfoRepository.findByEmail(email);
    if (user!=null)
        return true;
    else 
        return false;
    }

    @Override
    public void saveUserContactInfo(UserContactInfo userContactInfo) {
        userContactInfoRepository.save(userContactInfo);
    }
    
    @Override
    public UserContactInfo findUserContactInfoByUserId(MyUser user) {
        return userContactInfoRepository.findByUserId(user);
    }
    
    @Override
    public UserContactInfo findUserContactInfoByEmail(String email) {
        return userContactInfoRepository.findByEmail(email);
    }
    
    @Override
    public boolean checkIfMobileNumberExists(String mobileNumber) {
        if(userContactInfoRepository.existsByMobileNumber(mobileNumber)){
            return true;
        }
        return false;
    }
    
    @Override
    public UserContactInfo findUserContactInfoByMobileNumber(String mobileNumber) {
        return userContactInfoRepository.findByMobileNumber(mobileNumber);
    }
}
