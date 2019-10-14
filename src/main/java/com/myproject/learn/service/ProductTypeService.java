package com.myproject.learn.service;

import java.util.List;

import com.myproject.learn.dto.ColorDTO;
import com.myproject.learn.dto.ProductTypeDTO;

public interface ProductTypeService {
      List<ProductTypeDTO> getListProductType();
      ProductTypeDTO addProductType(ProductTypeDTO pt);
      ProductTypeDTO updateProductType(ProductTypeDTO pt);
      String deleteProductType(List<Integer> listId);
}
