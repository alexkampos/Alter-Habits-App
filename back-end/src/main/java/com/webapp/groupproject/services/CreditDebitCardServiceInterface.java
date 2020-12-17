/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.CreditDebitCard;

/**
 *
 * @author alexk
 */
public interface CreditDebitCardServiceInterface {
    
    public void saveCreditDebitCard(CreditDebitCard creditDebitCard);
    
    public CreditDebitCard findByCreditDebitCardNumber(String creditDebitCardNumber);
    
    public boolean checkIfCreditDebitCardNumberExists(String creditDebitCardNumber);
    
    public CreditDebitCard findByCreditDebitCardId(Integer creditDebitCardId);
    
}
