package com.myproject.learn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.myproject.learn.dto.ListProductTypeDTO;
import com.myproject.learn.dto.ProductTypeDTO;
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
		ListProductTypeDTO ptData = mapper.readValue(productType, ListProductTypeDTO.class);
		List<ProductTypeDTO> data = ptData.getDataSource();
		for(ProductTypeDTO ptDTO : data) {
			String isEdit = ptDTO.getEditing() == null ? "" : ptDTO.getEditing() ;
			String id = ptDTO.getProductTypeId();
			if(id.equals("")) {
				productTypeService.addProductType(ptDTO);
			} else if (isEdit.equals("true")) {
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
}
