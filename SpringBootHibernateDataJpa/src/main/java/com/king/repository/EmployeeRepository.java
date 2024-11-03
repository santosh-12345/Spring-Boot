package com.king.repository;

import org.springframework.data.repository.CrudRepository;

import com.king.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
