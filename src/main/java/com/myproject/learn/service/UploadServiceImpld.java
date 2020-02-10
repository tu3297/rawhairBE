package com.myproject.learn.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.learn.repository.UploadReposioty;

@Service
public class UploadServiceImpld implements UploadService {
  @Autowired
  private UploadReposioty uploadRepo;

@Transactional
@Override
public String uploadImage(String path, String idProduct,String refkey) {
	// TODO Auto-generated method stub
	try {
		uploadRepo.saveImage(path, idProduct,refkey);
		return "Success";
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return "Fail";
	}
}
}
