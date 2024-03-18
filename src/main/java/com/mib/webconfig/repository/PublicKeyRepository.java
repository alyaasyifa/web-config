package com.mib.webconfig.repository;

import com.mib.webconfig.entity.PublicKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicKeyRepository extends JpaRepository<PublicKey, Long> {
    PublicKey findByName(String name);
}


