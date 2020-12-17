/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.UserContactInfo;

/**
 *
 * @author vaggelis
 */
public interface UserContactInfoServiceInterface {
    
    public boolean checkIfEmailExists(String email);
    
    public void saveUserContactInfo(UserContactInfo userContactInfo);
    
    public UserContactInfo findUserContactInfoByUserId(MyUser user);
    
    public boolean checkIfMobileNumberExists(String mobileNumber);
    
    public UserContactInfo findUserContactInfoByEmail(String email);
    
    public UserContactInfo findUserContactInfoByMobileNumber(String mobileNumber);
    
}
