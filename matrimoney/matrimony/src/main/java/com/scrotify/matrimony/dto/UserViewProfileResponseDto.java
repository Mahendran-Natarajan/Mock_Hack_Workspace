package com.scrotify.matrimony.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * The type User view profile response dto.
 */
@Getter
@Setter
public class UserViewProfileResponseDto {

    private Long mobileNo;
    private String name;
    private LocalDate date;
    private String gender;
    private String relegion;
    private String motherTongue;
    private String emailId;
    private String caste;
    private String gothram;
    private String maritalStatus;
    private float height;
    private String qualification;
    private String occupation;
    private double annualIncome;
    private String workLocation;
    private String state;
    private String city;
}

