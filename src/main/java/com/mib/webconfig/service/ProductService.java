package com.mib.webconfig.service;

import com.mib.webconfig.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> showAll();
    Product create(Product product);
    Product update(String productCode, Product product);
    void  delete(String productCode);
    Product findByProductCode(String productCode);
}
