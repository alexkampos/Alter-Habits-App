/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.Reservation;
import java.util.List;

/**
 *
 * @author vaggelis
 */
public interface ReservationServiceInterface {
    
    
    public void insertReservation(Reservation reservation);
    
    
    public int showReservationsOfAUserToAShop(int userId,int ShopId);
    
   public List<Reservation> showReservationsOfAUser(int userId);
   
   public int showNumberOfReservationsOfAUser(int userId);
   
   
   public List<Reservation> showWeeklyReservationsOfAUser(int userId);
}
