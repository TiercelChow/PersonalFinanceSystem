package com.demo.service;

import com.demo.pojo.MyFinance.UserChange;
import com.demo.pojo.MyFinance.UserFund;
import com.demo.pojo.MyFinance.UserPay;
import com.demo.pojo.MyFinance.UserTerm;

import java.util.List;

public interface MyFinanceService {
    public List<UserChange> selectUserChangeByuserId(Integer userId);
    public List<UserPay> selectUserPayByuserId(Integer userId);
    public List<UserTerm> selectUserTermByuserId(Integer userId);
    public List<UserFund> selectUserFundByuserId(Integer userId);
    public int updateUserMoney(UserChange userChange);
    public int updatePayMoney(UserPay userPay);
    public int updateTermMoney(UserTerm userTerm);
    public int updateFundMoney(UserFund userFund);
}
