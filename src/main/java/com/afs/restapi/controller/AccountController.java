package com.afs.restapi.controller;

import com.afs.restapi.mappers.account.AccountRequest;
import com.afs.restapi.mappers.account.AccountResponse;
import com.afs.restapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{accountEmail}")
    public AccountResponse getAccount(@PathVariable String accountEmail){
        return accountService.getAccountByEmail(accountEmail);
    }


}
