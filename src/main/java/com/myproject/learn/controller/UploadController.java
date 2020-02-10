package com.myproject.learn.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.learn.service.UploadService;
@RestController
@CrossOrigin("*")
@RequestMapping
public class UploadController {
	 private static String UPLOADED_FOLDER = "D:/RawHair/BE/rawhairBE/src/main/resources/static/images";
	 @Autowired
	 private UploadService uploadService;
	 @Autowired
	 private ResourceLoader resourceLoader;
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
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
       Random rand = new Random();
	   String refKey =LocalDate.now().format(formatter).toString() + rand.nextLong();
       uploadService.uploadImage(name, idProduct ,refKey);    
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
   @GetMapping(value ="/getImage")
   @ResponseBody
   public ResponseEntity<Resource> getImage(@RequestParam String image) {
	    try {
	    	Resource fileResource = resourceLoader.getResource("classpath:/static/" + image);
	    	File file = fileResource.getFile();
	        Path path = Paths.get(file.getAbsolutePath());
	        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
	        return ResponseEntity.ok().contentLength(file.length()).contentType(MediaType.IMAGE_JPEG).body(resource);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	} 
}
