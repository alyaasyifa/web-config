package com.mib.webconfig.service.impl;

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
    public VirtualAccount update(String name, VirtualAccount virtualAccountEntity) {
        VirtualAccount savedVirtualAccount = virtualAccountRepository.findByName(name);
        if (savedVirtualAccount != null) {
            savedVirtualAccount.setFee_account(virtualAccountEntity.getFee_account());
            virtualAccountRepository.save(savedVirtualAccount);
        } else {
            log.error("Public with name {} not found.", name);
        }
        return savedVirtualAccount;
    }

    @Override
    public void delete(String name) {
        VirtualAccount virtualAccountEntity = virtualAccountRepository.findByName(name);
        if (virtualAccountEntity != null) {
            virtualAccountRepository.delete(virtualAccountEntity);
        } else {
            log.error("Public with name {} not found.", name);
        }
    }

    @Override
    public VirtualAccount findByVirtual(String name) {
        return null;
    }

    @Override
    public VirtualAccount findByName(String name) {
        return virtualAccountRepository.findByName(name);
    }



}
