package com.GetFit.dao;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
public class User {
    @NonNull String id;
    @NonNull String username;
    @NonNull String password;
    @NonNull ActivityStatus activityStatus;
    int age;
    double height;
    double weight;
}
