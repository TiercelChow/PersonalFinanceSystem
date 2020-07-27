package com.demo.service.impl;


import com.demo.mapper.PayMapper;
import com.demo.pojo.Pay;
import com.demo.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private PayMapper payMapper;

    @Override
    public List<Pay> selectPayAll() {
        return payMapper.selectPayAll();
    }

    @Override
    public int addPay(Pay pay) {
        return payMapper.addPay(pay);
    }

    @Override
    public Pay selectPayById(Integer id) {
        return payMapper.selectPayById(id);
    }

    @Override
    public int updatePay(Pay pay) {
        return payMapper.updatePay(pay);
    }

    @Override
    public int deletePayById(Pay pay) {
        return payMapper.deletePayById(pay);
    }

    @Override
    public int addPayMoney(Pay pay) {
        return payMapper.addPayMoney(pay);
    }
}
