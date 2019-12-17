package com.myproject.learn.service;

import com.myproject.learn.dto.ProductDTO;

public interface ProductService {
     String getNextId();
     ProductDTO saveProduct(ProductDTO product);
}
