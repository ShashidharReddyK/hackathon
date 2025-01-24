package com.service.hackathon.controllers;

import com.service.hackathon.models.Membership;
import com.service.hackathon.models.User;
import com.service.hackathon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public ResponseEntity<String> getUser() {
        return new ResponseEntity<>( "Hello World", HttpStatus.OK);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody final String phone) {
        final User user = userService.saveUser(phone);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getMembership")
    public ResponseEntity<Membership> getMemberShip(@RequestBody final String phone) {
        return new ResponseEntity<>(userService.getMembership(phone), HttpStatus.OK);
    }

    @PostMapping("/upgradeMemberShip")
    public ResponseEntity<Membership> upgradeMemberShip(@RequestBody final String phone) {
        userService.updateMembership(phone, Membership.PREMIUM);
        return new ResponseEntity<>(Membership.PREMIUM, HttpStatus.OK);
    }

    @PostMapping("/downgradeMembership")
    public ResponseEntity<Membership> downgradeMemberShip(@RequestBody final String phone) {
        userService.updateMembership(phone, Membership.NORMAL);
        return new ResponseEntity<>(Membership.NORMAL, HttpStatus.OK);
    }

}
