package com.myproject.learn.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
			Integer colorId = Integer.parseInt(listProductType.get(i).getColorId());
			listProductType.get(i).setKey(String.valueOf(i));
			Object color = colorRepo.getColorById(colorId);
			Object[] colorValues =  (Object[]) color;
			listProductType.get(i).setColorName(colorValues[1].toString());
		}
		return listProductType;
	}
	@Transactional
	@Override
	public ProductTypeDTO addProductType(ProductTypeDTO pt) {
		// TODO Auto-generated method stub
		productTypeRepo.addProductType(pt.getProductTypeName(),pt.getProductTypeDes(),pt.getColorId());
		return pt;
	}
	@Transactional
	@Override
	public ProductTypeDTO updateProductType(ProductTypeDTO pt) {
		// TODO Auto-generated method stub
		productTypeRepo.updateProductType(pt.getProductTypeName(), pt.getProductTypeDes(), Integer.parseInt(pt.getProductTypeId()),pt.getColorId());
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

}
