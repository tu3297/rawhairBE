package com.myproject.learn.service;

import java.util.List;

import com.myproject.learn.dto.ProductTypeColorDTO;
import com.myproject.learn.dto.ProductTypeDTO;
import com.myproject.learn.dto.ProductypeData;

public interface ProductTypeService {
      List<ProductTypeDTO> getListProductType();
      List<ProductTypeColorDTO> getListProductTypeColor();
      ProductTypeDTO addProductType(ProductTypeDTO pt);
      ProductTypeDTO updateProductType(ProductTypeDTO pt);
      String deleteProductType(List<Integer> listId);
      String updateProductTypeColor(String data);
      Integer checkExistProductTypeColor(Integer colorId,Integer ptId);
      ProductTypeDTO getProductTypeById(Integer productTypeId);
      List<ProductypeData> getData();
}
