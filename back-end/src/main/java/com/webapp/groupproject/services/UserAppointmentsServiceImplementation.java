/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.UserAppointments;
import com.webapp.groupproject.repositories.UserAppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vaggelis
 */
@Transactional
@Service
public class UserAppointmentsServiceImplementation implements UserAppointmentsServiceInterface {

    @Autowired
    UserAppointmentsRepository userAppointmentsRepository;

    @Override
    public void giveTheInitialAppointments(UserAppointments userAppointments){
       userAppointmentsRepository.save(userAppointments);
    }

    @Override
    public int checkAvailableAppointmentsOfAUser(int user) {
      return userAppointmentsRepository.checkAvailableAppointmentsOfAUser(user);
    
}

    @Override
    public void subtrackAvailableAppointmentsAfterReservation(int userId) {
       userAppointmentsRepository.subtrackAvailableAppointmentsAfterReservation(userId);
    }
}