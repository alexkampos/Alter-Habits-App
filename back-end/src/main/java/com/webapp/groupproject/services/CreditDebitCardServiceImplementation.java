/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.CreditDebitCard;
import com.webapp.groupproject.repositories.CreditDebitCardRepository;
import java.util.Optional;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexk
 */
@Service
public class CreditDebitCardServiceImplementation implements CreditDebitCardServiceInterface {
    
    @Autowired
    CreditDebitCardRepository creditDebitCardRepository;
    
    @Override
    public void saveCreditDebitCard(CreditDebitCard creditDebitCard) {
        
        creditDebitCardRepository.save(creditDebitCard);
        
    }

    @Override
    public CreditDebitCard findByCreditDebitCardNumber(String creditDebitCardNumber) {
        return creditDebitCardRepository.findByCreditDebitCardNumber(creditDebitCardNumber);
    }
    
    public boolean checkIfCreditDebitCardNumberExists(String creditDebitCardNumber) {
        return creditDebitCardRepository.existsByCreditDebitCardNumber(creditDebitCardNumber);
    }
    
    public CreditDebitCard findByCreditDebitCardId(Integer creditDebitCardId) {
       Optional<CreditDebitCard> cardRetrieved = creditDebitCardRepository.findById(creditDebitCardId);
       if(cardRetrieved.isPresent()) {
           return cardRetrieved.get();
       }
       return null;
    }
    
}
