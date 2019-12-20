package com.myproject.learn.repository;

import java.util.List;

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
    
    @Query(value = "SELECT A.id as ID \n"
    		+ " ,B.id as PRODUCTTYPEID \n"
    		+ " ,B.name as PRODUCTNAME \n"
    		+ " ,C.id as COLORID \n"
    		+ " ,C.name as COLORNAME \n"
    		+ " ,C.code as COLORCODE \n"
    		+ " ,D.length as LENGTH \n"
    		+ " ,D.size_frontals as FRONTAL \n"
    		+ " ,A.price as PRICE \n"
    		+ " FROM product A,producttype B,color C,size D \n"
    		+ " WHERE A.product_type = B.id AND A.color = C.id AND A.size = D.id \n"
    		+ " AND (:producttype is null) OR (:producttype is not null and A.product_type IN (:producttype)) \n"
    		+ " AND (:length is null) OR (:length is not null and D.length IN (:length)) \n"
    		+ " AND (:color is null) OR (:color is not null and A.color IN (:color)) \n"
    		+ " AND (:productId is null) OR (:productId is not null and A.id like %:productId%) \n"
    		+ " LIMIT :limit OFFSET :offset",nativeQuery = true)
    List<Object[]> getAllProduct(@Param("producttype") List<String> productType,@Param("length") List<String> length,@Param("color") List<String> color
    		,@Param("productId") String productId,@Param("limit") Integer limit,@Param("offset") Integer offset);
}
