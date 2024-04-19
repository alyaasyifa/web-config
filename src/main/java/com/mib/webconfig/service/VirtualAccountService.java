package com.mib.webconfig.service;

import com.mib.webconfig.entity.VirtualAccount;

import java.util.List;

public interface VirtualAccountService {
    List<VirtualAccount> showAll();
    VirtualAccount create(VirtualAccount virtualAccountEntity);
    VirtualAccount update(String name, VirtualAccount virtualAccountEntity);
    void delete (String name);

    VirtualAccount findByName(String name);

//    VirtualAccount findByVirtual(String name);
    

}
