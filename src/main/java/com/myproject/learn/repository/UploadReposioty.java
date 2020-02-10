package com.myproject.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myproject.learn.model.ImageDetail;
@Repository
public interface UploadReposioty extends JpaRepository<ImageDetail, Long> {
	@Modifying
    @Query(value ="INSERT INTO image_detail(id_product,image_url,ref_key) \n"
    		+ " VALUES (:idProduct,:path,:refkey) \n",nativeQuery = true)
    void saveImage (@Param("path") String path,@Param("idProduct") String idProduct,@Param("refkey") String refkey);
    
}
