package com.example.practicalspringboot.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/employees")

public class EmployeesApi {

    @Autowired
    EmployeesRepository employeesRepository;


}
