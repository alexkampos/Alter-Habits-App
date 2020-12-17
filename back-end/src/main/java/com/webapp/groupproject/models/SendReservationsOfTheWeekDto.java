/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

import java.util.Date;

/**
 *
 * @author vaggelis
 */
public class SendReservationsOfTheWeekDto {
    
    String shopName;
    String longitude;
    String latitude;
    Date reservationDate;
    String activityName;

    public SendReservationsOfTheWeekDto(String shopName, String longitude, String latitude, Date reservationDate, String activityName) {
        this.shopName = shopName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.reservationDate = reservationDate;
        this.activityName = activityName;
    }

    public SendReservationsOfTheWeekDto() {
        
    }

    public String getShopName() {
        return shopName;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
    
    
    
    
}
