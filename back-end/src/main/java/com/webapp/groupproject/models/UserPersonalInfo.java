/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vaggelis
 */
@Entity
@Table(name = "user_personal_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserPersonalInfo.findAll", query = "SELECT u FROM UserPersonalInfo u")
    , @NamedQuery(name = "UserPersonalInfo.findByPersonalInfoId", query = "SELECT u FROM UserPersonalInfo u WHERE u.personalInfoId = :personalInfoId")
    , @NamedQuery(name = "UserPersonalInfo.findByFirstName", query = "SELECT u FROM UserPersonalInfo u WHERE u.firstName = :firstName")
    , @NamedQuery(name = "UserPersonalInfo.findByLastName", query = "SELECT u FROM UserPersonalInfo u WHERE u.lastName = :lastName")
    , @NamedQuery(name = "UserPersonalInfo.findByDateOfBirth", query = "SELECT u FROM UserPersonalInfo u WHERE u.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "UserPersonalInfo.findByGender", query = "SELECT u FROM UserPersonalInfo u WHERE u.gender = :gender")})
public class UserPersonalInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "personal_info_id")
    private Integer personalInfoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 2, max = 100)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "gender")
    private String gender;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private MyUser userId;

    public UserPersonalInfo() {
    }

    public UserPersonalInfo(Integer personalInfoId) {
        this.personalInfoId = personalInfoId;
    }

    public UserPersonalInfo(Integer personalInfoId, String firstName, String lastName, Date dateOfBirth, String gender) {
        this.personalInfoId = personalInfoId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public Integer getPersonalInfoId() {
        return personalInfoId;
    }

    public void setPersonalInfoId(Integer personalInfoId) {
        this.personalInfoId = personalInfoId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        hash += (personalInfoId != null ? personalInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPersonalInfo)) {
            return false;
        }
        UserPersonalInfo other = (UserPersonalInfo) object;
        if ((this.personalInfoId == null && other.personalInfoId != null) || (this.personalInfoId != null && !this.personalInfoId.equals(other.personalInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webapp.groupproject.models.UserPersonalInfo[ personalInfoId=" + personalInfoId + " ]";
    }
    
}
