package com.service.hackathon.repositories;

import com.service.hackathon.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository {
    private final HashMap<Long, User> users;
    private final HashMap<String, Long> userIds;
    private final List<User> userList;


    public UserRepository() {
        users = new HashMap<>();
        userIds = new HashMap<>();
        userList = new ArrayList<>();
    }

    public boolean saveUser(final User user) {
        userIds.put(user.getPhone(), user.getId());
        users.put(user.getId(), user);
        userList.add(user);
        return true;
    }


    public User getUserByPhone(final String phone) {
        return users.getOrDefault(userIds.getOrDefault(phone, null), null);
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(final long id) {
        return users.getOrDefault(id, null);
    }

}
