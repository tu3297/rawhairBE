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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.learn.dto.ListSizeDTO;
import com.myproject.learn.dto.ListSizeRC;
import com.myproject.learn.dto.SizeDTO;
import com.myproject.learn.dto.SizeProductDTO;
import com.myproject.learn.service.sizeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/size")
public class SizeController {
	@Autowired
	private sizeService sizeService;
	@GetMapping(value="/getAll")
	public ResponseEntity<ListSizeDTO> getAll(@RequestParam String pageSize,@RequestParam String curentPage,@RequestParam String productType){
		ListSizeDTO response = new ListSizeDTO();
		response =  sizeService.getListSize(Integer.parseInt(pageSize), Integer.parseInt(curentPage), productType);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@PostMapping("/addSize")
	public ResponseEntity<SizeDTO> addSize(@RequestBody String size) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ListSizeRC sizeData = mapper.readValue(size, ListSizeRC.class);
		List<SizeDTO> data = sizeData.getDataSource();
		for(SizeDTO sizeDTO : data) {
			String isEdit = sizeDTO.getEditing() == null ? "" : sizeDTO.getEditing() ;
			String id = sizeDTO.getId();
			if(id.equals("")) {
				sizeService.addSize(sizeDTO);
			} else{
				sizeService.updateSize(sizeDTO);
			}
		}
		return new ResponseEntity<>(new SizeDTO(),HttpStatus.OK);
	}
	@PostMapping("/deleteSize")
	public ResponseEntity<Map<String,String>> deleteSize (@RequestBody String listId){
		Map<String,String> data = new HashMap<>();
		List<Integer> ids  = new ArrayList<>(Arrays.asList((listId.substring(1,listId.length()-1).split((","))))).stream().map(Integer::parseInt).collect(Collectors.toList());
		String response = sizeService.deleteSize(ids);
		data.put("responese", response);
		return new ResponseEntity<>(data,HttpStatus.OK);
	}
	
    @GetMapping(value="/getSizeOfProductType")
    public ResponseEntity<List<SizeProductDTO>> getSizeOfProductType(@RequestParam Integer productTypeId){
		List<SizeProductDTO> response = new ArrayList<>();
		response =  sizeService.getListSizeOfproductType(productTypeId);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
