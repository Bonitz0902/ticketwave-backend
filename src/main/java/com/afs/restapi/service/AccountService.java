package com.afs.restapi.service;

import com.afs.restapi.entity.Account;
import com.afs.restapi.mappers.AccountMapper;
import com.afs.restapi.mappers.AccountRequest;
import com.afs.restapi.mappers.AccountResponse;
import com.afs.restapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public void create(AccountRequest accountRequest) {
        Account account = accountMapper.toEntity(accountRequest);
        accountRepository.save(account);
    }

    public AccountResponse getAccountByName(String name) {
        Account account = accountRepository.findByAccountName(name);
        return accountMapper.toResponse(account);
    }
}
