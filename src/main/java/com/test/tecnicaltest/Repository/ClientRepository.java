package com.test.tecnicaltest.Repository;
import com.test.tecnicaltest.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

    Client findByDocumentAndCell(String document, String cell);
}
