package com.scrotifybanking.payeemanagement.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Beneficiary add response dto.
 */
@Getter
@Setter
public class BeneficiaryAddResponseDto {

    private Long beneficiaryId;
    private String message;
    private Integer statusCode;

}
