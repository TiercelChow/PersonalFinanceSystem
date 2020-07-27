package com.demo.service;

import com.demo.pojo.BankCard;

import java.util.List;

public interface BankCardService {
    public List<BankCard> selectBankCardAll();


    public BankCard selectGetBankCardById(Integer id);

    public int updateBankCard(BankCard bankCard);

    public int deleteBankCard(BankCard bankCard);

    public List<BankCard> selectBankCardById(Integer userId);

    public int insertBankCard(BankCard bankCard);

    public BankCard selectUserBankCardById(Integer id);

    public int updateUserBankCard(BankCard bankCard);

    public int deleteUserBankCard(BankCard bankCard);
}
