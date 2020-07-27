package com.demo.service.impl;


import com.demo.mapper.RegisterMapper;
import com.demo.pojo.User;
import com.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public int addUser(User user) {
        return registerMapper.addUser(user);
    }
}
