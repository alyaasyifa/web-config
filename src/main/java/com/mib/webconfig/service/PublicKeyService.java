package com.mib.webconfig.service;

import com.mib.webconfig.entity.PublicKey;


import java.util.List;

public interface PublicKeyService {

    List<PublicKey> showAll();
    PublicKey create(PublicKey publicEntity);
    PublicKey update(String name, PublicKey publicEntity);
    void delete (String name);

    PublicKey findByPublic(String name);

    PublicKey findByName(String name);
}
