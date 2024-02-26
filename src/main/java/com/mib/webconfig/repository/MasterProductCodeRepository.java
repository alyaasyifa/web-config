package com.mib.webconfig.repository;

import com.mib.webconfig.entity.MasterProductCodeEnitity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterProductCodeRepository extends JpaRepository<MasterProductCodeEnitity, Long> {

}
