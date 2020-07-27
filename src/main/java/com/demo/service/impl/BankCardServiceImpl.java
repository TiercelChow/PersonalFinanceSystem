package com.demo.service.impl;


import com.demo.mapper.BankCardMapper;
import com.demo.pojo.BankCard;
import com.demo.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankCardServiceImpl implements BankCardService {
    @Autowired
    private BankCardMapper bankCardMapper;

    @Override
    public List<BankCard> selectBankCardAll() {
        return bankCardMapper.selectBankCardAll();
    }

    @Override
    public BankCard selectGetBankCardById(Integer id) {
        return bankCardMapper.selectGetBankCardById(id);
    }

    @Override
    public int updateBankCard(BankCard bankCard) {
        return bankCardMapper.updateBankCard(bankCard);
    }

    @Override
    public int deleteBankCard(BankCard bankCard) {
        return bankCardMapper.deleteBankCard(bankCard);
    }

    @Override
    public List<BankCard> selectBankCardById(Integer userId) {
        return bankCardMapper.selectBankCardById(userId);
    }

    @Override
    public int insertBankCard(BankCard bankCard) {
        return bankCardMapper.insertBankCard(bankCard);
    }

    @Override
    public BankCard selectUserBankCardById(Integer id) {
        return bankCardMapper.selectUserBankCardById(id);
    }

    @Override
    public int updateUserBankCard(BankCard bankCard) {
        return bankCardMapper.updateUserBankCard(bankCard);
    }

    @Override
    public int deleteUserBankCard(BankCard bankCard) {
        return bankCardMapper.deleteUserBankCard(bankCard);
    }


}
