package com.banking.bank_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Customer_details")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private Double balance;







    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getBalance() {

        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public Account(long id, String name, Double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public Account(){

    }

}
