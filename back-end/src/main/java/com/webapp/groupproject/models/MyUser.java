/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexk
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MyUser.findAll", query = "SELECT m FROM MyUser m")
    ,
    @NamedQuery(name = "MyUser.findByUserId", query = "SELECT m FROM MyUser m WHERE m.userId = :userId")
    ,
    @NamedQuery(name = "MyUser.findByUsername", query = "SELECT m FROM MyUser m WHERE m.username = :username")
    ,
    @NamedQuery(name = "MyUser.findByUserPassword", query = "SELECT m FROM MyUser m WHERE m.userPassword = :userPassword")})
public class MyUser implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 68)
    @Column(name = "user_password")
    private String userPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    @JsonManagedReference
    private Collection<UserAppointments> userAppointmentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    @JsonManagedReference
    private Collection<Reservation> reservationCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;

    @JsonManagedReference
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Role roleId;

    @JsonIgnore
    @JoinTable(name = "user_credit_debit_card",
            joinColumns = {
                @JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "credit_debit_card_id", referencedColumnName = "credit_debit_card_id")})
    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<CreditDebitCard> creditDebitCardCollection = new ArrayList();

    public MyUser() {
    }

    public MyUser(Integer userId) {
        this.userId = userId;
    }

    public MyUser(String username, String userPassword, Integer userId, Role roleId, Collection<CreditDebitCard> creditDebitCardCollection) {
        this.username = username;
        this.userPassword = userPassword;
        this.userId = userId;
        this.roleId = roleId;
        this.creditDebitCardCollection = creditDebitCardCollection;
    }

    public Collection<CreditDebitCard> getCreditDebitCardCollection() {
        return creditDebitCardCollection;
    }

    public void setCreditDebitCardCollection(Collection<CreditDebitCard> creditDebitCardCollection) {
        this.creditDebitCardCollection = creditDebitCardCollection;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MyUser)) {
            return false;
        }
        MyUser other = (MyUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webapp.groupproject.models.MyUser[ userId=" + userId + " ]";
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlTransient
    public Collection<UserAppointments> getUserAppointmentsCollection() {
        return userAppointmentsCollection;
    }

    public void setUserAppointmentsCollection(Collection<UserAppointments> userAppointmentsCollection) {
        this.userAppointmentsCollection = userAppointmentsCollection;
    }

}
