package com.afs.restapi.mappers;

import com.afs.restapi.entity.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountMapper(){

    }
    public Account toEntity(AccountRequest accountRequest){
        Account account = new Account();
        BeanUtils.copyProperties(accountRequest, account);
        return account;
    }
    public AccountResponse toResponse(Account account) {
        AccountResponse accountResponse = new AccountResponse();
        BeanUtils.copyProperties(account, accountResponse);
        return accountResponse;
    }
}
