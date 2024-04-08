package com.test.tecnicaltest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNumber;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client clientId;

    @Enumerated(EnumType.STRING)
    private TypeAccount typeAccount;

    @Column
    private double balance;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transaction;
}
