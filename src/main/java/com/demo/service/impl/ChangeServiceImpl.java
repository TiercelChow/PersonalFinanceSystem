package com.demo.service.impl;


import com.demo.mapper.ChangeMapper;
import com.demo.pojo.Change;
import com.demo.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeServiceImpl implements ChangeService {
    @Autowired
    private ChangeMapper changeMapper;

    @Override
    public List<Change> selectChangeAll() {
        return changeMapper.selectChangeAll();
    }

    @Override
    public int addChange(Change change) {
        return changeMapper.addChange(change);
    }

    @Override
    public Change selectChangeById(Integer id) {
        return changeMapper.selectChangeById(id);
    }

    @Override
    public int updateChange(Change change) {
        return changeMapper.updateChange(change);
    }

    @Override
    public int deleteChangeById(Change change) {
        return changeMapper.deleteChangeById(change);
    }


    @Override
    public int addChangeMoney(Change change) {
        return changeMapper.addChangeMoney(change);
    }
}
