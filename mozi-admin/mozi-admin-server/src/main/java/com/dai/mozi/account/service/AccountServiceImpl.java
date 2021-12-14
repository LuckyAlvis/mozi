package com.dai.mozi.account.service;

import com.dai.mozi.account.entity.Account;
import com.dai.mozi.account.mapper.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountDAO accountDAO;

    @Override
    public Integer addAccount(Account account) {
        return accountDAO.insertSelective(account);
    }

    @Override
    public Integer deleteAccount(Integer id) {
        return accountDAO.deleteByPrimaryKey(id);
    }

    @Override
    public Integer saveAccount(Account account) {
        return accountDAO.updateByPrimaryKeySelective(account);
    }

    @Override
    public List<Account> getAccountList() {
        List<Account> accounts = new LinkedList<>();
        accounts.add(accountDAO.selectByPrimaryKey(1));
        return accounts;
    }

    @Override
    public Account selectAccount(Integer id) {
        return accountDAO.selectByPrimaryKey(id);
    }
}
