package com.dai.mozi.account.service;

import com.dai.mozi.account.entity.Account;

import java.util.List;


public interface AccountService {
    List<Account> getAccountList();

    Integer addAccount(Account account);

    Integer deleteAccount(Integer id);

    Integer saveAccount(Account account);

    Account selectAccount(Integer id);

}
