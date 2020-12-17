/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.UserAppointments;

/**
 *
 * @author vaggelis
 */


public interface UserAppointmentsServiceInterface {
  
    
    public void giveTheInitialAppointments(UserAppointments userAppointments);
    
      public int checkAvailableAppointmentsOfAUser(int user);
      
       public void subtrackAvailableAppointmentsAfterReservation(int userId);
}
