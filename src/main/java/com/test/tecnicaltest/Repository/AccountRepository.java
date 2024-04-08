package com.test.tecnicaltest.Repository;

import com.test.tecnicaltest.entity.Account;
import com.test.tecnicaltest.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByClientId(Client clientId);
}
