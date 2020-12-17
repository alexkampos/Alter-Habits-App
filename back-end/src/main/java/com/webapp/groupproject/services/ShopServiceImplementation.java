/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.Shop;
import com.webapp.groupproject.repositories.ShopsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vaggelis
 */
@Service
public class ShopServiceImplementation implements ShopServiceInterface {

    @Autowired
    ShopsRepository shopRepository;

    @Override
    public List<Shop> findShops() {
        return shopRepository.findAll();
    }

    @Override
    public List<Shop> findByActivitiesId(int id) {
        return shopRepository.findAll();
    }

    @Override
    public Shop findByShopId(int id) {
        return shopRepository.findById(id).get();
    }

    @Override
    public boolean findIfAShopNameDoesNotExists(String shopName) {
        return shopRepository.findShopByShopName(shopName) == null;
    }

    @Override
    public Shop insertShop(Shop shop) {
        return shopRepository.save(shop);
    }

}
