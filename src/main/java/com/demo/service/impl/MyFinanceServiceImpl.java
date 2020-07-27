package com.demo.service.impl;


import com.demo.mapper.MyFinanceMapper;
import com.demo.pojo.MyFinance.UserChange;
import com.demo.pojo.MyFinance.UserFund;
import com.demo.pojo.MyFinance.UserPay;
import com.demo.pojo.MyFinance.UserTerm;
import com.demo.service.MyFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyFinanceServiceImpl implements MyFinanceService {
    @Autowired
    private MyFinanceMapper myFinanceMapper;

    @Override
    public List<UserChange> selectUserChangeByuserId(Integer userId) {
        return myFinanceMapper.selectUserChangeByuserId(userId);
    }

    @Override
    public List<UserPay> selectUserPayByuserId(Integer userId) {
        return myFinanceMapper.selectUserPayByuserId(userId);
    }

    @Override
    public List<UserTerm> selectUserTermByuserId(Integer userId) {
        return myFinanceMapper.selectUserTermByuserId(userId);
    }

    @Override
    public List<UserFund> selectUserFundByuserId(Integer userId) {
        return myFinanceMapper.selectUserFundByuserId(userId);
    }

    @Override
    public int updateUserMoney(UserChange userChange) {
        return myFinanceMapper.updateUserMoney(userChange);
    }

    @Override
    public int updatePayMoney(UserPay userPay) {
        return myFinanceMapper.updatePayMoney(userPay);
    }

    @Override
    public int updateTermMoney(UserTerm userTerm) {
        return myFinanceMapper.updateTermMoney(userTerm);
    }

    @Override
    public int updateFundMoney(UserFund userFund) {
        return myFinanceMapper.updateFundMoney(userFund);
    }
}
