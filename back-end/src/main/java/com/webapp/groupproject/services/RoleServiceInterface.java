/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.Role;

/**
 *
 * @author alexk
 */
public interface RoleServiceInterface {
    
    public Role findByRoleName (String roleName);
    
     public Role findByRoleId(int roleId);
}
