package com.test.tecnicaltest.service;

import com.test.tecnicaltest.entity.Account;
import com.test.tecnicaltest.entity.Client;
import com.test.tecnicaltest.entity.Transaction;
import com.test.tecnicaltest.entity.TypeTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    @Autowired
    private ClientService clientService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;

    public String rechargeWallet(String document, String cell, double amount) {
        Client client = clientService.findByDocumentAndCell(document, cell);
        if (client == null) {
            return "Cliente no encontrado.";
        }
        Account accountCLient = accountService.findAccountByClientId(client);
        double currentBalance = accountCLient.getBalance();
        accountCLient.setBalance(currentBalance + amount);
        accountService.saveOrUpdate(accountCLient);
        Transaction transaction = new Transaction();
        transaction.setAccount(accountCLient);
        transaction.setTypeTransaction(TypeTransaction.recarga);
        transaction.setAmount(amount);
        transaction.setDescription("Compra realizada");

        return "Recarga exitosa. Nuevo saldo: " + accountCLient.getBalance();
    }

    public String getWalletBalance(String document, String cell) {
        Client client = clientService.findByDocumentAndCell(document, cell);
        if (client == null) {
            return "Cliente no encontrado.";
        }

        Account accountCLient = accountService.findAccountByClientId(client);
        if (accountCLient == null) {
            return "La cuenta del cliente no está disponible.";
        }

        return "Saldo de la billetera: " + accountCLient.getBalance();
    }

    public String confirmPurchase(String document, String cell, String confirmationCode, double amount) {
        Client client = clientService.findByDocumentAndCell(document, cell);
        if (client == null) {
            return "Cliente no encontrado.";
        }

        Account account = accountService.findAccountByClientId(client);
        if (account == null) {
            return "No se encontró la cuenta asociada al cliente.";
        }
        if (!isValidConfirmationCode(confirmationCode)) {
            return "Código de confirmación no válido.";
        }
        if (account.getBalance() < amount) {
            return "Saldo insuficiente en la cuenta para realizar la compra.";
        }
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setTypeTransaction(TypeTransaction.compra);
        transaction.setAmount(amount);
        transaction.setDescription("Compra realizada");
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        transactionService.saveOrUpdate(transaction);
        accountService.saveOrUpdate(account);

        return "Compra realizada exitosamente. Nuevo saldo: " + newBalance;
    }

    private boolean isValidConfirmationCode(String confirmationCode) {
        return true;
    }
}
