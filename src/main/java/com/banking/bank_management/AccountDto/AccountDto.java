package com.banking.bank_management.AccountDto;

public class AccountDto {
    private long id;
    private String name;
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

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountDto(long id, String name, Double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public AccountDto(){

    }
}
