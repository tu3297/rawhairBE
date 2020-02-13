package com.myproject.learn.dto;

import java.util.Map;

public class ProductInfo {
    private String color;
    private String colorCode;
    public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	private Map<String,ImagePriceProduct> sizePrice;
    private String description;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Map<String, ImagePriceProduct> getSizePrice() {
		return sizePrice;
	}
	public void setSizePrice(Map<String, ImagePriceProduct> sizePrice) {
		this.sizePrice = sizePrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
