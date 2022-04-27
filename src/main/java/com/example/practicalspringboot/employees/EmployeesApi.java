package com.example.practicalspringboot.employees;

import com.example.practicalspringboot.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/employees")

public class EmployeesApi {

    @Autowired
    EmployeesRepository employeesRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employees> getList(@RequestParam(defaultValue = "") String name){
        if(name.length() > 0){
            return employeesRepository.findAllEmployees(name);
        }else {
            return employeesRepository.findAll();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employees save(@RequestBody Employees employees){
        employeesRepository.save(employees);
        return employees;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Employees getDetail(@PathVariable int id){
        return employeesRepository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id){
        employeesRepository.deleteById(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Employees update(@PathVariable int id, @RequestBody Employees updateEmployees){
        Employees existing = employeesRepository.findById(id).get();
        existing.setName(updateEmployees.getName());
        existing.setWage(updateEmployees.getWage());
        employeesRepository.save(existing);
        return updateEmployees;
    }
}
