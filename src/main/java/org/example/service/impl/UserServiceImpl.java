package org.example.service.impl;


import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.Md5Util;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getByUserName(String username) {
        User user= userMapper.getByUserName(username);
        return user;
    }

    @Override
    public void register(String username, String password) {
        String md5pw= Md5Util.getMD5String(password);
        userMapper.add(username,md5pw);
    }

    @Override
    public void update(@Validated User user) {
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String url) {
        Map<String,Object>claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        userMapper.updateAvatar(url,id);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String,Object>claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        userMapper.updatePwd(Md5Util.getMD5String(newPwd),id);
    }


}
