package com.myproject.learn.service;

import java.util.List;

import com.myproject.learn.dto.ColorDTO;

public interface ColorService {
    List<ColorDTO> getAllColors();
    ColorDTO addColor(ColorDTO color);
    ColorDTO updateColor(ColorDTO color);
    String deleteColor(int colorId);
    boolean checkExistColor(ColorDTO color);
    List<ColorDTO> getListColorOfProductType(Integer productTypeId);
}
