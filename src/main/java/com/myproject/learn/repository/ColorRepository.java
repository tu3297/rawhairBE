package com.myproject.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.learn.model.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
	@Query(value="SELECT \n"
			+ " id AS ID \n"
			+ ",name AS COLOR_NAME \n"
			+ " FROM color",nativeQuery = true)
	List<Object> getAllColors();
}
