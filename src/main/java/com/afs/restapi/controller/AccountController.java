package com.afs.restapi.controller;

import com.afs.restapi.mappers.account.AccountRequest;
import com.afs.restapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public void createAccount(@RequestBody AccountRequest accountRequest){
        accountService.create(accountRequest);
    }

    @PostMapping("/login")
    public String getAccount(@RequestBody AccountRequest accountRequest){
        return accountService.getAccountByEmail(accountRequest.getAccountEmail()
                ,accountRequest.getAccountPassword());
    }

}
