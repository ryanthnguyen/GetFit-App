package com.GetFit.dao;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder(toBuilder = true)
@Data
public class Macro {
    double protein;
    double fats;
    double carbs;
    int totalCalories;
    @NonNull String id;
    @NonNull String goalId;
}
