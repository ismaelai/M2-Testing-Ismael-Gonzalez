package com.store.M2TestingIsmaelGonzalez.Controllers;

import com.store.M2TestingIsmaelGonzalez.Entities.Employee;
import com.store.M2TestingIsmaelGonzalez.Repositories.employeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class employeeController {

    // attributes repostiry injection
    employeeRepository repository;

    // repository constructor
    public employeeController(employeeRepository repository) {
        this.repository = repository;
    }

    /**
     * Method for demo data insertion
     */
    @GetMapping("/data")
    public void insertData() {
        Employee employee1 = new Employee(null, "Niña", "Salvio", 28, LocalDate.of(2021, 10, 1), LocalDate.of(1993, 1, 31), true);
        Employee employee2 = new Employee(null, "Jake", "Huoston", 28, LocalDate.of(2021, 7, 1), LocalDate.of(1997, 1, 15), true);
        Employee employee3 = new Employee(null, "Matt", "Traves", 28, LocalDate.of(2021, 7, 1), LocalDate.of(1994, 3, 22), false);
        repository.save(employee1);
        repository.save(employee2);
        repository.save(employee3);
        System.out.println("Demo data has been inserted.");
    }

    // ================REST Methods============

    // all employee
    @GetMapping("/employee")
    public List<Employee> findAll(){
        return repository.findAll();
    }

    // find employee by id
    @GetMapping("/employee/{id}")
    public Employee findById(@PathVariable Long id){
        Optional<Employee> employeeOpt = repository.findById(id);

        if(employeeOpt.isPresent())
            return employeeOpt.get();
        else return null;
    }

    // find by attribute such as firstname or lastname etc
    @GetMapping("/employee/name/{firstName}")
    public List<Employee> findByFirstName(@PathVariable String firstName){
        return repository.findByFirstName(firstName);
    }

    // send http to create a new record
    @PostMapping("/employee")
    public void createEmployee(@RequestBody Employee employee){
        if (employee.getId() == null) // firstly check if hasn`t been created previously
            repository.save(employee);
    }

    // update a record if id isn't null and if id exists
    @PutMapping("/employee")
    public void updateEmployee(@RequestBody Employee employee){
        if(employee.getId() !=null && repository.existsById(employee.getId()))
            repository.save(employee);
    }

    // delete record by id
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Long id){
        if(repository.existsById(id))
            repository.deleteById(id);
    }



}
