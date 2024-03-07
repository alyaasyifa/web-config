package com.mib.webconfig.service.impl;

import com.mib.webconfig.entity.Jurusan;
import com.mib.webconfig.entity.Siswa;
import com.mib.webconfig.repository.SiswaRepository;
import com.mib.webconfig.service.SiswaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiswaServiceImpl implements SiswaService {

    private static final Logger log = LoggerFactory.getLogger(SiswaServiceImpl.class);

    @Autowired
    private SiswaRepository siswaRepository;
    @Override
    public List<Siswa> showAll() {
        return siswaRepository.findAll();
    }

    @Override
    public Siswa create(Siswa siswa) {
        siswaRepository.save(siswa);
        return siswa;
    }

    @Override
    public Siswa update(String nis, Siswa siswa) {
        Siswa savedSiswa = siswaRepository.findByNis(nis);
        savedSiswa.setNamaSiswa(siswa.getNamaSiswa());
        siswaRepository.save(savedSiswa);
        return savedSiswa;
    }

    @Override
    public void delete(String nis) {
        Siswa siswa = siswaRepository.findByNis(nis);
        siswaRepository.deleteById(siswa.getId());
    }

    @Override
    public Siswa findByNis(String nis) {
        Siswa siswa = siswaRepository.findByNis(nis);
        return siswa;
    }
}
