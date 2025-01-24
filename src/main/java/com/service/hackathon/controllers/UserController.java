package com.service.hackathon.controllers;

import com.service.hackathon.models.Membership;
import com.service.hackathon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/saveUser")
    public void saveUser(@PathVariable("phone") final String phone) {
        userService.saveUser(phone);
    }

    @RequestMapping("/getMembership")
    public Membership getMemberShip(@PathVariable("phone") final String phone) {
        return userService.getMembership(phone);
    }

    @RequestMapping("/upgradeMemberShip")
    public Membership upgradeMemberShip(@PathVariable("phone") final String phone) {
        userService.updateMembership(phone, Membership.PREMIUM);
        return Membership.PREMIUM;
    }

    @RequestMapping("/downgradeMembership")
    public Membership downgradeMemberShip(@PathVariable("phone") final String phone) {
        userService.updateMembership(phone, Membership.NORMAL);
        return Membership.NORMAL;
    }

}
