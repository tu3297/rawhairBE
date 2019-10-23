package com.myproject.learn.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SizeDTO {
	@JsonProperty("name")
    private String productTypeName;
	@JsonProperty("description")
    private String productTypeDes;
	@JsonProperty("id")
	private String productTypeId;
	@JsonProperty("key")
	private String key;
	@JsonProperty("editing")
	private String editing;
	public SizeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
