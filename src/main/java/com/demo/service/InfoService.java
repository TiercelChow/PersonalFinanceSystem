package com.demo.service;

import com.demo.pojo.Info;

import java.util.List;

public interface InfoService {
    public List<Info> SelectInfoById(Integer loginUser);

    public int UpdateInfoStatus(Info info);

    public int DeleteInfo(Info info);

    public int AddInfo(Info info);
}
