package com.mib.webconfig.service.impl;

import com.mib.webconfig.entity.Bank;
import com.mib.webconfig.entity.Multibiller;
import com.mib.webconfig.entity.VirtualAccount;
import com.mib.webconfig.repository.VirtualAccountRepository;
import com.mib.webconfig.service.VirtualAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VirtualAccountServiceImpl implements VirtualAccountService {


    private static final Logger log = LoggerFactory.getLogger(PublicKeyServiceImpl.class);

    @Autowired
    private VirtualAccountRepository virtualAccountRepository;

    @Override
    public List<VirtualAccount> showAll() {
        return virtualAccountRepository.findAll();
    }

    @Override
    public VirtualAccount create(VirtualAccount virtualAccountEntity) {
        virtualAccountRepository.save(virtualAccountEntity);
        return virtualAccountEntity;
    }


    @Override
    public VirtualAccount update(String name, VirtualAccount virtualAccount) {
        VirtualAccount savedVirtualAccount = virtualAccountRepository.findByName(name);
        savedVirtualAccount.setPrefix(virtualAccount.getPrefix());
        savedVirtualAccount.setFeeAccount(virtualAccount.getFeeAccount());
        savedVirtualAccount.setDestinationAccount(virtualAccount.getDestinationAccount());
        savedVirtualAccount.setFee(virtualAccount.getFee());
        virtualAccountRepository.save(savedVirtualAccount);
        return savedVirtualAccount;
    }


    @Override
    public void delete(String name) {
        VirtualAccount virtualAccount = virtualAccountRepository.findByName(name);
        virtualAccountRepository.deleteById(virtualAccount.getId());
    }


    @Override
    public VirtualAccount findByName(String name) {
        VirtualAccount virtualAccount = virtualAccountRepository.findByName(name);
        return virtualAccount;
    }



}
