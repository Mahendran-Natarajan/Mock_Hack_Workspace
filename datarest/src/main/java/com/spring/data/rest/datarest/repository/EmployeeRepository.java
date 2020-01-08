package com.spring.data.rest.datarest.repository;

import com.spring.data.rest.datarest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "emp")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
