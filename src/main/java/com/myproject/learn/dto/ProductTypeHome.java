package com.myproject.learn.dto;

import java.util.List;

public class ProductTypeHome {
      private String key;
      private String title;
      private List<ProductTypeHome> children;

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<ProductTypeHome> getChildren() {
		return children;
	}
	public void setChildren(List<ProductTypeHome> children) {
		this.children = children;
	}
	public ProductTypeHome() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductTypeHome(String productTypeId, String productTypeName) {
		super();
		this.key = productTypeId;
		this.title = productTypeName;
	}
      
}
