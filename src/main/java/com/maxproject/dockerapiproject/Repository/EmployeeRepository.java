package com.maxproject.dockerapiproject.Repository;

import com.maxproject.dockerapiproject.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public Employee findByfirstName(String firstName);//method name must be written specifically e.g has to be firstName to match with the field in Employee
}
