package com.myproject.learn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.learn.dto.ColorDTO;
import com.myproject.learn.dto.ProductTypeDTO;
import com.myproject.learn.repository.ProductTypeRepository;

@Service
public class ProductTypeImpl implements ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepo;
	@Override
	public List<ProductTypeDTO> getListProductType() {
		// TODO Auto-generated method stub
		List<Object[]> ptData = productTypeRepo.getListProductType();
		List<ProductTypeDTO> listProductType = new ArrayList<>();
		listProductType = ptData.stream().map(pt -> new ProductTypeDTO(pt)).collect(Collectors.toList());
		return listProductType;
	}
	@Override
	public ProductTypeDTO addProductType(ProductTypeDTO pt) {
		// TODO Auto-generated method stub
		productTypeRepo.addProductType(pt.getProductTypeName(),pt.getProductTypeDes());
		return pt;
	}

}