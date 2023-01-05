package com.hasithat.springdatajdbc.repository.impl;

import com.hasithat.springdatajdbc.entity.Employee;
import com.hasithat.springdatajdbc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Employee employee) {
        String query = "INSERT INTO employee(name,dept,email, doj) values(?,?,?,?)";
        return jdbcTemplate.update(query, employee.getName(), employee.getDept(), employee.getEmail(), employee.getDoj());

    }

    @Override
    public int update(Employee employee) {
        String sql = "UPDATE employee SET name=?, dept=?, email=?, doj=? where id =?";
        return jdbcTemplate.update(sql, employee.getName(), employee.getDept(), employee.getEmail(), employee.getDoj(), employee.getId());
    }

    @Override
    public List<Employee> findAll() {
        String query = "SELECT * FROM employee";
        //return  jdbcTemplate.query(query, new EmployeeRowMapper());
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            return Employee.builder().id(rs.getInt("id")).name(rs.getString("name")).dept(rs.getString("dept")).email(rs.getString("email")).doj(rs.getDate("doj").toLocalDate()).build();
        });
    }

    @Override
    public List<Employee> getAllEmployees() {
        String query = "SELECT * FROM employee";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public Employee findById(int id) {
        String sql = "SELECT * FROM employee WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM employee where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public String getNameById(int id) {
        String sql = "SELECT name FROM employee WHERE id=?";
        return jdbcTemplate.queryForObject(sql, String.class, id);
    }

    @Override
    public List<Employee> findByNameAndDepartment(String name, String department) {
        String sql = "SELECT * FROM employee WHERE name=? AND dept=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class), name, department);
    }
}
