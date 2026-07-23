package com.dn5.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContaining(String keyword);

    List<Product> findByPriceLessThan(double price);
}
