/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.MyUser;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author alexk
 */
public interface MyUserServiceInterface extends UserDetailsService {

    void saveMyUser(MyUser user);

    MyUser findByUsername(String username);
    
    public MyUser findById(Integer userId);
}
