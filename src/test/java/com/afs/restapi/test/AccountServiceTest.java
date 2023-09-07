package com.afs.restapi.test;

import com.afs.restapi.entity.Account;
import com.afs.restapi.mappers.account.AccountMapper;
import com.afs.restapi.mappers.account.AccountRequest;
import com.afs.restapi.repository.AccountRepository;
import com.afs.restapi.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        accountService = new AccountService(accountRepository, new AccountMapper());
    }

    @Test
    public void should_create_account() {
        AccountRequest accountRequest = new AccountRequest("John Doe", "johndoe@example.com", "password");
        Account account = new Account( "John Doe", "johndoe@example.com", "password");

        when(accountRepository.save(account)).thenReturn(account);

        accountService.create(accountRequest);

        // You can add assertions here to verify the behavior, e.g., verify that the account was created
    }

    @Test
    public void should_return_account_email_when_account_exists() {
        String email = "johndoe@example.com";
        String password = "password";
        Account account = new Account( "John Doe", email, password);

        when(accountRepository.findByAccountEmailAndAccountPassword(email, password)).thenReturn(account);

        String result = accountService.getAccountByEmail(email, password);

        assertEquals(email, result);
    }

    @Test
    public void should_return_empty_string_when_account_not_found() {
        String email = "nonexistent@example.com";
        String password = "password";

        when(accountRepository.findByAccountEmailAndAccountPassword(email, password)).thenReturn(null);

        String result = accountService.getAccountByEmail(email, password);

        assertEquals(null, result);
    }
}
