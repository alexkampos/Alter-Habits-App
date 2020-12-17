/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vaggelis
 */
@Entity
@Table(name = "user_appointments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAppointments.findAll", query = "SELECT u FROM UserAppointments u")
    , @NamedQuery(name = "UserAppointments.findById", query = "SELECT u FROM UserAppointments u WHERE u.id = :id")
    , @NamedQuery(name = "UserAppointments.findByAvailableAppointments", query = "SELECT u FROM UserAppointments u WHERE u.availableAppointments = :availableAppointments")})
public class UserAppointments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "available_appointments")
    private int availableAppointments;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private MyUser userId;

    public UserAppointments() {
    }

   

    public UserAppointments(Integer id, MyUser userId,int availableAppointments ) {
        this.id = id;
        this.userId = userId;
        this.availableAppointments = availableAppointments;
        
    }

    public UserAppointments( MyUser userId,int availableAppointments) {
        
        this.userId = userId;
        this.availableAppointments = availableAppointments;
    }

  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAvailableAppointments() {
        return availableAppointments;
    }

    public void setAvailableAppointments(int availableAppointments) {
        this.availableAppointments = availableAppointments;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAppointments)) {
            return false;
        }
        UserAppointments other = (UserAppointments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webapp.groupproject.models.UserAppointments[ id=" + id + " ]";
    }
    
}
