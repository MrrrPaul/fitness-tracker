package com.Accenture.fitnessTracker.services;

import com.Accenture.fitnessTracker.model.NutritionixBaseProduct;
import com.Accenture.fitnessTracker.model.NutritionixDetailedProduct;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface NutritionixService {
    List<NutritionixBaseProduct> searchQuery(String query) throws UnsupportedEncodingException;
    NutritionixDetailedProduct getDetailedProduct(String query) throws UnsupportedEncodingException;
}
