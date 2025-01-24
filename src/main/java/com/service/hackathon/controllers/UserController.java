package com.service.hackathon.controllers;

import com.service.hackathon.dtos.UserDto;
import com.service.hackathon.dtos.UserRequestDto;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public ResponseEntity<UserDto> getUser(@RequestBody final UserRequestDto userRequestDto) {
        final String phone = userRequestDto.getPhone();
        return new ResponseEntity<>(UserDto.from(userService.getUser(phone)), HttpStatus.OK);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        final List<UserDto> userDtos = new ArrayList<>();
        for(User user: userService.getAllUsers()){
            userDtos.add(UserDto.from(user));
        }
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<UserDto> saveUser(@RequestBody final UserRequestDto userRequestDto) {
        final String phone = userRequestDto.getPhone();
        final User user = userService.saveUser(phone);
        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
    }

    @GetMapping("/getMembership")
    public ResponseEntity<Membership> getMembership(@RequestBody final UserRequestDto userRequestDto) {
        final String phone = userRequestDto.getPhone();
        return new ResponseEntity<>(userService.getMembership(phone), HttpStatus.OK);
    }

    @PostMapping("/upgradeMembership")
    public ResponseEntity<Membership> upgradeMembership(@RequestBody final UserRequestDto userRequestDto) {
        final String phone = userRequestDto.getPhone();
        userService.updateMembership(phone, Membership.PREMIUM);
        return new ResponseEntity<>(Membership.PREMIUM, HttpStatus.OK);
    }

    @PostMapping("/downgradeMembership")
    public ResponseEntity<Membership> downgradeMembership(@RequestBody UserRequestDto userRequestDto) {
        final String phone = userRequestDto.getPhone();
        userService.updateMembership(phone, Membership.NORMAL);
        return new ResponseEntity<>(Membership.NORMAL, HttpStatus.OK);
    }

}
