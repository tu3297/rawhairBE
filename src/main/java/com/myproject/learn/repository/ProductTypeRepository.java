package com.myproject.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myproject.learn.model.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long>{
    @Query(value = " SELECT id AS ID \n"
    		+ " name AS PTNAME \n"
    		+ " description AS PTDESCRIPTION \n"
    		+ " FROM producttype", nativeQuery = true)
    List<Object[]> getListProductType();
    
    @Modifying
	@Query(value = "INSERT INTO producttype( \n"
			+ " name \n"
			+ " ,description) \n"
			+ " VALUES (:name,:description) \n",nativeQuery=true)
	void addProductType(@Param("name") String name,@Param("description") String description);
}