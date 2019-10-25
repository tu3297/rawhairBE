package com.myproject.learn.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.myproject.learn.dto.SizeDTO;

public interface sizeService {
    List<SizeDTO> getListSize(int pageSizem,int currentpage,String productTypeId);
}
