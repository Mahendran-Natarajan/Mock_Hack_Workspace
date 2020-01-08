package com.scrotifybanking.payeemanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Beneficiary add request dto.
 */
@Getter
@Setter
@NoArgsConstructor
public class BeneficiaryAddRequestDto {

    private Long beneficiaryAccountNo;
    private Double amountLimit;
    private String beneficaryName;
    private String nickName;
    private String ifscCode;
    private String bankName;

}
