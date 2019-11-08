package com.myproject.learn.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.myproject.learn.dto.ColorDTO;
import com.myproject.learn.service.ColorService;
@RestController
@CrossOrigin("*")
@RequestMapping("/color")
public class ColorController {
	@Autowired
	private ColorService colorService;
	@GetMapping(value = "/getAll")
    public ResponseEntity<List<ColorDTO>> getAll(){
		   List<ColorDTO> listColors = colorService.getAllColors();
		   return new ResponseEntity<>(listColors,HttpStatus.OK);
    }
	@PostMapping(value ="/addColor")
	public ResponseEntity<ColorDTO> addColor(@RequestBody(required = false) String color) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ColorDTO colorData = mapper.readValue(color, ColorDTO.class);
		boolean exist = colorService.checkExistColor(colorData);
		ColorDTO colorResponse = new ColorDTO();
		if(!exist) colorResponse = colorService.addColor(colorData);
		else colorResponse = colorService.updateColor(colorData);
		return new ResponseEntity<>(colorResponse,HttpStatus.OK); 
	}
	@PostMapping(value = "/deleteColor")
	public ResponseEntity<Map<String,String>> deleteColor(@RequestBody int colorId){
		String response = colorService.deleteColor(colorId);
		Map<String,String> data = new HashMap<>();
		data.put("responese", response);
		return new ResponseEntity<>(data,HttpStatus.OK);
	}
}
