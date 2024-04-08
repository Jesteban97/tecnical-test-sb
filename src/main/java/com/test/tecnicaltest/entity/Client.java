package com.test.tecnicaltest.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private TypeDocument typeDocument;

    @OneToMany(mappedBy = "clientId")
    private List<Account> accounts;

    @Column
    private String document;
    @Column
    private String name;
    @Column
    private String email;
    @Column(unique = true)
    private String cell;

}
