package com.myproject.learn.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.learn.repository.ProductReposioty;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductReposioty productRepo;
	@Override
	public String getNextId() {
		// TODO Auto-generated method stub
		String lastId = productRepo.getNextId();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String currentID = "HAIR" + LocalDate.now().format(formatter).toString();
		if(lastId == null) { 
			currentID = currentID + "0001";
		}
		else if(lastId.compareTo(currentID) < 0) {
			currentID = currentID + "0001";
		} else {
			currentID = currentID + this.convertSeri(lastId);
		}
		return currentID;
	}
	public String convertSeri(String seri) {
		String result ="";
		String temp = seri.substring(12,seri.length());
		Integer tempInt = Integer.parseInt(temp);
		int numberRest = 4 - tempInt.toString().length();
		for(int i = 0 ;i < numberRest ; i++) {
			result += "0";
		}
		result += tempInt + "";
		return result;
	}

}
