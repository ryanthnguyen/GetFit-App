package com.GetFit.dao;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
public class ActivityStatus {
    int id;
    @NonNull String value;
}
