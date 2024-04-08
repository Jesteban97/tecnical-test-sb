package com.test.tecnicaltest.service;

import com.test.tecnicaltest.Repository.AccountRepository;
import com.test.tecnicaltest.Repository.ClientRepository;
import com.test.tecnicaltest.entity.Client;
import com.test.tecnicaltest.entity.Account;
import com.test.tecnicaltest.entity.TypeAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.findById(id);
    }

    public Client saveOrUpdate(Client client) {
         client = clientRepository.save(client);
            Account account = new Account();
            account.setClientId(client);
            account.setBalance(0);
            account.setTypeAccount(TypeAccount.movil);
            accountRepository.save(account);

        return client;
    }


    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }

    public Client findByDocumentAndCell(String document, String cell) {
        return clientRepository.findByDocumentAndCell(document, cell);
    }


}
