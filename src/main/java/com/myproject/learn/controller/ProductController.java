package com.myproject.learn.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.learn.dto.ListProductTypeRC;
import com.myproject.learn.dto.ProductDTO;
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
  @PostMapping(value = "/saveProduct")
  ResponseEntity<?> saveProduct(@RequestBody String product) throws JsonParseException, JsonMappingException, IOException{
	  ObjectMapper mapper = new ObjectMapper();
	  ProductDTO productData = mapper.readValue(product, ProductDTO.class);
	  ProductDTO response = productService.saveProduct(productData);
	  if(response == null) return new ResponseEntity(null, new HttpHeaders(), HttpStatus.OK);
	  else return new ResponseEntity(productData, new HttpHeaders(), HttpStatus.OK);
  }
  @GetMapping(value = "/getAll")
  ResponseEntity<?> getAll(@RequestParam String pageSize,@RequestParam String curentPage,@RequestParam String id,@RequestParam String productType,@RequestParam String length,@RequestParam String color){
	  return new ResponseEntity(null, new HttpHeaders(), HttpStatus.OK);
  }
}
