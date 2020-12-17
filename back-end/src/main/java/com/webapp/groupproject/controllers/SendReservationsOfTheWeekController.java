/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.Reservation;
import com.webapp.groupproject.models.SendReservationsOfTheWeekDto;
import com.webapp.groupproject.services.ReservationServiceInterface;
import com.webapp.groupproject.utils.BookingUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vaggelis
 */

@RestController
public class SendReservationsOfTheWeekController {

    @Autowired
    ReservationServiceInterface reservationServiceInterface;

    @Autowired
    BookingUtils bookingUtils;

    
    @PreAuthorize("hasRole('USER') or hasRole('PREMIUM') or hasRole('ELIT')")
    @GetMapping("/showListOfTheWeekReservationsOfTheUser")
    public List<SendReservationsOfTheWeekDto> showListOfTheWeekReservationsOfTheUser() {
        MyUser myUser = bookingUtils.takeTheLoggedInUser();
        List<Reservation> reservationList = new ArrayList();
        List<SendReservationsOfTheWeekDto> listSentReservations = new ArrayList();
        reservationList.addAll(reservationServiceInterface.showWeeklyReservationsOfAUser(myUser.getUserId()));

        for (Reservation r : reservationList) {
            SendReservationsOfTheWeekDto sendReservationsOfTheWeekDto = new SendReservationsOfTheWeekDto();
            sendReservationsOfTheWeekDto.setReservationDate(r.getReservationDate());
            sendReservationsOfTheWeekDto.setShopName(r.getShopId().getShopName());
            sendReservationsOfTheWeekDto.setLatitude(r.getShopId().getLatitude());
            sendReservationsOfTheWeekDto.setLongitude(r.getShopId().getLongitude());
            sendReservationsOfTheWeekDto.setActivityName(r.getActivityId().getActivityName());
            listSentReservations.add(sendReservationsOfTheWeekDto);

        }

        return listSentReservations;
    }

}
