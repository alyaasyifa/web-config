package com.mib.webconfig.service.impl;

import com.mib.webconfig.entity.PublicKey;
import com.mib.webconfig.repository.PublicKeyRepository;
import com.mib.webconfig.service.PublicKeyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicKeyServiceImpl implements PublicKeyService {

    private static final Logger log = LoggerFactory.getLogger(PublicKeyServiceImpl.class);

    @Autowired
    private PublicKeyRepository publicRepository;

    @Override
    public List<PublicKey> showAll() {
        return publicRepository.findAll();
    }

    @Override
    public PublicKey create(PublicKey publicEntity) {
        publicRepository.save(publicEntity);
        return publicEntity;
    }


    @Override
    public PublicKey update(String name, PublicKey publicEntity) {
        PublicKey savedPublicKey = publicRepository.findByName(name);
        if (savedPublicKey != null) {
            savedPublicKey.setPublickey(publicEntity.getPublickey());
            publicRepository.save(savedPublicKey);
        } else {
            log.error("Public with name {} not found.", name);
        }
        return savedPublicKey;
    }

    @Override
    public void delete(String name) {
        PublicKey publicEntity = publicRepository.findByName(name);
        if (publicEntity != null) {
            publicRepository.delete(publicEntity);
        } else {
            log.error("Public with name {} not found.", name);
        }
    }

    @Override
    public PublicKey findByPublic(String name) {
        return null;
    }

    @Override
    public PublicKey findByName(String name) {
        return publicRepository.findByName(name);
    }
}

