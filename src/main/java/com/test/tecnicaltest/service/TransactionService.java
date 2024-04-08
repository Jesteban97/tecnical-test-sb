package com.test.tecnicaltest.service;

import com.test.tecnicaltest.Repository.AccountRepository;
import com.test.tecnicaltest.Repository.TransactionRepository;
import com.test.tecnicaltest.entity.Account;
import com.test.tecnicaltest.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    public TransactionRepository transactionRepositoryRepository;

    public List<Transaction> getTransaction() {
        return transactionRepositoryRepository.findAll();
    }
    public Optional<Transaction> getTransactionById(int id) {
        return transactionRepositoryRepository.findById(id);
    }
    public Transaction saveOrUpdate(Transaction transaction) {
        transactionRepositoryRepository.save(transaction);
        return transaction;
    }
    public void deleteTransactionById(int id) {
        transactionRepositoryRepository.deleteById(id);
    }
}
