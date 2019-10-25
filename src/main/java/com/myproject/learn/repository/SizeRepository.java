package com.myproject.learn.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myproject.learn.dto.SizeDTO;
import com.myproject.learn.model.Size;
@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {
    @Query(value="SELECT id as ID \n"
    		+ " ,(SELECT name FROM producttype A where A.id = B.product_type) as PRODUCTTYPENAME \n"
    		+ " ,length as LENGTH \n"
    		+ " ,size_frontals as SIZE_FRONTAL \n"
    		+ " FROM size B \n"
    		+ " WHERE B.product_type IN (:producttype)"
    		+ "  \n#pageable\n",
    	  countQuery = "SELECT COUNT(*) \n"
    	  		+ " FROM size B\n"
    	  		+ " WHERE B.product_type IN (:producttype)",
    	  nativeQuery = true)
    public Page<Object[]> getListSize(@Param("producttype")List<Integer> producttype,Pageable pageable);
}
