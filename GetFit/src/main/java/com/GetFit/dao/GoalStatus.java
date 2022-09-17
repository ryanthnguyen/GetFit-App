package com.GetFit.dao;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
public class GoalStatus {
    int id;
    @NonNull String value;
}
