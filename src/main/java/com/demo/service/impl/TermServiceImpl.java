package com.demo.service.impl;


import com.demo.mapper.TermMapper;
import com.demo.pojo.MyFinance.UserTerm;
import com.demo.pojo.Term;
import com.demo.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermServiceImpl implements TermService {
    @Autowired
    private TermMapper termMapper;

    @Override
    public List<Term> selectTermAll() {
        return termMapper.selectTermAll();
    }

    @Override
    public int addTerm(Term term) {
        return termMapper.addTerm(term);
    }

    @Override
    public Term selectTermById(Integer id) {
        return termMapper.selectTermById(id);
    }

    @Override
    public int updateTerm(Term term) {
        return termMapper.updateTerm(term);
    }

    @Override
    public int deleteTermById(Term term) {
        return termMapper.deleteTermById(term);
    }

    @Override
    public int addTermMoney(UserTerm userTerm) {
        return termMapper.addTermMoney(userTerm);
    }

    @Override
    public int insertFlowOfFund(UserTerm userTerm) {
        return termMapper.insertFlowOfFund(userTerm);
    }
}