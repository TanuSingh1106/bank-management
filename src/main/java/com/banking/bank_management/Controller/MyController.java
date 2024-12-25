package com.banking.bank_management.Controller;

import com.banking.bank_management.AccountDto.AccountDto;
import com.banking.bank_management.Services.Account_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MyController {
    @Autowired
   private Account_service accountService;
    @PostMapping("/Details")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
    return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/Details/{id}")
    public ResponseEntity<AccountDto> getAccountID(@PathVariable Long id,@RequestBody AccountDto accountDto){
        return  new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    @PutMapping("/Deposit/{id}")
    public  ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double>request){
        AccountDto accountDto=accountService.depositMoney(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }
    @PutMapping("/Withdraw/{id}")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String,Double>request){
        AccountDto accountDto=accountService.withdrawMoney(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }
    @GetMapping("/GetAccount")
    public ResponseEntity<List<AccountDto>> getAllAccount() {
        List<AccountDto> account=accountService.getAllAccount();
    return  ResponseEntity.ok(account);
    }
    @DeleteMapping("/DeleteAccount/{id}")
public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted Successfully");
    }
}



