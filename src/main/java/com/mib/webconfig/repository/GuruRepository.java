package com.mib.webconfig.repository;

import com.mib.webconfig.entity.Guru;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuruRepository extends JpaRepository<Guru, Long> {
    Guru findByKodeGuru(String kodeGuru);
}
