/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.Activity;

/**
 *
 * @author vaggelis
 */
public interface ActivityServiceInterface {

    public Activity findActivityById(int id);

    public boolean findIfAnActivityExists(String activityName);

    public Activity findActivityByName(String activityName);

}
