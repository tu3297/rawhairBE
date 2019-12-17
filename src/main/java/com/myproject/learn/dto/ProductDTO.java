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
    @JsonProperty("sizeFrontal")
    private String sizeFrontal;
	public String getIdProduct() {
		return idProduct;
	}
	public String getSizeFrontal() {
		return sizeFrontal;
	}
	public void setSizeFrontal(String sizeFrontal) {
		this.sizeFrontal = sizeFrontal;
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
	
}
