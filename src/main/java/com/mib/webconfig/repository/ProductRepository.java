package com.mib.webconfig.repository;

import com.mib.webconfig.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductCode(String productCode);
}
