package com.myproject.learn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.learn.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired
  private ProductService productService;
  @GetMapping(value ="/getNextId")
  ResponseEntity<?> getNextId (){
	  Map<String,String> response = new HashMap<>();
	  String id = productService.getNextId();
	  response.put("Id", id);
	  return new ResponseEntity(response, HttpStatus.OK);
  }
}
