package com.myproject.learn.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private List<String> urlImage;
    private List<String> ref_key;
	public List<String> getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(List<String> urlImage) {
		this.urlImage = urlImage;
	}
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
	public ProductDTO(Object[] data) {
		super();
		this.urlImage = new ArrayList<>();
		this.ref_key = new ArrayList<>();
		// TODO Auto-generated constructor stub
		this.idProduct = data[0].toString();
		this.idProductType = data[1].toString();
		this.productTypeName = data[2].toString();
		this.idColor = data[3].toString();
		this.colorCode = data[4].toString();
		this.colorName = data[5].toString();
		this.idSize = data[6].toString();
		this.length = data[7].toString();
		this.sizeFrontal = data[8].toString();
		this.price = data[9].toString();
		if(data.length >= 11) this.urlImage.addAll(Arrays.asList(data[10].toString().split(",")));
		if(data.length >= 12) this.ref_key.addAll(Arrays.asList(data[11].toString().split(",")));
	}
	public List<String> getRef_key() {
		return ref_key;
	}
	public void setRef_key(List<String> ref_key) {
		this.ref_key = ref_key;
	}
	
    
}
