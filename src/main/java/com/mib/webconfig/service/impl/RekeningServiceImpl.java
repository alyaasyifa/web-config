package com.mib.webconfig.service.impl;

import com.mib.webconfig.entity.Rekening;
import com.mib.webconfig.repository.RekeningRepository;
import com.mib.webconfig.service.RekeningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RekeningServiceImpl implements RekeningService {

    private static final Logger log = LoggerFactory.getLogger(RekeningServiceImpl.class);

    @Autowired
    private RekeningRepository rekeningRepository;

    @Override
    public List<Rekening> showAll() { return rekeningRepository.findAll(); }

    @Override
    public Rekening create(Rekening rekening){
        rekeningRepository.save(rekening);
        return rekening;
    }

    @Override
    public Rekening update(String clientId, Rekening rekening){
        Rekening savedRekening = rekeningRepository.findByClientId(clientId);
        savedRekening.setClientId(rekening.getClientId());
        savedRekening.setNoRekening(rekening.getNoRekening());
        rekeningRepository.save(savedRekening);
        return savedRekening;
    }

    @Override
    public void delete(String clientId){
        Rekening rekening = rekeningRepository.findByClientId(clientId);
        rekeningRepository.deleteById(rekening.getId());
    }

    @Override
    public Rekening findByClientId(String clientId){
        Rekening rekening = rekeningRepository.findByClientId(clientId);
        return rekening;
    }
}
