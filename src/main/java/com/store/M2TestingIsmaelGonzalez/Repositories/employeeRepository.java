package com.store.M2TestingIsmaelGonzalez.Repositories;


import com.store.M2TestingIsmaelGonzalez.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface employeeRepository extends JpaRepository <Employee, Long>{

    //List<Employee> findByEmployee(String employee);

    List<Employee> findByFirstName(String firstName);
}
