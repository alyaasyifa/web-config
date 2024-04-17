package com.mib.webconfig.service.impl;

import com.mib.webconfig.entity.siswa;
import com.mib.webconfig.service.siswaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class siswaServiceImpl implements siswaService {

    private static final Logger log = LoggerFactory.getLogger(siswaServiceImpl.class);

    @Autowired
    private com.mib.webconfig.repository.siswaRepository siswaRepository;
    @Override
    public List<siswa> showAll() {
        return siswaRepository.findAll();
    }

    @Override
    public siswa create(siswa siswa) {
        siswaRepository.save(siswa);
        return siswa;
    }

    @Override
    public siswa update(String nis, siswa siswa) {
        com.mib.webconfig.entity.siswa savedSiswa = siswaRepository.findByNis(nis);
        savedSiswa.setNamaSiswa(siswa.getNamaSiswa());
        siswaRepository.save(savedSiswa);
        return savedSiswa;
    }

    @Override
    public void delete(String nis) {
        siswa siswa = siswaRepository.findByNis(nis);
        siswaRepository.deleteById(siswa.getId());
    }

    @Override
    public siswa findByNis(String nis) {
        siswa siswa = siswaRepository.findByNis(nis);
        return siswa;
    }
}
