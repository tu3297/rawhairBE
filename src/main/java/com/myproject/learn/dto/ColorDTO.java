package com.myproject.learn.dto;

public class ColorDTO {
    private int colorId;
    private String colorName;
    private String colorCode;
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
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

}
