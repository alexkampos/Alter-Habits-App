/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.repositories;

import com.webapp.groupproject.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alexk
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{
    
    public Role findByRole (String role);
    
    public Role findByRoleId(int roleId);
    
}
