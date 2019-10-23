package com.myproject.learn.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.learn.dto.ColorDTO;
import com.myproject.learn.dto.SizeDTO;

@RestController
@CrossOrigin("*")
@RequestMapping("/size")
public class SizeController {
	@GetMapping(value="/getAll")
	public ResponseEntity<List<SizeDTO>> getAll(@RequestParam String pageSize,@RequestParam String curentPage){
		return null;
	}
}
