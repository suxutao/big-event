package org.example.service.impl;


import org.example.mapper.UserMappler;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMappler userMappler;

    @Override
    public User getByUserName(String username) {
        User user=userMappler.getByUserName(username);
        return user;
    }

    @Override
    public void register(String username, String password) {
        String md5pw= Md5Util.getMD5String(password);
        userMappler.add(username,md5pw);
    }
}
