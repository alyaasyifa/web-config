package com.mib.webconfig.repository;

import com.mib.webconfig.entity.Jurusan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JurusanRepository extends JpaRepository<Jurusan,Long> {

    Jurusan findByKodeJurusan(String kodeJurusan);
}
