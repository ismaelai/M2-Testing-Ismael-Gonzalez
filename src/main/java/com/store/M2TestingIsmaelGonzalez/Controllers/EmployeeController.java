package com.store.M2TestingIsmaelGonzalez.Controllers;

import com.store.M2TestingIsmaelGonzalez.Entities.Employee;
import com.store.M2TestingIsmaelGonzalez.Repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    // attributes repostiry injection
    EmployeeRepository repository;

    // repository constructor
    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    // REST Methods
    @GetMapping("/employee/{id}")
    public Employee findById(@PathVariable Long id){
        Employee employee1 = new Employee(id, "nina" , "salvio", 28, 1 );
    }

}
