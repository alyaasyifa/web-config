package com.mib.webconfig.service.impl;

import com.mib.webconfig.entity.Product;
import com.mib.webconfig.repository.ProductRepository;
import com.mib.webconfig.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> showAll() { return productRepository.findAll(); }

    @Override
    public Product create(Product product){
        productRepository.save(product);
        return product;
    }

    @Override
    public Product update(String productCode, Product product){
        Product savedProduct = productRepository.findByProductCode(productCode);
        savedProduct.setAgregatorName(product.getAgregatorName());
        savedProduct.setProductName(product.getProductName());
        savedProduct.setFee(product.getFee());
        productRepository.save(savedProduct);
        return savedProduct;
    }

    @Override
    public void delete(String productCode){
        Product product = productRepository.findByProductCode(productCode);
        productRepository.deleteById(product.getId());
    }

    @Override
    public Product findByProductCode(String productCode){
        Product product = productRepository.findByProductCode(productCode);
        return product;
    }

}
