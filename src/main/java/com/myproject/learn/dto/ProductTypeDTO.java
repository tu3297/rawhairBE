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
	@JsonProperty("colorId")
	private String colorId;
	@JsonProperty("color")
	private String colorName;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getEditing() {
		return editing;
	}
	public String getColorId() {
		return colorId;
	}
	public void setColorId(String colorId) {
		this.colorId = colorId;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
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
	    this.colorId = pt[3].toString();
	    
	}
	
}
