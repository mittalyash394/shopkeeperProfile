package com.yash.shopkeeper.Shopkeeper.Profile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/shopKeeper")
@RestController
public class ShopkeeperController {

    @GetMapping("/root")
    public String root(){
        return "Shopkeeper profile";
    }

}
