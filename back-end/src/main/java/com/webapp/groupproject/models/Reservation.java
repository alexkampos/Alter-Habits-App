/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vaggelis
 */
@Entity
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
    , @NamedQuery(name = "Reservation.findByReservationId", query = "SELECT r FROM Reservation r WHERE r.reservationId = :reservationId")
    , @NamedQuery(name = "Reservation.findByReservationDate", query = "SELECT r FROM Reservation r WHERE r.reservationDate = :reservationDate")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reservation_id")
    private Integer reservationId;
    @Column(name = "reservation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reservationDate;
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Shop shopId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    @JsonBackReference
    private MyUser userId;
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id")
    @ManyToOne(optional = false)
    private Activity activityId;

   public Reservation(){}

    public Reservation(Date reservationDate, Shop shopId, MyUser userId, Activity activityId) {

        this.reservationDate = reservationDate;
        this.shopId = shopId;
        this.userId = userId;
        this.activityId = activityId;
    }

    public Reservation(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Activity getActivityId() {
        return activityId;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Shop getShopId() {
        return shopId;
    }

    public void setShopId(Shop shopId) {
        this.shopId = shopId;
    }

    public MyUser getUserId() {
        return userId;
    }

    public void setUserId(MyUser userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationId != null ? reservationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.reservationId == null && other.reservationId != null) || (this.reservationId != null && !this.reservationId.equals(other.reservationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webapp.groupproject.models.Reservation[ reservationId=" + reservationId + " ]";
    }

}
