package com.myproject.learn.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.learn.dto.ListSizeDTO;
import com.myproject.learn.dto.SizeDTO;
import com.myproject.learn.dto.SizeProductDTO;
import com.myproject.learn.repository.SizeRepository;

@Service
public class SizeServiceImpl implements sizeService {
    @Autowired
    private SizeRepository sizeRepo;
	@Override
	public ListSizeDTO getListSize(int pageSize, int currentpage, String productTypeId) {
		// TODO Auto-generated method stub
		ListSizeDTO response = new ListSizeDTO();
		int offset = (currentpage - 1) * pageSize;
		List<Integer> producttype = null;
		if(!productTypeId.equals("")) producttype =  Arrays.asList(productTypeId.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());;
		List<Object[]> data =  sizeRepo.getListSize(producttype, pageSize , offset);
		List<SizeDTO> listSize = data.stream().map(pt -> new SizeDTO(pt)).collect(Collectors.toList());
		for(int i = 0 ; i < listSize.size() ; i++ ) {
			listSize.get(i).setKey(String.valueOf(i));
		}
	    response.setListSize(listSize);
	    Integer total = sizeRepo.getTotal(producttype);
	    response.setTotalElemt(total);
	    return response;
	}
	@Transactional
	@Override
	public SizeDTO addSize(SizeDTO size) {
		// TODO Auto-generated method stub
		sizeRepo.addSize(size.getLength(), size.getProductTypeId(), size.getSizeFrontal());
		return size;
	}
	@Transactional
	@Override
	public SizeDTO updateSize(SizeDTO size) {
		// TODO Auto-generated method stub
		sizeRepo.updateSize(size.getLength(), size.getProductTypeId(), size.getSizeFrontal(), Integer.parseInt(size.getId().trim()));
		return size;
	}
	@Transactional
	@Override
	public String deleteSize(List<Integer> listId) {
		// TODO Auto-generated method stub
		try {
		    sizeRepo.deleteSize(listId);
		}catch (Exception e) {
			// TODO: handle exception
			return "Fail";
		}
		return "Success";
	}
	@Override
	public List<SizeProductDTO> getListSizeOfproductType(Integer productTypeId) {
		// TODO Auto-generated method stub
		List<String> regex = Arrays.asList("Closure","Frontal");
		List<Object[]> sizeData = sizeRepo.getListSizeOfProductType(productTypeId,regex);
		List<SizeProductDTO> listSize = sizeData.stream().map(pt -> new SizeProductDTO(pt)).collect(Collectors.toList());
		return listSize;
	}
	@Override
	public List<SizeProductDTO> getListSizeOfClosureFrontal(Integer productId, String size) {
		// TODO Auto-generated method stub
		List<Object[]> sizeData = sizeRepo.getListSizeOfClosureOrFrontal(productId, size);
		List<SizeProductDTO> listSize = sizeData.stream().map(pt -> new SizeProductDTO(pt)).collect(Collectors.toList());
		return listSize;
	}

}
