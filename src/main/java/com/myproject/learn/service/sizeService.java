package com.myproject.learn.service;

import java.util.List;

import com.myproject.learn.dto.ListSizeDTO;
import com.myproject.learn.dto.SizeDTO;
import com.myproject.learn.dto.SizeProductDTO;

public interface sizeService {
    ListSizeDTO getListSize(int pageSizem,int currentpage,String productTypeId);
    SizeDTO addSize(SizeDTO size);
    SizeDTO updateSize(SizeDTO size);
    String deleteSize(List<Integer> listId);
    List<SizeProductDTO> getListSizeOfproductType(Integer productTypeId);
    List<SizeProductDTO> getListSizeOfClosureFrontal(Integer productId,String size);
}
