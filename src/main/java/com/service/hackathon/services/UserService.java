package com.service.hackathon.services;

import com.service.hackathon.models.Membership;
import com.service.hackathon.models.User;
import com.service.hackathon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(final String phone) {
        final User user = new User(phone);
        userRepository.saveUser(user);
        return user;
    }

    public User getUser(final long userId) {
        return userRepository.getUserById(userId);
    }

    public User getUser(final String phone) {
        return userRepository.getUserByPhone(phone);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public Membership getMembership(final String phone) {
        final User user = userRepository.getUserByPhone(phone);
        return user.getMembership();
    }

    public boolean updateMembership(final String phone, final Membership membership) {
        final User user = userRepository.getUserByPhone(phone);
        user.setMembership(membership);
        if (!userRepository.saveUser(user)) {
            return false;
        }
        return true;
    }

}
