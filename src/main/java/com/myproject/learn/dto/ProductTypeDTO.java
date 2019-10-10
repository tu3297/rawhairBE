package com.myproject.learn.dto;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductTypeDTO {
	@JsonProperty("productTypeName")
    private String productTypeName;
	@JsonProperty("productTypeDes")
    private String productTypeDes;
	@JsonProperty("productTypeId")
	private String productTypeId;
	public ProductTypeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public String getProductTypeDes() {
		return productTypeDes;
	}
	public void setProductTypeDes(String productTypeDes) {
		this.productTypeDes = productTypeDes;
	}
	public String getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}
	public ProductTypeDTO(Object[] pt) {
		super();
		String[] colorValues =  Arrays.asList(pt).toArray(new String[pt.length]);
	    this.productTypeName = colorValues[1].toString();
	    this.productTypeDes = colorValues[2].toString();
	    this.productTypeId = colorValues[0].toString();
	    
	}
	
}
