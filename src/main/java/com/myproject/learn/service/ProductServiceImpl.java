package com.myproject.learn.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.learn.dto.ProductDTO;
import com.myproject.learn.dto.ProductRC;
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
		tempInt += 1;
		int numberRest = 4 - tempInt.toString().length();
		for(int i = 0 ;i < numberRest ; i++) {
			result += "0";
		}
		result += tempInt + "";
		return result;
	}
	@Transactional
	@Override
	public ProductRC saveProduct(ProductRC product) {
		// TODO Auto-generated method stub
		try {
		productRepo.saveProduct(product.getIdProduct(), product.getIdColor(), product.getIdProductType(), product.getIdSize(), product.getPrice());
		} catch (Exception e) {
			// TODO: handle exception
		  return null;
		}
		return product;
	}
	@SuppressWarnings("unused")
	@Override
	public List<ProductDTO> getAllProduct(List<String> productType, List<String> color, List<String> length,
			Integer limit, Integer offset, String productId) {
		// TODO Auto-generated method stub
		List<Object[]> dataProduct = productRepo.getAllProduct(productType, length, color, productId, limit, offset);
		return null;
	}
}
