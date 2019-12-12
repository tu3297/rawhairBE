package com.myproject.learn.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myproject.learn.model.Size;
@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {
    @Query(value="SELECT id as ID \n"
    		+ " ,product_type AS PRODUCTTYPEID"
    		+ " ,(SELECT name FROM producttype A where A.id = B.product_type) as PRODUCTTYPENAME \n"
    		+ " ,length as LENGTH \n"
    		+ " ,size_frontals as SIZE_FRONTAL \n"
    		+ " FROM size B \n"
    		+ " WHERE (:producttype is null) OR (:producttype is not null and B.product_type IN (:producttype)) \n"
    		+ " LIMIT :limit OFFSET :offset",
    	  nativeQuery = true)
    public List<Object[]> getListSize(@Param("producttype") List<Integer> producttype,@Param("limit") int pageSize,@Param("offset") int offset);
    
    @Query(value ="SELECT COUNT(*) \n"
    		+ " FROM size B \n"
    		+ " WHERE (:producttype is null) OR (:producttype is not null and B.product_type IN (:producttype))",nativeQuery = true)
    public Integer getTotal(@Param("producttype") List<Integer> producttype);
    
    @Modifying
    @Query(value ="INSERT INTO size( \n"
    		+ " length, \n"
    		+ " product_type, \n"
    		+ " size_frontals) \n"
    		+ " VALUES(:length,:product_type,:sizefrontals)",nativeQuery = true)
     void addSize(@Param("length") String length,@Param("product_type") int product_type,@Param("sizefrontals") String sizefrontals);
    @Modifying
    @Query(value="UPDATE size \n"
    		+ " SET length =:length, \n"
    		+ " product_type =:product_type,"
    		+ " size_frontals =:sizefrontals \n"
    		+ " WHERE id=:id",nativeQuery = true)
     void updateSize(@Param("length") String length,@Param("product_type") int product_type,@Param("sizefrontals") String sizefrontals,@Param("id") int id);
    @Modifying
    @Query(value ="DELETE \n" + 
    		" FROM size \n" + 
    		" WHERE id IN :listId",nativeQuery = true)
    void deleteSize(@Param("listId") List<Integer> listId);
    
    @Query(value = "SELECT id as ID \n"
    		+ " ,CASE WHEN ((SELECT B.name FROM producttype B WHERE B.id =:producttype) IN :regex) THEN null ELSE length END \n"
    		+ " ,CASE WHEN ((SELECT A.name FROM producttype A WHERE A.id =:producttype) IN :regex) THEN size_frontals ELSE null END \n"
    		+ " ,CASE WHEN ((SELECT C.name FROM producttype C WHERE C.id =:producttype) IN :regex) THEN '1' ELSE '0' END \n"
    		+ " FROM size \n"
    		+ " WHERE product_type =:producttype",nativeQuery = true)
    List<Object[]> getListSizeOfProductType(@Param("producttype") Integer producttype,@Param("regex") List<String> regex);
    
    @Query(value = "SELECT id as ID \n"
    		+ " ,size_frontals as SIZE_FRONTAL\n"
    		+ " FROM size \n"
    		+ " WHERE product_type =:producttype",nativeQuery = true)
    List<Object[]> getListSizeOfClosureOrFrontal(@Param("producttype") Integer producttype);
}
