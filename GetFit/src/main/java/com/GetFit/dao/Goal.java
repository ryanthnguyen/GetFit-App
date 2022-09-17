package com.GetFit.dao;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
public class Goal {
    @NonNull String id;
    @NonNull String userId;
    @NonNull String name;
    @NonNull GoalStatus goalStatus;
}
