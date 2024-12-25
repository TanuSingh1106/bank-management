package com.banking.bank_management.Services;

import com.banking.bank_management.AccountDto.AccountDto;

import java.util.List;

public interface Account_service {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);

    AccountDto depositMoney(Long id, double Amount);

    AccountDto withdrawMoney(Long id, double Amount);
    List<AccountDto> getAllAccount();

    void deleteAccount(Long id);
}
