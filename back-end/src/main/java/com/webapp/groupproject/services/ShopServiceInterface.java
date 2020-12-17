/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.Shop;
import java.util.List;

/**
 *
 * @author vaggelis
 */
public interface ShopServiceInterface {

    
    public List<Shop> findShops();

     public List<Shop> findByActivitiesId(int id);
     
     public Shop findByShopId(int id);
     
     public boolean findIfAShopNameDoesNotExists(String shopName);
     
     public Shop insertShop(Shop shop);
        
    
}
