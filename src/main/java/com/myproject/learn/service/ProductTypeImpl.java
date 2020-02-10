package com.myproject.learn.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.learn.dto.ColorDTO;
import com.myproject.learn.dto.ProductTypeColorDTO;
import com.myproject.learn.dto.ProductTypeDTO;
import com.myproject.learn.dto.ProductTypeHome;
import com.myproject.learn.dto.ProductypeData;
import com.myproject.learn.dto.SizeFrontalData;
import com.myproject.learn.dto.SizeProductDTO;
import com.myproject.learn.repository.ColorRepository;
import com.myproject.learn.repository.ProductTypeRepository;
import com.myproject.learn.repository.SizeRepository;

@Service
public class ProductTypeImpl implements ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepo;
    
    @Autowired
    private ColorRepository colorRepo;
    
    @Autowired
    private SizeRepository sizeRepo;
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
		if(pt.getParent() == null) pt.setParent("0");
		// TODO Auto-generated method stub
		productTypeRepo.addProductType(pt.getProductTypeName(),pt.getProductTypeDes(),pt.getParent());
		return pt;
	}
	@Transactional
	@Override
	public ProductTypeDTO updateProductType(ProductTypeDTO pt) {
		// TODO Auto-generated method stub
		if(pt.getParent() == null) pt.setParent("0");
		productTypeRepo.updateProductType(pt.getProductTypeName(), pt.getProductTypeDes(), Integer.parseInt(pt.getProductTypeId()),pt.getParent());
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
	@Override
	public ProductTypeDTO getProductTypeById(Integer productTypeId) {
		// TODO Auto-generated method stub
		List<Object[]> data = productTypeRepo.getProductTypeById(productTypeId);
		List<ProductTypeDTO> listPT =  data.stream().map(pt -> new ProductTypeDTO(pt)).collect(Collectors.toList());
		return listPT.get(0);
	}
	@Override
	public List<ProductypeData> getData() {
		// TODO Auto-generated method stub
		List<ProductypeData> response = new ArrayList<>();
		List<Object[]> ptData = productTypeRepo.getListProductType();
		List<ProductTypeDTO> listProductType = new ArrayList<>();
		listProductType = ptData.stream().map(pt -> new ProductTypeDTO(pt)).collect(Collectors.toList());
		for(ProductTypeDTO producttype : listProductType) {
			//set producttype
		    ProductypeData temp = new ProductypeData();
		    temp.setProductTypeName(producttype.getProductTypeName());
		    temp.setProductTypeId(producttype.getProductTypeId());
		    //get color of product type
		    List<Object[]> colorData = colorRepo.getListColorOfProductType(Integer.parseInt(producttype.getProductTypeId()));
		    List<ColorDTO> listColors = colorData.stream().map(pt -> new ColorDTO(pt)).collect(Collectors.toList());
		    temp.setColors(listColors);
		    //get size of product type
		    List<SizeFrontalData> frontalClosure = new ArrayList<>();
		    	List<String> regex = Arrays.asList("Closure","Frontal");
				List<Object[]> sizeData = sizeRepo.getListSizeOfProductType(Integer.parseInt(temp.getProductTypeId()),regex);
				List<SizeProductDTO> listSize = sizeData.stream().map(pt -> new SizeProductDTO(pt)).collect(Collectors.toList());
				SizeFrontalData frontal = null;
				for(SizeProductDTO data : listSize) {
					frontal = new SizeFrontalData();
					frontal.setSizeId(data.getId());
					frontal.setSizeFrontal(data.getSizeFrontal());
					frontal.setLength(data.getLength());
					frontalClosure.add(frontal);
				}
				temp.setFrontalClosure(frontalClosure);
				response.add(temp);
		}
		return response;
	}
	@Override
	public List<ProductTypeHome> getProductTypeHome() {
		// TODO Auto-generated method stub
		List<Object[]> test = productTypeRepo.getListProductTypeHome("2");
		return null;
	}
}
