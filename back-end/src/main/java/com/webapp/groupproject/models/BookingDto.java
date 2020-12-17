/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

/**
 *
 * @author vaggelis
 */
public class BookingDto {
    
    private String reservationDate;
    private String shopId;
    private String username;
    private String activityId;

    public BookingDto() {
    }
    
    

    public BookingDto(String reservationDate, String shopId, String username, String activityId) {
        this.reservationDate = reservationDate;
        this.shopId = shopId;
        this.username = username;
        this.activityId = activityId;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public String getShopId() {
        return shopId;
    }

    public String getUsername() {
        return username;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }
    
    
    
}
