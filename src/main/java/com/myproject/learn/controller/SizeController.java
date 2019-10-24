package com.myproject.learn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.myproject.learn.dto.SizeDTO;

@RestController
@CrossOrigin("*")
@RequestMapping("/size")
public class SizeController {
	@GetMapping(value="/getAll")
	public ResponseEntity<Page<List<SizeDTO>>> getAll(@RequestParam String pageSize,@RequestParam String curentPage,@RequestParam String productType){
		Pageable pageRequest = new  PageRequest (Integer.parseInt(curentPage), Integer.parseInt(pageSize));
		Page<List<SizeDTO>> listSize = new PageImpl<>(new ArrayList<>());
		return null;
	}
}
