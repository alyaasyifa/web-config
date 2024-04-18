package com.mib.webconfig.service.impl;

import com.mib.webconfig.entity.Bank;
import com.mib.webconfig.repository.BankRepository;
import com.mib.webconfig.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    private static final Logger log = LoggerFactory.getLogger(BankServiceImpl.class);

    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<Bank> showAll() { return bankRepository.findAll(); }

    @Override
    public Bank create(Bank bank){
        bankRepository.save(bank);
        return bank;
    }

    @Override
    public Bank update(String bankCode, Bank bank){
        Bank savedBank = bankRepository.findByBankCode(bankCode);
        savedBank.setBankName(bank.getBankName());
        savedBank.setBin(bank.getBin());
        bankRepository.save(savedBank);
        return savedBank;
    }

    @Override
    public void delete(String bankCode) {
        Bank bank = bankRepository.findByBankCode(bankCode);
        bankRepository.deleteById(bank.getId());
    }

    @Override
    public Bank findByBankCode(String bankCode) {
        Bank bank = bankRepository.findByBankCode(bankCode);
        return bank;
    }

}
