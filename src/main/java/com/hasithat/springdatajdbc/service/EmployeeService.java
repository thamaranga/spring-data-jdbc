package com.hasithat.springdatajdbc.service;

import com.hasithat.springdatajdbc.entity.Employee;
import com.hasithat.springdatajdbc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String save(Employee employee) {
        int result = employeeRepository.save(employee);
        return "Employee saved | " + result;
    }


    public String update(Employee employee) {
        int result = employeeRepository.update(employee);
        return "Employee updated | " + result;
    }


    public List<Employee> findAll() {
        /*List<Employee> employees=employeeRepository.findAll();
        employees.stream().map(e-> e.setDoj(DateUtility.changeDateFormat(e.getDoj())))*/
        return employeeRepository.findAll();
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();

    }


    public Employee findById(int id) {
        return employeeRepository.findById(id);

    }


    public String delete(int id) {
        int result = employeeRepository.delete(id);
        return "Employee deleted | " + result;
    }

    public String getNameById(int id) {
        return employeeRepository.getNameById(id);

    }


    public List<Employee> findByNameAndDepartment(String name, String department) {
        return employeeRepository.findByNameAndDepartment(name, department);
    }


}
