package com.spring.data.rest.datarest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String empName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee" , fetch = FetchType.LAZY)
    private List<Address> address;

    private Double salary;

}
