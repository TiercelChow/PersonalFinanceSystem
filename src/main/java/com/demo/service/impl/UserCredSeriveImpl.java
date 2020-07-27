package com.demo.service.impl;


import com.demo.mapper.UserCredMapper;
import com.demo.pojo.UserCred;
import com.demo.service.UserCredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCredSeriveImpl implements UserCredService {
    @Autowired
    private UserCredMapper userCredMapper;

    @Override
    public List<UserCred> selectUserCredAll() {
        return userCredMapper.selectUserCredAll();
    }

    @Override
    public int updateUserCred(UserCred userCred) {
        return userCredMapper.updateUserCred(userCred);
    }

    @Override
    public UserCred selectUserCredById(Integer id) {
        return userCredMapper.selectUserCredById(id);
    }
}
