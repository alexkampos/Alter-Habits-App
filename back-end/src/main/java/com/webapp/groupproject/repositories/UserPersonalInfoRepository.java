/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.repositories;

import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.UserPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vaggelis
 */
public interface UserPersonalInfoRepository extends JpaRepository<UserPersonalInfo,Integer> {
    
    public UserPersonalInfo findByUserId(MyUser userId);
    
}
