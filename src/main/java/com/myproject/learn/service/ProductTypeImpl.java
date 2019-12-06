package com.myproject.learn.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.learn.dto.ProductTypeColorDTO;
import com.myproject.learn.dto.ProductTypeDTO;
import com.myproject.learn.repository.ColorRepository;
import com.myproject.learn.repository.ProductTypeRepository;

@Service
public class ProductTypeImpl implements ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepo;
    
    @Autowired
    private ColorRepository colorRepo;
	@Override
	public List<ProductTypeDTO> getListProductType() {
		// TODO Auto-generated method stub
		List<Object[]> ptData = productTypeRepo.getListProductType();
		List<ProductTypeDTO> listProductType = new ArrayList<>();
		listProductType = ptData.stream().map(pt -> new ProductTypeDTO(pt)).collect(Collectors.toList());
		for(int i = 0 ; i < listProductType.size() ; i++ ) {
			listProductType.get(i).setKey(String.valueOf(i));
		}
		return listProductType;
	}
	@Transactional
	@Override
	public ProductTypeDTO addProductType(ProductTypeDTO pt) {
		// TODO Auto-generated method stub
		productTypeRepo.addProductType(pt.getProductTypeName(),pt.getProductTypeDes());
		return pt;
	}
	@Transactional
	@Override
	public ProductTypeDTO updateProductType(ProductTypeDTO pt) {
		// TODO Auto-generated method stub
		productTypeRepo.updateProductType(pt.getProductTypeName(), pt.getProductTypeDes(), Integer.parseInt(pt.getProductTypeId()));
		return pt;
	}
	@Transactional
	@Override
	public String deleteProductType(List<Integer> listId) {
		// TODO Auto-generated method stub
		try {
		    productTypeRepo.deleteProductType(listId);
		}catch (Exception e) {
			// TODO: handle exception
			return "Fail";
		}
		return "Success";
	}
	@Transactional
	@Override
	public String updateProductTypeColor(String data) {
		// TODO Auto-generated method stub
		String productTypeId = data.split(",")[0];
		String colorId = data.split(",")[1];
		String useYn = data.split(",")[2];
		Integer isExist = this.checkExistProductTypeColor(Integer.parseInt(colorId),Integer.parseInt(productTypeId));
		try {
		 if(isExist != null) {
		    productTypeRepo.updateProductTypeColor(Integer.parseInt(colorId) , isExist , Integer.parseInt(productTypeId),useYn);
		} else {
			productTypeRepo.insertProductTypeColor(Integer.parseInt(colorId),Integer.parseInt(productTypeId));
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Fail";
		}
		return "Success";
	}
	@Override
	public Integer checkExistProductTypeColor(Integer colorId, Integer ptId) {
		// TODO Auto-generated method stub
		return productTypeRepo.checkExistProductTypeColor(colorId, ptId);
	}
	@Override
	public List<ProductTypeColorDTO> getListProductTypeColor() {
		// TODO Auto-generated method stub
		List<Object[]> data = productTypeRepo.getAllProjectTypeColor();
		List<ProductTypeColorDTO> listPTCorlor =  data.stream().map(pt -> new ProductTypeColorDTO(pt)).collect(Collectors.toList());
		return listPTCorlor;
	}

}
