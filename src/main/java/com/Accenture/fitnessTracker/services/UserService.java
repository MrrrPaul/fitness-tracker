package com.Accenture.fitnessTracker.services;

import com.Accenture.fitnessTracker.model.NutritionixDetailedProduct;
import com.Accenture.fitnessTracker.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User getCurrentUser();
    String getFirstNameAndTimeOfDay();

    NutritionixDetailedProduct addFood(NutritionixDetailedProduct food);
    List<NutritionixDetailedProduct> foodConsumedToday();
    void removeFood(String food);
    Map<String, Integer> dailyProgressToGoal();
    Map<String, Integer> customizedDailyGoals();

    // User Administration
    User saveNewUser(User user);
    User updatePassword(User user);
}
