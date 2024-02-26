package com.mib.webconfig.service;

import com.mib.webconfig.entity.MasterProductCodeEnitity;

import java.util.List;

public interface MasterProductCodeService {
    List<MasterProductCodeEnitity> showAll();
    MasterProductCodeEnitity create(MasterProductCodeEnitity masterProductCodeEnitity);
    MasterProductCodeEnitity update(Long productId, MasterProductCodeEnitity masterProductCodeEnitity);
    void delete (Long id);
}
