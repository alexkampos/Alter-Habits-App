/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.Role;
import com.webapp.groupproject.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexk
 */
@Service
public class RoleServiceImplementation implements RoleServiceInterface {

    @Autowired
    RoleRepository roleRepository;
    
    @Override
    public Role findByRoleName(String roleName) {
        
       return roleRepository.findByRole(roleName);
        
    }

    @Override
    public Role findByRoleId(int roleId) {
     return   roleRepository.findByRoleId(roleId);
    }
    
}
