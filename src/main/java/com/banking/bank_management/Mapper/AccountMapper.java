package com.banking.bank_management.Mapper;

import com.banking.bank_management.AccountDto.AccountDto;
import com.banking.bank_management.entity.Account;

public class AccountMapper {
    public static Account maptoAccount(AccountDto accountDto){
Account account=new Account(
        accountDto.getId(),
        accountDto.getName(),
        accountDto.getBalance()
);
        return account;

    };
    public static AccountDto mapToAccountDto(Account account){
    AccountDto accountDto=new AccountDto(
            account.getId(),
            account.getName(),
            account.getBalance()
    );
    return accountDto;
    }
}
