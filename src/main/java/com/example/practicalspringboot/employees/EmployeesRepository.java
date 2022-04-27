package com.example.practicalspringboot.employees;

import com.example.practicalspringboot.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
    @Query(value = "SELECT * FROM employees a WHERE a.name LIKE %:name%",
            nativeQuery = true)
    List<Employees> findAllEmployees(
            @Param("name") String name);
}
