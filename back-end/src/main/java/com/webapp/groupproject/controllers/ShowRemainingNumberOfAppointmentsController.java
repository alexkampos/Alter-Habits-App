/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.services.UserAppointmentsServiceInterface;
import com.webapp.groupproject.utils.BookingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vaggelis
 */
@RestController
public class ShowRemainingNumberOfAppointmentsController {

    @Autowired
    BookingUtils bookingUtils;

    @Autowired
    UserAppointmentsServiceInterface userAppointmentsServiceInterface;

    
    @PreAuthorize("hasRole('USER') or hasRole('PREMIUM') or hasRole('ELIT')")
    @GetMapping("/showRemainingAppointments")
    public int showRemainingAppointments() {
        MyUser myUser = bookingUtils.takeTheLoggedInUser();
        return  userAppointmentsServiceInterface.checkAvailableAppointmentsOfAUser(myUser.getUserId());
    }

}
