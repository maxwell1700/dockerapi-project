package com.maxproject.dockerapiproject.Controller;

import com.maxproject.dockerapiproject.Model.Employee;
import com.maxproject.dockerapiproject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
       return ResponseEntity.ok(employeeService.addEmployee(employee));
    }
    @GetMapping
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Employee> findByName(@PathVariable("name") String name){
        return ResponseEntity.ok(employeeService.findByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Integer id){

       return ResponseEntity.ok(employeeService.updateEmployee(employee,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }
}
