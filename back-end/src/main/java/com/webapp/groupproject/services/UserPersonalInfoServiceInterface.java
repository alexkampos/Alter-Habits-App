/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.UserPersonalInfo;

/**
 *
 * @author vaggelis
 */
public interface UserPersonalInfoServiceInterface {
    
    public void saveUserPersonalInfo(UserPersonalInfo upi);
    
    public UserPersonalInfo findUserPersonalInfoByUserId(MyUser user);
    
}
