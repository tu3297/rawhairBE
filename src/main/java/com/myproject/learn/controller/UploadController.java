package com.myproject.learn.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
@CrossOrigin("*")
@RequestMapping
public class UploadController {
	 private static String UPLOADED_FOLDER = "D://temp//";
   @PostMapping(value ="/upload")
   public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile) {
	   if (uploadfile.isEmpty()) {
           return new ResponseEntity("please select a file!", HttpStatus.OK);
       }
	   if (uploadfile.isEmpty()) {
           return new ResponseEntity("please select a file!", HttpStatus.OK);
       }
	   try {
           saveUploadedFiles(Arrays.asList(uploadfile));
       } catch (IOException e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
	   return new ResponseEntity("Successfully uploaded - " +uploadfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
   }
   private void saveUploadedFiles(List<MultipartFile> files) throws IOException {
       for (MultipartFile file : files) {

           if (file.isEmpty()) {
               continue;
           }
           byte[] bytes = file.getBytes();
           Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
           Files.write(path, bytes);
       }

   }
}