package com.mib.webconfig.service.impl;

import com.mib.webconfig.entity.Guru;
import com.mib.webconfig.repository.GuruRepository;
import com.mib.webconfig.service.GuruService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuruServiceImpl implements GuruService {

    private static final Logger log = LoggerFactory.getLogger(GuruServiceImpl.class);

    @Autowired
    private GuruRepository guruRepository;

    @Override
    public List<Guru> showAll() { return guruRepository.findAll(); }

    @Override
    public Guru create(Guru guru){
        guruRepository.save(guru);
        return guru;
    }

    @Override
    public Guru update(String kodeGuru, Guru guru) {
        Guru savedGuru = guruRepository.findByKodeGuru(kodeGuru);
        savedGuru.setNamaGuru(guru.getNamaGuru());
        guruRepository.save(savedGuru);
        return savedGuru;
    }

    @Override
    public void delete(String kodeGuru) {
        Guru guru = guruRepository.findByKodeGuru(kodeGuru);
        guruRepository.deleteById(guru.getId());
    }

    @Override
    public Guru findByKodeGuru(String kodeGuru) {
        Guru guru = guruRepository.findByKodeGuru(kodeGuru);
        return guru;
    }

}
