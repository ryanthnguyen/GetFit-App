package com.GetFit.utils;

import com.GetFit.dao.Macro;
import com.GetFit.dao.User;
import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class MacrosUtilHelper {
    private static String FEMALE = "female";
    private static String MALE = "male";
    private static final ImmutableMap<String, Double> activityLevels = ImmutableMap.<String, Double>builder()
            .put("Sedentary", 1.2)
            .put("Lightly Active", 1.375)
            .put("Moderately Active", 1.55)
            .put("Very Active", 1.725)
            .put("Extremely Active", 1.9).build();


    public double calculateBMR(double weight, double height, int age, String gender){
        return gender.equalsIgnoreCase(MALE) ? 66 + (13.7 * weight) + (5 * height) - (6.8 * age) : 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
    }

    public double calculateTDEE(User user){
        int age = user.getAge();
        double weightInKg = convertPoundToKg(user.getWeight());
        double heightInCm = convertInchesToCm(user.getHeight());
        double BMR = calculateBMR(weightInKg, heightInCm, age, user.getGender());
        double result = 0;
        Optional<Map.Entry<String, Double>> activityValueMaybe =  activityLevels.entrySet().stream().filter(x -> x.getKey().equalsIgnoreCase(user.getActivityStatus())).findFirst();

        if (activityValueMaybe.isPresent()){
            result = activityValueMaybe.get().getValue() * BMR;
        }
        else{
            throw new RuntimeException("Unknown activity level provided");
        }

        return result;
    }

    public Macro calculateMacro(User user){
        double protein = 0.68 * user.getWeight();
        double fats = 0.4 * user.getWeight();
        double carbs = Math.ceil((calculateTDEE(user) - ((protein * 4) + (fats * 9))) / 4);
        return Macro.builder().protein(protein).fats(fats).carbs(carbs).build();
    }

    private double convertInchesToCm(double height) {
        return height * 2.54;
    }

    private double convertPoundToKg(double weight) {
        return Math.ceil(weight / 2.2046);
    }
}
