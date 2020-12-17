/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.repositories;

import com.webapp.groupproject.models.UserAppointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author vaggelis
 */
public interface UserAppointmentsRepository extends JpaRepository<UserAppointments, Integer> {

    @Query(value = "Select ua.available_appointments from user_appointments ua where ua.user_id=?1", nativeQuery = true)
    public int checkAvailableAppointmentsOfAUser(int userId);

    
    @Modifying
    @Query(value = "update user_appointments set available_appointments=available_appointments-1 where user_id=?1", nativeQuery = true)
    public void subtrackAvailableAppointmentsAfterReservation(int userId);
}
