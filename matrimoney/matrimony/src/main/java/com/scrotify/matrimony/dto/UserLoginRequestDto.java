package com.scrotify.matrimony.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type User login request dto.
 */
@Getter
@Setter
public class UserLoginRequestDto {

    private String emailId;
    private String password;

}
