package com.myproject.learn.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SizeDTO {
	@JsonProperty("id")
	private String id;
	@JsonProperty("length")
    private String length;
	@JsonProperty("key")
	private String key;
	@JsonProperty("editing")
	private String editing;
    @JsonProperty("sizefrontal")
    private String sizeFrontal;
    @JsonProperty("producttype")
    private String producttype;
    public String getProducttype() {
		return producttype;
	}
	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	@JsonProperty("productTypeId")
    private int productTypeId;
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
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
	public String getSizeFrontal() {
		return sizeFrontal;
	}
	public void setSizeFrontal(String sizeFrontal) {
		this.sizeFrontal = sizeFrontal;
	}
	public SizeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public SizeDTO(Object[] pt) {
	}
}
