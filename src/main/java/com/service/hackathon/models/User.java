package com.service.hackathon.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User extends BaseModel{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Membership membership;
    private List<Order> orders;

    public User(final String phone) {
        super();
        this.phone = phone;
        this.membership = Membership.NORMAL;
        orders = new ArrayList<>();
    }

}
