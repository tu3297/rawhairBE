package com.myproject.learn.dto;

import java.util.List;

public class ProductTypeHome {
      private String productTypeId;
      private String productTypeName;
      private List<ProductTypeHome> child;
	public String getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public List<ProductTypeHome> getChild() {
		return child;
	}
	public void setChild(List<ProductTypeHome> child) {
		this.child = child;
	}
	public ProductTypeHome() {
		super();
		// TODO Auto-generated constructor stub
	}
      
}
