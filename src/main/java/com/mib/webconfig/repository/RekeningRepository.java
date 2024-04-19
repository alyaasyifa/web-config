package com.mib.webconfig.repository;

import com.mib.webconfig.entity.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RekeningRepository extends JpaRepository<Rekening, Long> {
    Rekening findByClientId(String clientId);

}
