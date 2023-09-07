package com.afs.restapi.repository;

import com.afs.restapi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByAccountEmailAndAccountPassword(String email, String password);
    Account findByAccountId(Long id);

}
