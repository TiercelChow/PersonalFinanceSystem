package com.demo.service;

import com.demo.pojo.Pay;

import java.util.List;

public interface PayService {
    public List<Pay> selectPayAll();

    public int addPay(Pay pay);

    public Pay selectPayById(Integer id);

    public int  updatePay(Pay pay);

    public int deletePayById(Pay pay);

    public int addPayMoney(Pay pay);

    public  int insertFlowOfFund(Pay pay);
}
