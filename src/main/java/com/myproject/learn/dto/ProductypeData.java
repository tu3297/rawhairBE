package com.myproject.learn.dto;

import java.util.List;

public class ProductypeData {
    private String productTypeName;
    private String productTypeId;
    private List<ColorDTO> colors;
    private List<SizeFrontalData> frontalClosure;
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public String getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}
	public List<ColorDTO> getColors() {
		return colors;
	}
	public void setColors(List<ColorDTO> colors) {
		this.colors = colors;
	}
	public List<SizeFrontalData> getFrontalClosure() {
		return frontalClosure;
	}
	public void setFrontalClosure(List<SizeFrontalData> frontalClosure) {
		this.frontalClosure = frontalClosure;
	}
	public ProductypeData() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
