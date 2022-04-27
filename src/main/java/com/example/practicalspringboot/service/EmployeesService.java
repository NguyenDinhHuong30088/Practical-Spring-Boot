package com.example.practicalspringboot.service;

import com.example.practicalspringboot.employees.EmployeesRepository;
import com.example.practicalspringboot.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;
    public List<Employees> findAll(String name, double wage){
        return employeesRepository.search(name, wage);}

    public Optional<Employees> findById(Integer id) {
        return employeesRepository.findById(id);
    }




}
