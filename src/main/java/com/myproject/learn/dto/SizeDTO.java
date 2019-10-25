package com.myproject.learn.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SizeDTO {
	@JsonProperty("name")
    private String sizeName;
	@JsonProperty("length")
    private String length;
	@JsonProperty("id")
	private int sizeId;
	@JsonProperty("key")
	private String key;
	@JsonProperty("editing")
	private String editing;
    @JsonProperty("sizefrontal")
    private String sizeFrontal;
    @JsonProperty("product_type")
    private int product_type;
    public int getProduct_type() {
		return product_type;
	}
	public void setProduct_type(int product_type) {
		this.product_type = product_type;
	}
	private int totalElemt;
	public int getTotalElemt() {
		return totalElemt;
	}
	public void setTotalElemt(int totalElemt) {
		this.totalElemt = totalElemt;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
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
	public SizeDTO(Object[] pt) {
		System.out.println(pt[0]);
		this.sizeId = Integer.parseInt(pt[0].toString());
		this.length = pt[1].toString();
		this.product_type = Integer.parseInt(pt[2].toString());
		this.sizeFrontal = pt[3].toString();
	}
}
