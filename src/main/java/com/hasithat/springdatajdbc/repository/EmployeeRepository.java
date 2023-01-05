package com.hasithat.springdatajdbc.repository;

import com.hasithat.springdatajdbc.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    int save(Employee employee);

    int update(Employee employee);

    List<Employee> findAll();

    List<Employee> getAllEmployees();

    Employee findById(int id);

    int delete(int id);

    String getNameById(int id);

    List<Employee> findByNameAndDepartment(String name, String department);
}
