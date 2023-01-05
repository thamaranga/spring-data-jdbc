package com.hasithat.springdatajdbc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    private int id;
    private String name;
    private String dept;
    private String email;
    //@JsonFormat(pattern = "dd/mm/yyyy")
    private LocalDate doj;

}
