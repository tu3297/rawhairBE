package com.myproject.learn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.myproject.learn.dto.ProductTypeDTO;
import com.myproject.learn.dto.SizeDTO;
import com.myproject.learn.service.sizeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/size")
public class SizeController {
	@Autowired
	private sizeService sizeService;
	@GetMapping(value="/getAll")
	public ResponseEntity<List<SizeDTO>> getAll(@RequestParam String pageSize,@RequestParam String curentPage,@RequestParam String productType){
		List<SizeDTO> response = sizeService.getListSize(Integer.parseInt(pageSize), Integer.parseInt(curentPage), productType);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@PostMapping("/addSize")
	public ResponseEntity<SizeDTO> addSize(@RequestBody String size) throws JsonParseException, JsonMappingException, IOException {
	     return null;
	}
}
