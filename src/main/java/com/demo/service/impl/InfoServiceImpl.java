package com.demo.service.impl;

import com.demo.mapper.InfoMapper;
import com.demo.pojo.Info;
import com.demo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoMapper infoMapper;

    @Override
    public List<Info> SelectInfoById(Integer loginUser) {
        return infoMapper.SelectInfoById(loginUser);
    }

    @Override
    public int UpdateInfoStatus(Info info) {
        return infoMapper.UpdateInfoStatus(info);
    }

    @Override
    public int DeleteInfo(Info info) {
        return infoMapper.DeleteInfo(info);
    }

    @Override
    public int AddInfo(Info info) {
        return infoMapper.addInfo(info);
    }
}
