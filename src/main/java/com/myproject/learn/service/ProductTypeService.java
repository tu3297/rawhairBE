package com.myproject.learn.service;

import java.util.List;

import com.myproject.learn.dto.ColorDTO;
import com.myproject.learn.dto.ProductTypeDTO;

public interface ProductTypeService {
      List<ProductTypeDTO> getListProductType();
      ProductTypeDTO addProductType(ProductTypeDTO color);
}