package com.myproject.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myproject.learn.model.Product;
@Repository
public interface ProductReposioty extends JpaRepository<Product, Long> {
    @Query(value = "SELECT ID \n"
    		+ " FROM product \n"
    		+ " ORDER BY ID DESC LIMIT 1 \n",nativeQuery = true)
    String getNextId();
}
