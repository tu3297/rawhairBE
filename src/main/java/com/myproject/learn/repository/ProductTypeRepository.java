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
    		          + " ,name AS PTNAME \n"
    		          + " ,description AS PTDESCRIPTION \n"
    		          + " ,color AS COLOR"
    		          + " FROM producttype", nativeQuery = true)
    List<Object[]> getListProductType();
    
    @Modifying
	@Query(value = "INSERT INTO producttype( \n"
			+ " name \n"
			+ " ,description"
			+ " ,color) \n"
			+ " VALUES (:name,:description,:colorId) \n",nativeQuery=true)
	void addProductType(@Param("name") String name,@Param("description") String description,@Param("colorId") String colorId);
    
    @Modifying
	@Query(value = "UPDATE producttype \n"
			+ " SET name =:name , description =:description , color =:colorId \n"
			+ " WHERE id =:id",nativeQuery = true)
	void updateProductType(@Param("name") String name,@Param("description") String description ,@Param("id") int id,@Param("colorId") String colorId);
    
    @Modifying
	@Query(value = "DELETE \n"
			+ " FROM producttype \n"
			+ " WHERE id IN :listId",nativeQuery = true)
	void deleteProductType(@Param("listId") List<Integer> listId);
    
    @Query(value ="",nativeQuery = true)
    
}
