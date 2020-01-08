package com.insurancepolicy.insurancepolicy.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
public class PolicyHolderDto {
    @NotBlank(message = "Policy holder name should not be blank")
    private String policyHolderName;
    @NotBlank(message = "Gender should not be blank")
    private String gender;
    private Integer age;
    private Long mobileNumber;
    private Long policyHolderId;
}
