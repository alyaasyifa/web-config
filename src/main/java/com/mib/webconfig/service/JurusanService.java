package com.mib.webconfig.service;

import com.mib.webconfig.entity.Jurusan;

import java.util.List;

public interface JurusanService {

    List<Jurusan> showAll();
    Jurusan create(Jurusan jurusan);
    Jurusan update(String kodeJurusan, Jurusan jurusan);
    void delete (String kodeJurusan);

    Jurusan findByKodeJurusan(String kodeJurusan);
}
