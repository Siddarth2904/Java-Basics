package com.example.RestDemo.services;

import com.example.RestDemo.entities.Employee;
import com.example.RestDemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Integer id){
        Optional<Employee> byId = employeeRepository.findById(id);
        return byId.orElse(null);
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Integer id, Employee employee){
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        if (employee.getName() != null) {
            existingEmployee.setName(employee.getName());
        }
        if (employee.getEmail() != null) {
            existingEmployee.setEmail(employee.getEmail());
        }
        if (employee.getGender() != null) {
            existingEmployee.setGender(employee.getGender());
        }
        if (employee.getSalary() > 0) {
            existingEmployee.setSalary(employee.getSalary());
        }
        if (employee.getAge() > 0) {
            existingEmployee.setAge(employee.getAge());
        }
        return employeeRepository.save(existingEmployee);
    }
    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }
}
