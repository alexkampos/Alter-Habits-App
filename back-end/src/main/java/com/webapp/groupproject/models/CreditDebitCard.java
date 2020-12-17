/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexk
 */
@Entity
@Table(name = "credit_debit_cards")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditDebitCard.findAll", query = "SELECT c FROM CreditDebitCard c"),
    @NamedQuery(name = "CreditDebitCard.findByCreditDebitCardId", query = "SELECT c FROM CreditDebitCard c WHERE c.creditDebitCardId = :creditDebitCardId"),
    @NamedQuery(name = "CreditDebitCard.findByCreditDebitCardNumber", query = "SELECT c FROM CreditDebitCard c WHERE c.creditDebitCardNumber = :creditDebitCardNumber"),
    @NamedQuery(name = "CreditDebitCard.findByCreditDebitCardExpirationMonth", query = "SELECT c FROM CreditDebitCard c WHERE c.creditDebitCardExpirationMonth = :creditDebitCardExpirationMonth"),
    @NamedQuery(name = "CreditDebitCard.findByCreditDebitCardExpirationYear", query = "SELECT c FROM CreditDebitCard c WHERE c.creditDebitCardExpirationYear = :creditDebitCardExpirationYear"),
    @NamedQuery(name = "CreditDebitCard.findByCreditDebitCardName", query = "SELECT c FROM CreditDebitCard c WHERE c.creditDebitCardName = :creditDebitCardName")})
public class CreditDebitCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "credit_debit_card_id")
    private Integer creditDebitCardId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "credit_debit_card_number")
    private String creditDebitCardNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credit_debit_card_expiration_month")
    private int creditDebitCardExpirationMonth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credit_debit_card_expiration_year")
    private int creditDebitCardExpirationYear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "credit_debit_card_name")
    private String creditDebitCardName;
    
    @ManyToMany(mappedBy = "creditDebitCardCollection")
    private Collection<MyUser> myUserCollection = new ArrayList();

    public CreditDebitCard() {
    }

    public CreditDebitCard(Integer creditDebitCardId) {
        this.creditDebitCardId = creditDebitCardId;
    }

    public CreditDebitCard(Integer creditDebitCardId, String creditDebitCardNumber, int creditDebitCardExpirationMonth, int creditDebitCardExpirationYear, String creditDebitCardName, Collection<MyUser> myUserCollection) {
        this.creditDebitCardId = creditDebitCardId;
        this.creditDebitCardNumber = creditDebitCardNumber;
        this.creditDebitCardExpirationMonth = creditDebitCardExpirationMonth;
        this.creditDebitCardExpirationYear = creditDebitCardExpirationYear;
        this.creditDebitCardName = creditDebitCardName;
        this.myUserCollection = myUserCollection;
    }

    public Collection<MyUser> getMyUserCollection() {
        return myUserCollection;
    }

    public void setMyUserCollection(Collection<MyUser> myUserCollection) {
        this.myUserCollection = myUserCollection;
    }

    public Integer getCreditDebitCardId() {
        return creditDebitCardId;
    }

    public void setCreditDebitCardId(Integer creditDebitCardId) {
        this.creditDebitCardId = creditDebitCardId;
    }

    public String getCreditDebitCardNumber() {
        return creditDebitCardNumber;
    }

    public void setCreditDebitCardNumber(String creditDebitCardNumber) {
        this.creditDebitCardNumber = creditDebitCardNumber;
    }

    public int getCreditDebitCardExpirationMonth() {
        return creditDebitCardExpirationMonth;
    }

    public void setCreditDebitCardExpirationMonth(int creditDebitCardExpirationMonth) {
        this.creditDebitCardExpirationMonth = creditDebitCardExpirationMonth;
    }

    public int getCreditDebitCardExpirationYear() {
        return creditDebitCardExpirationYear;
    }

    public void setCreditDebitCardExpirationYear(int creditDebitCardExpirationYear) {
        this.creditDebitCardExpirationYear = creditDebitCardExpirationYear;
    }

    public String getCreditDebitCardName() {
        return creditDebitCardName;
    }

    public void setCreditDebitCardName(String creditDebitCardName) {
        this.creditDebitCardName = creditDebitCardName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditDebitCardId != null ? creditDebitCardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditDebitCard)) {
            return false;
        }
        CreditDebitCard other = (CreditDebitCard) object;
        if ((this.creditDebitCardId == null && other.creditDebitCardId != null) || (this.creditDebitCardId != null && !this.creditDebitCardId.equals(other.creditDebitCardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webapp.groupproject.models.CreditDebitCard[ creditDebitCardId=" + creditDebitCardId + " ]";
    }
    
}
