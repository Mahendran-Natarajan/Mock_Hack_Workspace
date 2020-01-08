package com.scrotifybanking.scrotifybanking.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Customer response dto.
 */
@Setter
@Getter
public class CustomerResponseDto {

	private Long id;
	private String message;
	private Integer statusCode;

}
