package com.myproject.learn.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductTypeColorDTO {
	@JsonProperty("id")
    private String id;
	@JsonProperty("ptId")
    private String ptId;
	@JsonProperty("colorId")
	private String colorId;
	public ProductTypeColorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPtId() {
		return ptId;
	}
	public void setPtId(String ptId) {
		this.ptId = ptId;
	}
	public String getColorId() {
		return colorId;
	}
	public void setColorId(String colorId) {
		this.colorId = colorId;
	}
	public ProductTypeColorDTO(Object[] pt) {
		super();
	    this.id = pt[1].toString();
	    this.ptId = pt[2].toString();
	    this.colorId = pt[0].toString();
	    
	}
	
}
