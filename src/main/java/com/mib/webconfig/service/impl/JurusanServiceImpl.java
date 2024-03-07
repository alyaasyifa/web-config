package com.mib.webconfig.service.impl;

import com.mib.webconfig.entity.Jurusan;
import com.mib.webconfig.repository.JurusanRepository;
import com.mib.webconfig.service.JurusanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JurusanServiceImpl implements JurusanService {

    private static final Logger log = LoggerFactory.getLogger(JurusanServiceImpl.class);

    @Autowired
    private JurusanRepository jurusanRepository;

    @Override
    public List<Jurusan> showAll() {
        return jurusanRepository.findAll();
    }

    @Override
    public Jurusan create(Jurusan jurusan) {
        jurusanRepository.save(jurusan);
        return jurusan;
    }

    @Override
    public Jurusan update(String kodeJurusan, Jurusan jurusan) {
        Jurusan savedJurusan = jurusanRepository.findByKodeJurusan(kodeJurusan);
        savedJurusan.setNamaJurusan(jurusan.getNamaJurusan());
        jurusanRepository.save(savedJurusan);
        return savedJurusan;
    }

    @Override
    public void delete(String kodeJurusan) {
        Jurusan jurusan = jurusanRepository.findByKodeJurusan(kodeJurusan);
        jurusanRepository.deleteById(jurusan.getId());
    }

    @Override
    public Jurusan findByKodeJurusan(String kodeJurusan) {
        Jurusan jurusan = jurusanRepository.findByKodeJurusan(kodeJurusan);
        return jurusan;
    }

}
