package com.scrotifybanking.payeemanagement.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type List beneficiary dto.
 */
@Getter
@Setter
public class ListBeneficiaryDto {

    private String nickName;
    private String name;
    private Long accountNo;
    private String ifscCode;
    private String bankName;
    private Double limit;
    private Long id;

}