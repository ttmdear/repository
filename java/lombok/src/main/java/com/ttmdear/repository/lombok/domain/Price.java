package com.ttmdear.repository.lombok.domain;

import lombok.Value;
import lombok.With;

@Value
@With
public class Price {
    private float value;
    private String currency;
}
