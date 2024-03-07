package com.mib.webconfig.repository;

import com.mib.webconfig.entity.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiswaRepository extends JpaRepository<Siswa,Long> {

    Siswa findByNis(String nis);
}
