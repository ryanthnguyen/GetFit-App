package com.GetFit.dao;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
public class User {
    @NonNull private String id;
    @NonNull private String username;
    @NonNull private String password;
    @NonNull private String gender;
    @NonNull private String activityStatus;
    int age;
    double height;
    double weight;
}
