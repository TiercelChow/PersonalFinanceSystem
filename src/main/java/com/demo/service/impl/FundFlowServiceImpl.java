package com.demo.service.impl;

import com.demo.mapper.FundFlowMapper;
import com.demo.pojo.FundFlow;
import com.demo.service.FundFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundFlowServiceImpl implements FundFlowService {
    @Autowired
    private FundFlowMapper fundFlowMapper;

    @Override
    public List<FundFlow> selectFundFlowAll(Integer userId) {
        return fundFlowMapper.selectFundFlowAll(userId);
    }
}
