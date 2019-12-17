package com.myproject.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myproject.learn.model.Product;
@Repository
public interface ProductReposioty extends JpaRepository<Product, Long> {
    @Query(value = "SELECT ID \n"
    		+ " FROM product \n"
    		+ " ORDER BY ID DESC LIMIT 1 \n",nativeQuery = true)
    String getNextId();
    @Modifying
    @Query(value = "INSERT INTO product(id,color,product_type,size,price) \n"
    		+ " VALUES (:id,:color,:producttype,:size,:price) \n",nativeQuery = true)
    void saveProduct(@Param("id") String id,@Param("color") String color,@Param("producttype") String producttype,@Param("size") String size,@Param("price") String price);
}
