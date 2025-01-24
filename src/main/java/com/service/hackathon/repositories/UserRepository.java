package com.service.hackathon.repositories;

import com.service.hackathon.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {
    private final HashMap<Long, User> users;
    private final HashMap<String, Long> userIds;


    public UserRepository() {
        users = new HashMap<>();
        userIds = new HashMap<>();
    }

    public boolean saveUser(final User user) {
        userIds.put(user.getPhone(), user.getId());
        users.put(user.getId(), user);
        return true;
    }


    public User getUserByPhone(final String phone) {
        return users.getOrDefault(userIds.getOrDefault(phone, null), null);
    }

    public User getUserById(final long id) {
        return users.getOrDefault(id, null);
    }

}
