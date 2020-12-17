/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.models.Activity;
import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.Reservation;
import com.webapp.groupproject.models.Shop;
import com.webapp.groupproject.services.ActivityServiceInterface;
import com.webapp.groupproject.services.MyUserServiceInterface;
import com.webapp.groupproject.services.ReservationServiceInterface;
import com.webapp.groupproject.services.RoleServiceInterface;
import com.webapp.groupproject.services.ShopServiceInterface;
import com.webapp.groupproject.services.UserAppointmentsServiceInterface;
import com.webapp.groupproject.utils.BookingUtils;
import com.webapp.groupproject.utils.HelperMethods;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vaggelis
 */
@RestController
public class BookController {

    @Autowired
    ShopServiceInterface shopServiceInterface;

    @Autowired
    MyUserServiceInterface myUserServiceInterface;

    @Autowired
    ReservationServiceInterface reservationServiceInterface;

    @Autowired
    ActivityServiceInterface activityServiceInterface;

    @Autowired
    RoleServiceInterface roleServiceInterface;

    @Autowired
    BookingUtils bookingUtils;

    @Autowired
    UserAppointmentsServiceInterface userAppointmentsServiceInterface;

   @PreAuthorize("hasRole('USER') or hasRole('PREMIUM') or hasRole('ELIT')")
    @GetMapping("/book")
    public String bookAppointment(@RequestParam String shopId,
            @RequestParam String activityId,
            @RequestParam String date
    ) { 
        MyUser myUser = bookingUtils.takeTheLoggedInUser();

       
        String result;
        String manipulateRequestString=HelperMethods.manipulateDateString(date);
        Date reservationDate = HelperMethods.parseStringToDate(manipulateRequestString);
    
        Shop shop = shopServiceInterface.findByShopId(Integer.parseInt(shopId));
       
        Activity activity = activityServiceInterface.findActivityById(Integer.parseInt(activityId));
       
        if (userAppointmentsServiceInterface.checkAvailableAppointmentsOfAUser(myUser.getUserId()) > 0) {
            Reservation reservation = new Reservation(
                    reservationDate,
                    shop,
                    myUser,
                    activity
            );

            reservationServiceInterface.insertReservation(reservation);
            userAppointmentsServiceInterface.subtrackAvailableAppointmentsAfterReservation(myUser.getUserId());
            result = "reservation completed";
        } else {
            result = "you have no more appointments ";
            //    }

        }
        return result;

    }
}

