package com.myproject.learn.controller;

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
	public ResponseEntity<ColorDTO> addColor(@RequestBody ColorDTO color) {
		return new ResponseEntity<>(color,HttpStatus.OK); 
	}
}
