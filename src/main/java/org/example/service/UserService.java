package org.example.service;

import org.example.pojo.User;

public interface UserService {
    User getByUserName(String username);

    void register(String username, String password);
}
