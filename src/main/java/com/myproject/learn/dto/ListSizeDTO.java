package com.myproject.learn.dto;

import java.util.List;

public class ListSizeDTO {
     private List<SizeDTO> listSize;
     public ListSizeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int totalElemt;
	public List<SizeDTO> getListSize() {
		return listSize;
	}
	public void setListSize(List<SizeDTO> listSize) {
		this.listSize = listSize;
	}
	public int getTotalElemt() {
		return totalElemt;
	}
	public void setTotalElemt(int totalElemt) {
		this.totalElemt = totalElemt;
	}
}
