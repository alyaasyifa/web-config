package com.mib.webconfig.service;

import com.mib.webconfig.entity.siswa;

import java.util.List;

public interface siswaService {

    List<siswa> showAll();
    siswa create(siswa siswa);
    siswa update(String nis, siswa siswa);
    void delete (String nis);

    siswa findByNis(String nis);
}
