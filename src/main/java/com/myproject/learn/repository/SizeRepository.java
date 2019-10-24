package com.myproject.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.learn.model.Size;
@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {

}
