package com.demo.service.impl;


import com.demo.mapper.BankMapper;
import com.demo.pojo.Bank;
import com.demo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BankMapper bankMapper;

    @Override
    public List<Bank> selectBankAll() {
        return bankMapper.selectBankAll();
    }

    @Override
    public int addBank(Bank bank) {
        return bankMapper.addBank(bank);
    }

    @Override
    public Bank selectBankById(Integer id) {
        return bankMapper.selectBankById(id);
    }

    @Override
    public int updateBank(Bank bank) {
        return bankMapper.updateBank(bank);
    }

    @Override
    public int deleteBankById(Bank bank) {
        return bankMapper.deleteBankById(bank);
    }
}
