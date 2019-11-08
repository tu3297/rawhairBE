package com.myproject.learn.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.myproject.learn.dto.SizeDTO;
import com.myproject.learn.repository.SizeRepository;

@Service
public class SizeServiceImpl implements sizeService {
    @Autowired
    private SizeRepository sizeRepo;
	@Override
	@SuppressWarnings("deprecation")
	public List<SizeDTO> getListSize(int pageSize, int currentpage, String productTypeId) {
		// TODO Auto-generated method stub
		Pageable pageable = new PageRequest(currentpage-1,pageSize);
		List<Integer> producttype = new ArrayList<Integer>();
		producttype.add(-1);
		if(!productTypeId.equals("")) producttype =  Arrays.asList(productTypeId.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());;
		Page<Object[]> data =  sizeRepo.getListSize(producttype, pageable);
		List<Object[]> dataPage = data.getContent();
		List<SizeDTO> listSize = dataPage.stream().map(pt -> new SizeDTO(pt)).collect(Collectors.toList());
		for(int i = 0 ; i < listSize.size() ; i++ ) {
			listSize.get(i).setKey(String.valueOf(i));
		}
		return listSize;
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

}
