package com.spring.data.rest.datarest.model;

import com.spring.data.rest.datarest.entity.Address;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeDto {
    Address address;
    private Long Id;
    private String empName;
    private Double salary;
}
