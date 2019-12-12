package com.myproject.learn.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SizeProductDTO {
	@JsonProperty("id")
    private String id;
	@JsonProperty("length")
    private String length;
	@JsonProperty("sizeFrontal")
	private String sizeFrontal;
	@JsonProperty("isFrontalClosure")
	private String isFrontalClosure;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIsFrontalClosure() {
		return isFrontalClosure;
	}
	public void setIsFrontalClosure(String isFrontalClosure) {
		this.isFrontalClosure = isFrontalClosure;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getSizeFrontal() {
		return sizeFrontal;
	}
	public SizeProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setSizeFrontal(String sizeFrontal) {
		this.sizeFrontal = sizeFrontal;
	}
	public SizeProductDTO(Object[] data) {
		this.id= (data[0] != null ? data[0] : "").toString();
		this.length = (data[1] != null ? data[1] : "").toString();
		this.sizeFrontal = (data[2] != null ? data[2] : "").toString();
		this.isFrontalClosure = (data[3] != null ? data[3] : "").toString();
	}
	
}
