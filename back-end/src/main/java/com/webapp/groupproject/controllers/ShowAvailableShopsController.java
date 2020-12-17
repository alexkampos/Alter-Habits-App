/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.models.Shop;
import com.webapp.groupproject.services.ActivityServiceInterface;
import com.webapp.groupproject.services.ShopServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vaggelis
 */
@RestController
public class ShowAvailableShopsController {

    @Autowired
    ShopServiceInterface shopServiceInterface;

    @Autowired
    ActivityServiceInterface activityServiceInterface;

    @GetMapping("/shops")
    public List<Shop> showAllShops() {
        List<Shop> shops = shopServiceInterface.findShops();
        return shops;

    }

}
