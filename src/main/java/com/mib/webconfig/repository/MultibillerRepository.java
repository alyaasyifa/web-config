package com.mib.webconfig.repository;


import com.mib.webconfig.entity.Multibiller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultibillerRepository extends JpaRepository<Multibiller, Long> {
    Multibiller findFirstByName(String name);

    Multibiller findByName(String name);
}
