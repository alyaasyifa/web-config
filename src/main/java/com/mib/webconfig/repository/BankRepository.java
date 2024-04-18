package com.mib.webconfig.repository;

import com.mib.webconfig.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank findByBankCode(String bankCode);
}
