package com.example.practicalspringboot.employees;

import com.example.practicalspringboot.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
    List<Employees> search(
            @Param("name") String name, @Param("category") double wage);
}
