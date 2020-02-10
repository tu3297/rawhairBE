package com.myproject.learn.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductTypeDTO {
	@JsonProperty("name")
    private String productTypeName;
	@JsonProperty("description")
    private String productTypeDes;
	@JsonProperty("id")
	private String productTypeId;
	@JsonProperty("key")
	private String key;
	@JsonProperty("editing")
	private String editing;
	@JsonProperty
	private String parent;
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getEditing() {
		return editing;
	}
	public void setEditing(String editing) {
		this.editing = editing;
	}
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
	    this.productTypeName = pt[1].toString();
	    this.productTypeDes = pt[2].toString();
	    this.productTypeId = pt[0].toString();
	    this.parent = pt[3].toString();
	    
	}
	
}
