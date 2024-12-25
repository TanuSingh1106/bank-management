package com.banking.bank_management.Repository;

import com.banking.bank_management.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {

}
