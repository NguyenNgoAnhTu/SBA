package com.example.orchidbe.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name="account_id")
    private Long accountId;
    @Column(name="account_name", nullable = false)
    private String accountName;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
