/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.repositories;

import com.webapp.groupproject.models.Reservation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author vaggelis
 */
public interface ReservationRepository extends JpaRepository<Reservation,Integer>{
    
    @Query(
    value="Select count(*) from reservation r where r.user_id=?1 and r.shop_id=?2",nativeQuery=true)
    public int showReservationsOfAUserToAShop(int userId,int shopId);
    
   @Query(
   value="Select * from reservation r where where r.user_id=?1",nativeQuery=true)
   public List<Reservation> showReservationsOfAUser(int userId);
       
       
   @Query(
    value="Select count(*) from reservation r where r.user_id=?1",nativeQuery=true)
    public int showNumberOfReservationsOfAUser(int userId);
    
    @Query(
    value="SELECT * FROM reservation r WHERE r.user_id=?1 AND "
            + "reservation_date BETWEEN NOW() "
            + "AND ADDDATE(NOW(), INTERVAL 7 DAY) ",nativeQuery=true)
    public List<Reservation> showWeeklyReservationsOfAUser(int userId);
   
   
}
