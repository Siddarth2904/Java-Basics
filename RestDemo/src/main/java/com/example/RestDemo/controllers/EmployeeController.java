package com.example.RestDemo.controllers;

import com.example.RestDemo.entities.Employee;
import com.example.RestDemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }
    @GetMapping("/getemployee/{id}")
    public ResponseEntity<Employee> getEmployees(@PathVariable Integer id) {
        Employee employee = employeeService.getEmployee(id);
        return employee!=null? ResponseEntity.ok(employee):ResponseEntity.notFound().build();
    }
    @PostMapping("/createemployee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
    @PutMapping("/updateemployee/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
    @DeleteMapping("/deleteemployee/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }
}
