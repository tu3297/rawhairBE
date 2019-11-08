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
    		+ " ,(SELECT name FROM producttype A where A.id = B.product_type) as PRODUCTTYPENAME \n"
    		+ " ,length as LENGTH \n"
    		+ " ,size_frontals as SIZE_FRONTAL \n"
    		+ " FROM size B \n"
    		+ " WHERE B.product_type IN :producttype"
    		+ "  \n #pageable \n",
    	  countQuery = "SELECT COUNT(*) \n"
    	  		+ " FROM size B\n"
    	  		+ " WHERE  B.product_type IN :producttype",
    	  nativeQuery = true)
    public Page<Object[]> getListSize(@Param("producttype") List<Integer> producttype,Pageable pageable);
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
    		" FROM producttype \n" + 
    		" WHERE id IN :listId",nativeQuery = true)
    void deleteSize(@Param("listId") List<Integer> listId);
}
