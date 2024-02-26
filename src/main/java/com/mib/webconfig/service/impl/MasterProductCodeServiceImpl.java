package com.mib.webconfig.service.impl;

import com.mib.webconfig.entity.MasterProductCodeEnitity;
import com.mib.webconfig.repository.MasterProductCodeRepository;
import com.mib.webconfig.service.MasterProductCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterProductCodeServiceImpl implements MasterProductCodeService {
    private final MasterProductCodeRepository repository;

    public MasterProductCodeServiceImpl(MasterProductCodeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MasterProductCodeEnitity> showAll() {
        return repository.findAll();
    }

    @Override
    public MasterProductCodeEnitity create(MasterProductCodeEnitity masterProductCodeEnitity) {
        return repository.save(masterProductCodeEnitity);
    }

    @Override
    public MasterProductCodeEnitity update(Long productId,MasterProductCodeEnitity data) {
        MasterProductCodeEnitity productExist = repository.findById(productId).orElseThrow(()
                -> new RuntimeException("Product Id Tidak ada"));
        productExist.setProduct_code(data.getProduct_code());
        productExist.setInput_by(data.getInput_by());
        productExist.setInput_date(data.getInput_date());
        productExist.setModify_by(data.getModify_by());
        productExist.setMofify_date(data.getMofify_date());

        return repository.save(productExist);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
