package com.mib.webconfig.service;

import com.mib.webconfig.entity.Guru;

import java.util.List;

public interface GuruService {
    List<Guru> showAll();
    Guru create(Guru guru);
    Guru update(String kodeGuru, Guru guru);
    void delete (String kodeGuru);
    Guru findByKodeGuru(String kodeGuru);
}
