package com.hasithat.springdatajdbc.controller;

import com.hasithat.springdatajdbc.entity.Employee;
import com.hasithat.springdatajdbc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public String save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping
    public String update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/2ndway")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();

    }

    @GetMapping("findbyId/{id}")
    public Employee findById(@PathVariable int id) {
        return employeeService.findById(id);

    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id) {
        return employeeService.delete(id);
    }

    @GetMapping("name/{id}")
    public String getNameById(@PathVariable int id) {
        return employeeService.getNameById(id);
    }

    @GetMapping("{name}/{department}")
    public List<Employee> findByNameAndDepartment(@PathVariable String name, @PathVariable String department) {
        return employeeService.findByNameAndDepartment(name, department);
    }


}
