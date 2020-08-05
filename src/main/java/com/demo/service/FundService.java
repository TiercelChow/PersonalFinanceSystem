package com.demo.service;

import com.demo.pojo.Fund;
import com.demo.pojo.MyFinance.UserFund;

import java.util.List;

public interface FundService {
    public List<Fund> selectFundAll();
    public int addFund(Fund fund);
    public Fund selectFundById(Integer id);
    public int  updateFund(Fund fund);
    public int deleteFundById(Fund fund);
    public int addFundMoney(UserFund userFund);
    public  int insertFlowOfFund(UserFund userFund);
}
