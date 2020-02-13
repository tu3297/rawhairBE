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
    		          + " ,parent AS PARENT"
    		          + " FROM producttype", nativeQuery = true)
    List<Object[]> getListProductType();
    
    @Modifying
	@Query(value = "INSERT INTO producttype( \n"
			+ " name \n"
			+ " ,description"
			+ " ,parent)"
			+ " VALUES (:name,:description,:parent) \n",nativeQuery=true)
	void addProductType(@Param("name") String name,@Param("description") String description ,@Param("parent") String parent);
    
    @Modifying
	@Query(value = "UPDATE producttype \n"
			+ " SET name =:name , description =:description ,parent =:parent \n"
			+ " WHERE id =:id",nativeQuery = true)
	void updateProductType(@Param("name") String name,@Param("description") String description ,@Param("id") int id,@Param("parent") String parent);
    
    @Modifying
	@Query(value = "DELETE \n"
			+ " FROM producttype \n"
			+ " WHERE id IN :listId",nativeQuery = true)
	void deleteProductType(@Param("listId") List<Integer> listId);
    
    @Modifying
    @Query(value ="INSERT INTO producttypecolor(pt_id,color_id,use_yn) \n"
    		+ " VALUES(:ptId,:colorId, 'Y') \n",nativeQuery = true)
    void insertProductTypeColor(@Param("colorId") Integer color,@Param("ptId") Integer ptId);
    
    @Modifying
    @Query(value ="UPDATE producttypecolor \n"
    		+ " SET color_id =:color , pt_id =:ptId , use_yn = (CASE WHEN :useYn = 'false' THEN 'N' ELSE 'Y' END) \n"
    		+ " WHERE id =:id",nativeQuery = true)
    void updateProductTypeColor(@Param("color") Integer color,@Param("id") Integer id,@Param("ptId") Integer ptId ,@Param("useYn") String useYn);
    
    @Query(value ="SELECT id \n"
    		+ " FROM producttypecolor \n"
    		+ " WHERE color_id =:colorId AND pt_id =:ptId",nativeQuery = true)
    Integer checkExistProductTypeColor(@Param("colorId") Integer colorId,@Param("ptId") Integer ptId);
    
    @Query(value ="SELECT id AS ID \n"
    		+ " ,pt_id AS PTID \n"
    		+ " ,color_id AS COLORId \n"
    		+ " ,use_yn AS USE_YN"
    		+ " FROM producttypecolor",nativeQuery = true)
    List<Object[]> getAllProjectTypeColor();
    
    @Query(value ="SELECT id AS ID \n"
    		+ " name AS NAME \n"
    		+ " description AS DESCRIPTION \n"
    		+ " FROM producttype \n"
    		+ " WHERE id =:idProductType",nativeQuery = true)
    List<Object[]> getProductTypeById (@Param("idProductType") Integer idProductType);
    
    
    @Query(value="SELECT  id,\n" + 
    		"        name, \n" + 
    		"        parent\n" + 
    		" FROM    (select * from producttype\n" + 
    		"         order by parent, id) as a ,\n" + 
    		"        (select @pv\\:=:parent) as b \n" + 
    		" WHERE   find_in_set(parent, @pv) \n" + 
    		" AND     length(@pv\\:= concat(@pv, ',', id))",nativeQuery = true)
    List<Object[]> getListProductTypeHome(@Param("parent") String parent);
}
