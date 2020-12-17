/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.Activity;
import com.webapp.groupproject.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vaggelis
 */


@Service
public class ActivityServiceImplementation implements ActivityServiceInterface{
    
@Autowired
ActivityRepository activityRepository;

    @Override
    public Activity findActivityById(int id) {
      return  activityRepository.findById(id);
    }

    @Override
    public boolean findIfAnActivityExists(String activityName) {
        return activityRepository.findByActivityName(activityName)!=null;
    }

     @Override
    public Activity findActivityByName(String activityName) {
        return activityRepository.findByActivityName(activityName);
    }
}
