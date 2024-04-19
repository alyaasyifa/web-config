package com.mib.webconfig.repository;


import com.mib.webconfig.entity.VirtualAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirtualAccountRepository extends JpaRepository<VirtualAccount, Long> {

    VirtualAccount findByName(String name);
}
