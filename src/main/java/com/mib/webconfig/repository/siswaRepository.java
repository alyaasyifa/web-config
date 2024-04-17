package com.mib.webconfig.repository;

import com.mib.webconfig.entity.siswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface siswaRepository extends JpaRepository<siswa,Long> {

    siswa findByNis(String nis);
}
