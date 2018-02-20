package com.privalia.repositories;

import com.privalia.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.math.BigDecimal;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findByProductIdAndPrice(String productId, BigDecimal price);
}
