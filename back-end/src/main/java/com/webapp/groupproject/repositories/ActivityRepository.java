/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.repositories;

import com.webapp.groupproject.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vaggelis
 */
 
public interface ActivityRepository extends JpaRepository<Activity, Integer>{
    
    public Activity findById(int id);
    
    public Activity findByActivityName(String activityName);
    
}
