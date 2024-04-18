package com.mib.webconfig.service.impl;


import com.mib.webconfig.entity.Movie;
import com.mib.webconfig.entity.Multibiller;
import com.mib.webconfig.repository.MultibillerRepository;
import com.mib.webconfig.service.MultibillerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultibillerServiceImpl implements MultibillerService {
    private static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MultibillerRepository multibillerRepository;

    @Override
    public List<Multibiller> showAll() {
        return multibillerRepository.findAll();
    }

    @Override
    public Multibiller create(Multibiller multibiller) {
        multibillerRepository.save(multibiller);
        return multibiller;
    }

    @Override
    public Multibiller update(String name, Multibiller multibiller) {
        Multibiller savedMultibiller = multibillerRepository.findByName(name);
        savedMultibiller.setPrefix(multibiller.getPrefix());
        savedMultibiller.setFeeAccount(multibiller.getFeeAccount());
        savedMultibiller.setDestinationAccount(multibiller.getDestinationAccount());
        savedMultibiller.setFee(multibiller.getFee());
        multibillerRepository.save(savedMultibiller);
        return savedMultibiller;
    }

    @Override
    public void delete(String name) {
        Multibiller multibiller = multibillerRepository.findByName(name);
        multibillerRepository.deleteById(multibiller.getId());
    }

    @Override
    public Multibiller findByName(String name) {
        return multibillerRepository.findFirstByName(name);
    }
}
