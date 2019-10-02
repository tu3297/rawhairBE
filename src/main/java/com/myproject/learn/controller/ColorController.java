package com.myproject.learn.controller;

import java.io.IOException;
import java.util.List;

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
	public ResponseEntity<ColorDTO> addColor(@RequestBody(required =false) String color) throws JsonParseException, JsonMappingException, IOException {
		//ColorDTO data = colorService.addColor(color);
		ObjectMapper mapper = new ObjectMapper();
		ColorDTO colorData = mapper.readValue(color, ColorDTO.class);
		ColorDTO colorResponse = colorService.addColor(colorData);
		return new ResponseEntity<>(colorResponse,HttpStatus.OK); 
	}
}
