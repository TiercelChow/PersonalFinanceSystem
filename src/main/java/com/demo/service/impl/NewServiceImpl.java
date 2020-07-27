package com.demo.service.impl;


import com.demo.mapper.NewMapper;
import com.demo.pojo.New;
import com.demo.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewServiceImpl implements NewService {
    @Autowired
    private NewMapper newMapper;

    @Override
    public List<New> selectNewAll() {
        return newMapper.selectNewAll();
    }
}
