package com.afs.restapi.service;

import com.afs.restapi.entity.Account;
import com.afs.restapi.mappers.account.AccountMapper;
import com.afs.restapi.mappers.account.AccountRequest;
import com.afs.restapi.mappers.account.AccountResponse;
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

    public AccountResponse getAccountByEmail(String name) {
        Account account = accountRepository.findByAccountEmail(name);
        return accountMapper.toResponse(account);
    }
}
