package com.myproject.learn.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListSizeRC {
	    @JsonProperty("dataSource")
	    private List<SizeDTO> dataSource;
	    @JsonProperty("selectedRowKeys")
	    private List<Integer> selectedRowKeys;
		public List<SizeDTO> getDataSource() {
			return dataSource;
		}
		public void setDataSource(List<SizeDTO> dataSource) {
			this.dataSource = dataSource;
		}
		public List<Integer> getSelectedRowKeys() {
			return selectedRowKeys;
		}
		public void setSelectedRowKeys(List<Integer> selectedRowKeys) {
			this.selectedRowKeys = selectedRowKeys;
		}
		public ListSizeRC() {
			super();
			// TODO Auto-generated constructor stub
		}
}
