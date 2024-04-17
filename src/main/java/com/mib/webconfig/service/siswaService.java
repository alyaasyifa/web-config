package com.mib.webconfig.service;

import com.mib.webconfig.entity.Siswa;

import java.util.List;

public interface SiswaService {

    List<Siswa> showAll();
    Siswa create(Siswa siswa);
    Siswa update(String nis, Siswa siswa);
    void delete (String nis);

    Siswa findByNis(String nis);
}
