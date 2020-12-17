/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.repositories;

import com.webapp.groupproject.models.CreditDebitCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alexk
 */

 
public interface CreditDebitCardRepository extends JpaRepository<CreditDebitCard, Integer>{
    
    public CreditDebitCard findByCreditDebitCardNumber(String creditDebitCardNumber);
    
    public boolean existsByCreditDebitCardNumber(String creditDebitCardNumber);
    
}
