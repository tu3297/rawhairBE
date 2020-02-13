package com.myproject.learn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.learn.dto.ListProductTypeRC;
import com.myproject.learn.dto.ProductTypeColorDTO;
import com.myproject.learn.dto.ProductTypeDTO;
import com.myproject.learn.dto.ProductTypeHome;
import com.myproject.learn.service.ProductTypeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/prt")
public class ProductTypeController {
	@Autowired
	private ProductTypeService productTypeService;
	@PostMapping(value="/addProductType")
	public ResponseEntity<ProductTypeDTO> addProductType(@RequestBody String productType) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		ListProductTypeRC ptData = mapper.readValue(productType, ListProductTypeRC.class);
		List<ProductTypeDTO> data = ptData.getDataSource();
		for(ProductTypeDTO ptDTO : data) {
			String isEdit = ptDTO.getEditing() == null ? "" : ptDTO.getEditing() ;
			String id = ptDTO.getProductTypeId();
			if(id.equals("")) {
				productTypeService.addProductType(ptDTO);
			} else {
				productTypeService.updateProductType(ptDTO);
			}
		}
		return new ResponseEntity<>(new ProductTypeDTO(),HttpStatus.OK); 
	}
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<ProductTypeDTO>> getAll(){
		List<ProductTypeDTO> listProductType = productTypeService.getListProductType();
		return new ResponseEntity<>(listProductType,HttpStatus.OK);
	}
	@PostMapping(value = "/deleteProductType")
	public ResponseEntity<Map<String,String>> deleteProductType (@RequestBody String listId){
		Map<String,String> data = new HashMap<>();
		List<Integer> ids  = new ArrayList<>(Arrays.asList((listId.substring(1,listId.length()-1).split((","))))).stream().map(Integer::parseInt).collect(Collectors.toList());
		String response = productTypeService.deleteProductType(ids);
		data.put("responese", response);
		return new ResponseEntity<>(data,HttpStatus.OK);
	}
	@PostMapping(value = "/updateProductTypeColor")
	public ResponseEntity<Map<String,String>> updateProductTypeColor(@RequestBody String data) {
		 Map<String,String> dataResponse = new HashMap<>();
		 data = data.substring(1, data.length()-1);
		 String response = productTypeService.updateProductTypeColor(data);
		 dataResponse.put("responese", response);
		 return new ResponseEntity(dataResponse  , HttpStatus.OK);
	}
	@GetMapping(value = "/getAllProductTypeColor")
	public ResponseEntity<List<ProductTypeColorDTO>> getAllProductTypeColor(){
		List<ProductTypeColorDTO> listProductTypeColor = productTypeService.getListProductTypeColor();
		return new ResponseEntity<>(listProductTypeColor,HttpStatus.OK);
	}
	@GetMapping(value ="/getProductTypeHome")
	public ResponseEntity<?> getProductTypeHome(){
		List<ProductTypeHome> listProductTypeHome = new ArrayList<>();
		listProductTypeHome = productTypeService.getProductTypeHome();
		return new ResponseEntity(listProductTypeHome , HttpStatus.OK);
	}
}
