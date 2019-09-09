package com.myproject.learn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.learn.dto.ColorDTO;
import com.myproject.learn.repository.ColorRepository;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorRepository colorRepo;
	@Override
	public List<ColorDTO> getAllColors() {
		// TODO Auto-generated method stub
		List<ColorDTO> listColors = new ArrayList<>();
		List<Object> colorOb = colorRepo.getAllColors();
		return listColors;
	}

}
