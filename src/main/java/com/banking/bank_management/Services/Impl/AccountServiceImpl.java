package com.banking.bank_management.Services.Impl;

import com.banking.bank_management.AccountDto.AccountDto;
import com.banking.bank_management.Mapper.AccountMapper;
import com.banking.bank_management.Repository.AccountRepo;
import com.banking.bank_management.Services.Account_service;
import com.banking.bank_management.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements Account_service {
    @Autowired
    private AccountRepo accountRepo;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.maptoAccount(accountDto);
        Account savedAccount=accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account=accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account doesn't Exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto depositMoney(Long id, double Amount) {
       Account account=accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account doesn't Exist"));
       Double total=account.getBalance()+Amount;
       account.setBalance(total);
       Account savedAccount= accountRepo.save(account);
       return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public AccountDto withdrawMoney(Long id, double Amount) {
        Account account=accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account doesn't Exist"));
        if(account.getBalance()<Amount){
            throw new RuntimeException("Insufficient balance");
        }
        Double total=account.getBalance()-Amount;
        account.setBalance(total);
        Account savedAccount=accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> accounts=accountRepo.findAll();

       return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account=accountRepo.findById(id).orElseThrow(()-> new RuntimeException("Account doesn't exist"));
        accountRepo.deleteById(id);
    }

}
