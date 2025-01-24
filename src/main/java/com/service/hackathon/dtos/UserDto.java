package com.service.hackathon.dtos;

import com.service.hackathon.models.Membership;
import com.service.hackathon.models.Order;
import com.service.hackathon.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Membership membership;
    private List<Order> orders;

    public static UserDto from(User user) {
        if (user == null) return null;
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        userDto.setMembership(user.getMembership());
        userDto.setOrders(user.getOrders());
        return userDto;
    }
}
