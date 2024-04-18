package com.mib.webconfig.service;

import com.mib.webconfig.entity.Bank;

import java.util.List;

public interface BankService {
    List<Bank> showAll();
    Bank create(Bank bank);
    Bank update(String bankCode, Bank bank);
    void delete(String bankCode);
    Bank findByBankCode(String bankCode);
}
