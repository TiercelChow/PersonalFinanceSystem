package com.demo.service;

import com.demo.pojo.Change;

import java.util.List;

public interface ChangeService {
    public List<Change> selectChangeAll();

    public int addChange(Change change);

    public Change selectChangeById(Integer id);

    public int  updateChange(Change change);

    public int deleteChangeById(Change change);

    public int addChangeMoney(Change change);

}
