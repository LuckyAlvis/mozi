package com.dai.mozi.account.controller;

import com.dai.mozi.account.entity.Account;
import com.dai.mozi.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    /**
     * 获取所有账单列表
     * @param account
     */
    @GetMapping("/all")
    public List<Account> getAccountList(Account account) {
        return accountService.getAccountList();
    }

    /**
     * 新增一笔记账记录
     * @param account
     */
    @PostMapping("/addAccount")
    public Integer addAccount(Account account) {
        return accountService.addAccount(account);
    }

    /**
     * 保存一笔记账记录
     * @param account
     */
    @PostMapping("/saveAccount")
    public String saveAccount(Account account) {
        Integer result = accountService.saveAccount(account);
        if (result > 0) {
            return "修改成功";
        }
        else return "修改失败";
    }

    /**
     * 删除一笔记账记录
     * @param id
     */
    @PostMapping("/deleteAccount")
    public String deleteAccount(Integer id) {
        Integer result = accountService.deleteAccount(id);
        if (result > 0) {
            return "删除成功";
        }
        else return "删除失败";
    }

    /**
     * 查询一笔记账记录
     * @param id
     */
    @PostMapping("/selectAccount")
    public Account selectAccount(Integer id) {
        return accountService.selectAccount(id);
    }
}
