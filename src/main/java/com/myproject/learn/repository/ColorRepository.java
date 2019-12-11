package com.myproject.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.learn.dto.ColorDTO;
import com.myproject.learn.model.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
	@Query(value="SELECT \n"
			+ " CONVERT(id,char) AS COLOR_ID \n"
			+ " ,name AS COLOR_NAME \n"
			+ " ,code AS COLOR_CODE \n"
			+ " FROM color",nativeQuery = true)
	List<Object[]> getAllColors();
	@Modifying
	@Query(value = "INSERT INTO color( \n"
			+ " name \n"
			+ " ,code) \n"
			+ " VALUES (:name,:code) \n",nativeQuery=true)
	void addColor(@Param("name") String name,@Param("code") String code);

	@Query(value = "SELECT COUNT(*) \n"
			+ " FROM color \n"
			+ " WHERE id =:id",nativeQuery = true)
	int checkExistColor(@Param("id") int idColor);
	@Modifying
	@Query(value = "UPDATE color \n"
			+ " SET code =:code , name =:name \n"
			+ " WHERE id =:id",nativeQuery = true)
	void updateColor(@Param("code") String code,@Param("name") String name ,@Param("id") int id);
	
	@Modifying
	@Query(value = "DELETE \n"
			+ " FROM color \n"
			+ " WHERE id =:colorId",nativeQuery = true)
	void deleteColor(@Param("colorId") int colorId);
	
	@Query(value = "SELECT code AS CODE \n"
			+ "  ,name AS NAME \n"
			+ "  FROM color \n"
			+ " WHERE id =:id",nativeQuery = true)
	Object getColorById(@Param("id") Integer id);
	
	@Query(value = "SELECT id AS ID \n"
			+ " ,code AS CODE \n"
			+ " ,name AS NAME \n"
			+ " FROM color \n"
			+ " WHERE id IN (SELECT color_id FROM producttypecolor WHERE pt_id =:productTypeId)", nativeQuery = true)
	List<Object[]> getListColorOfProductType(@Param("productTypeId") Integer productTypeId);
}
