package com.myproject.learn.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.learn.dto.ProductDTO;
import com.myproject.learn.dto.ProductRC;
import com.myproject.learn.dto.ProductypeData;
import com.myproject.learn.service.ProductService;
import com.myproject.learn.service.ProductTypeService;

@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired
  private ProductService productService;
  
  @Autowired
  private ProductTypeService ptService;
  
  @GetMapping(value ="/getData")
  ResponseEntity<?> getData (){
	  Map<String,Object> response = new HashMap<>();
	  String id = productService.getNextId();
	  List<ProductypeData> ptData = ptService.getData();
	  response.put("idProduct", id);
	  response.put("productypeData",ptData);
	  return new ResponseEntity(response, HttpStatus.OK);
  }
  @GetMapping(value ="/getProductById")
  ResponseEntity<?> getProductById (@RequestParam String idProduct){
	  Map<String,String> response = new HashMap<>();
	  ProductDTO product = productService.getProductById(idProduct);
	  return new ResponseEntity(product, HttpStatus.OK);
  }
  @PostMapping(value = "/saveProduct")
  ResponseEntity<?> saveProduct(@RequestBody String product) throws JsonParseException, JsonMappingException, IOException{
	  ObjectMapper mapper = new ObjectMapper();
	  ProductRC productData = mapper.readValue(product, ProductRC.class);
	  ProductRC response = productService.saveProduct(productData);
	  if(response == null) return new ResponseEntity(null, new HttpHeaders(), HttpStatus.OK);
	  else return new ResponseEntity(productData, new HttpHeaders(), HttpStatus.OK);
  }
  @GetMapping(value = "/getAll")
  ResponseEntity<?> getAll(@RequestParam String pageSize , @RequestParam String curentPage , @RequestParam String id , @RequestParam List<String> productType,@RequestParam List<String> length,@RequestParam List<String> color,
		  @RequestParam String sort){
	List<ProductDTO> response =  productService.getAllProduct(productType, color, length, Integer.parseInt(pageSize), Integer.parseInt(curentPage), id , sort);
	return new ResponseEntity(response, new HttpHeaders(), HttpStatus.OK);
  }
}
