package com.myproject.learn.service;

import java.util.List;

import com.myproject.learn.dto.ProductDTO;
import com.myproject.learn.dto.ProductRC;

public interface ProductService {
     String getNextId();
     ProductRC saveProduct(ProductRC product);
     List<ProductDTO> getAllProduct(List<String> productType,List<String> color,List<String> length,Integer pageSize,Integer currentPace,String productId,String sort);
     ProductDTO getProductById(String idProduct);
}
