package com.demo.service;

import com.demo.pojo.FundFlow;

import java.util.List;

public interface FundFlowService {
    public List<FundFlow> selectFundFlowAll(Integer userId);
}
