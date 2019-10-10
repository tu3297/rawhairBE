package com.myproject.learn.dto;


import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ColorDTO {
	@JsonProperty("colorName")
    private String colorName;
	@JsonProperty("colorCode")
    private String colorCode;
	@JsonProperty("colorId")
	private String colorId;
	public String getColorId() {
		return colorId;
	}
	public void setColorId(String colorId) {
		this.colorId = colorId;
	}
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	public ColorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ColorDTO(String colorName, String colorCode) {
		super();
		this.colorName = colorName;
		this.colorCode = colorCode;
	}
	public ColorDTO(Object[] color) {
		super();
		String[] colorValues =  Arrays.asList(color).toArray(new String[color.length]);
	    this.colorName = colorValues[1].toString();
	    this.colorCode = colorValues[2].toString();
	    this.colorId = colorValues[0].toString();
	    
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

}