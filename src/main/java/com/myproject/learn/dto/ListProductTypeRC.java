package com.myproject.learn.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListProductTypeRC {
    @JsonProperty("dataSource")
    private List<ProductTypeDTO> dataSource;
    @JsonProperty("selectedRowKeys")
    private List<Integer> selectedRowKeys;
	public List<ProductTypeDTO> getDataSource() {
		return dataSource;
	}
	public void setDataSource(List<ProductTypeDTO> dataSource) {
		this.dataSource = dataSource;
	}
	public List<Integer> getSelectedRowKeys() {
		return selectedRowKeys;
	}
	public void setSelectedRowKeys(List<Integer> selectedRowKeys) {
		this.selectedRowKeys = selectedRowKeys;
	}
	public ListProductTypeRC() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
