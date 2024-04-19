package com.mib.webconfig.service;

import com.mib.webconfig.entity.Rekening;

import java.util.List;



public interface RekeningService {
    List<Rekening> showAll();
    Rekening create(Rekening rekening);
    Rekening update(String clientId, Rekening rekening);
    void delete(String clientId);
    Rekening findByClientId(String clientId);
}
