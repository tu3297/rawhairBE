package com.myproject.learn.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.learn.service.UploadService;
@RestController
@CrossOrigin("*")
@RequestMapping
public class UploadController {
	 private static String UPLOADED_FOLDER = "D://learn//rawhairBE//src//main//resources//static//images";
	 @Autowired
	 private UploadService uploadService;
   @PostMapping(value ="/upload")
   public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile,@RequestParam("id") String idProduct) throws IOException {
	   if (uploadfile.isEmpty()) {
           return new ResponseEntity("please select a file!", HttpStatus.OK);
       }
	   if (uploadfile.isEmpty()) {
           return new ResponseEntity("please select a file!", HttpStatus.OK);
       }
       saveUploadedFiles(Arrays.asList(uploadfile));
       String name = uploadfile.getOriginalFilename();

       uploadService.uploadImage(name, idProduct);
	   return new ResponseEntity(name, new HttpHeaders(), HttpStatus.OK);
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
