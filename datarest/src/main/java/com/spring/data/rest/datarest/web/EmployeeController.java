package com.spring.data.rest.datarest.web;

import com.spring.data.rest.datarest.entity.Employee;
import com.spring.data.rest.datarest.model.EmployeeDto;
import com.spring.data.rest.datarest.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mahendran
 */
@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<Employee> getAllEmployees() {
        List<Employee> all = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = all.stream().map(employee -> {
            EmployeeDto employeeDto = new EmployeeDto();
            BeanUtils.copyProperties(employee, employeeDto);
            return employeeDto;
        }).collect(Collectors.toList());
        return new ResponseEntity(employeeDtos, HttpStatus.OK);
    }
}
