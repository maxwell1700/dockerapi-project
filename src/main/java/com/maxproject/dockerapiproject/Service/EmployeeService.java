package com.maxproject.dockerapiproject.Service;

import com.maxproject.dockerapiproject.Model.Employee;
import com.maxproject.dockerapiproject.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){

        return employeeRepository.findAll();
    }

    public Employee findById(Integer id){

        return employeeRepository.findById(id).get();
    }

    public Employee findByName(String name){
        return employeeRepository.findByfirstName(name);
    }

    public Employee updateEmployee(Employee employee, Integer id){
       Employee emp = employeeRepository.findById(id).get();
       emp.setId(employee.getId());
       emp.setUserName(employee.getUserName());
       emp.setLastName(employee.getLastName());
       emp.setFirstName(employee.getFirstName());
       return employeeRepository.save(emp);
    }

    public Boolean deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
        return true;
    }
}
