/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.Role;
import com.webapp.groupproject.repositories.MyUserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alexk
 */
@Transactional
@Service
public class MyUserServiceImplementation implements MyUserServiceInterface {

    @Autowired
    private MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserRepository.findByUsername(username);
        if (myUser == null) {
            throw new UsernameNotFoundException("Invalid Username");
        }
        User springSecurityUser = new User(myUser.getUsername(), myUser.getUserPassword(), mapRoleToAuthorities(myUser.getRoleId()));
        return springSecurityUser;
    }

    private List<? extends GrantedAuthority> mapRoleToAuthorities(Role role) {
        List<GrantedAuthority> authorities = new ArrayList();
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(authority);
        return authorities;
    }

    @Override
    public void saveMyUser(MyUser user) {
        myUserRepository.save(user);
    }

    @Override
    public MyUser findByUsername(String username){
      return   myUserRepository.findByUsername(username);
    }
    
    public MyUser findById(Integer userId) {
       Optional<MyUser> userRetrieved = myUserRepository.findById(userId);
       if(userRetrieved.isPresent()){
           return userRetrieved.get();
       }
        return null;
    }
    

}
