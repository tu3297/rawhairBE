package com.myproject.learn.dto;

import java.util.ArrayList;
import java.util.List;

public class ImagePriceProduct {
    private List<String> urlImage;
    private String price;
	public List<String> getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(List<String> urlImage) {
		this.urlImage = urlImage;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public ImagePriceProduct() {
		super();
		this.urlImage = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
    
}
