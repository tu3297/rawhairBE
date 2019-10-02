package com.myproject.learn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

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
		List<Object[]> colorOb = colorRepo.getAllColors();
		listColors = colorOb.stream().map(color -> new ColorDTO(color)).collect(Collectors.toList());
		return listColors;
	}
	@Override
	@Transactional
	public ColorDTO addColor(ColorDTO color) {
		// TODO Auto-generated method stub
		colorRepo.addColor(color.getColorName(), color.getColorCode());
		return color;
	}

}
