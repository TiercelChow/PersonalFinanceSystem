package com.demo.service.impl;


import com.demo.mapper.FundMapper;
import com.demo.pojo.Fund;
import com.demo.service.FundService;
import com.demo.pojo.MyFinance.UserFund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundServiceImpl implements FundService {
    @Autowired
    private FundMapper fundMapper;

    @Override
    public List<Fund> selectFundAll() {
        return fundMapper.selectFundAll();
    }

    @Override
    public int addFund(Fund fund) {
        return fundMapper.addFund(fund);
    }

    @Override
    public Fund selectFundById(Integer id) {
        return fundMapper.selectFundById(id);
    }

    @Override
    public int updateFund(Fund fund) {
        return fundMapper.updateFund(fund);
    }

    @Override
    public int deleteFundById(Fund fund) {
        return fundMapper.deleteFundById(fund);
    }

    @Override
    public int addFundMoney(UserFund userFund) {
        return fundMapper.addFundMoney(userFund);
    }
}
