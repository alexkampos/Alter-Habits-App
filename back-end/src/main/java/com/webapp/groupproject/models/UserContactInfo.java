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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vaggelis
 */
@Entity
@Table(name = "user_contact_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserContactInfo.findAll", query = "SELECT u FROM UserContactInfo u")
    , @NamedQuery(name = "UserContactInfo.findByContactInfoId", query = "SELECT u FROM UserContactInfo u WHERE u.contactInfoId = :contactInfoId")
    , @NamedQuery(name = "UserContactInfo.findByEmail", query = "SELECT u FROM UserContactInfo u WHERE u.email = :email")
    , @NamedQuery(name = "UserContactInfo.findByPhoneNumber", query = "SELECT u FROM UserContactInfo u WHERE u.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "UserContactInfo.findByMobileNumber", query = "SELECT u FROM UserContactInfo u WHERE u.mobileNumber = :mobileNumber")})
public class UserContactInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contact_info_id")
    private Integer contactInfoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "email")
    private String email;
    @Size(max = 10)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "mobile_number")
    private String mobileNumber;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private MyUser userId;

    public UserContactInfo() {
    }

    public UserContactInfo(Integer contactInfoId) {
        this.contactInfoId = contactInfoId;
    }

    public UserContactInfo(Integer contactInfoId, String email, String mobileNumber) {
        this.contactInfoId = contactInfoId;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public Integer getContactInfoId() {
        return contactInfoId;
    }

    public void setContactInfoId(Integer contactInfoId) {
        this.contactInfoId = contactInfoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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
        hash += (contactInfoId != null ? contactInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserContactInfo)) {
            return false;
        }
        UserContactInfo other = (UserContactInfo) object;
        if ((this.contactInfoId == null && other.contactInfoId != null) || (this.contactInfoId != null && !this.contactInfoId.equals(other.contactInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webapp.groupproject.models.UserContactInfo[ contactInfoId=" + contactInfoId + " ]";
    }

}
