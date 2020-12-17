/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.repositories;

import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.UserContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vaggelis
 */
public interface UserContactInfoRepository extends JpaRepository<UserContactInfo,Integer> {
    
    public UserContactInfo findByEmail(String email);
    
    public UserContactInfo findByUserId(MyUser userId);
    
    public boolean existsByMobileNumber(String mobileNumber);
    
    public UserContactInfo findByMobileNumber(String mobileNumber);
    
}
