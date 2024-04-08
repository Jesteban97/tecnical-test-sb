package com.test.tecnicaltest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "TRANSACTIONS") // Cambiado el nombre de la tabla a "TRANSACTIONS"
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction") // Nombre explícito de la columna
    private int idTransaction;

    @Enumerated(EnumType.STRING)
    private TypeTransaction typeTransaction;

    @ManyToOne
    @JoinColumn(name = "account_number") // Cambiado el nombre de la columna para que sea coherente con la clave foránea
    private Account account;

    @Column
    private Double amount;

    @Column
    private String description;

    @Column
    private Date date;
}
