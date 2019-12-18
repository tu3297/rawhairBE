package com.myproject.learn.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {
	@JsonProperty("idProduct")
	private String idProduct;
	@JsonProperty("idProductType")
    private String idProductType;
	@JsonProperty("idColor")
	private String idColor;
	@JsonProperty("idSize")
	private String idSize;
    @JsonProperty("price")
    private String price;
    @JsonProperty("frontal")
    private String sizeFrontal;
    @JsonProperty("productTypeName")
    private String productTypeName;
    @JsonProperty("colorName")
    private String colorName;
    @JsonProperty("colorCode")
    private String colorCode;
    @JsonProperty("length")
    private String length;
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	public String getIdProductType() {
		return idProductType;
	}
	public void setIdProductType(String idProductType) {
		this.idProductType = idProductType;
	}
	public String getIdColor() {
		return idColor;
	}
	public void setIdColor(String idColor) {
		this.idColor = idColor;
	}
	public String getIdSize() {
		return idSize;
	}
	public void setIdSize(String idSize) {
		this.idSize = idSize;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSizeFrontal() {
		return sizeFrontal;
	}
	public void setSizeFrontal(String sizeFrontal) {
		this.sizeFrontal = sizeFrontal;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
}
