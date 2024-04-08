package com.test.tecnicaltest.service;

import com.test.tecnicaltest.Repository.AccountRepository;
import com.test.tecnicaltest.entity.Account;
import com.test.tecnicaltest.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired private AccountRepository accountRepository;

    public List<Account> getAccount() {
        return accountRepository.findAll();
    }
    public Optional<Account> getAccountById(int id) {
        return accountRepository.findById(id);
    }
    public Account saveOrUpdate(Account account) {
        accountRepository.save(account);
        return account;
    }
    public void deleteAccountById(int id) {
        accountRepository.deleteById(id);
    }
    public Account findAccountByClientId(Client clientId) {
        return accountRepository.findByClientId(clientId);
    }
}
