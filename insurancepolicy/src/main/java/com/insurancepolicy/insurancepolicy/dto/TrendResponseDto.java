package com.insurancepolicy.insurancepolicy.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TrendResponseDto {
    String policyName;
    Long policyId;
    Integer count;
    Integer percentage;

}
