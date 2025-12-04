package com.tnsif.taskmanager.service.impl;

import com.tnsif.taskmanager.entity.Employee;
import com.tnsif.taskmanager.exception.ResourceNotFoundException;
import com.tnsif.taskmanager.repository.EmployeeRepository;
import com.tnsif.taskmanager.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with ID: " + id));
    }

    @Override
    public Employee updateEmployee(Long id, Employee updatedEmployee) {

        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with ID: " + id));

        existing.setName(updatedEmployee.getName());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setDepartment(updatedEmployee.getDepartment());
        existing.setRole(updatedEmployee.getRole());
        existing.setPhone(updatedEmployee.getPhone());
        existing.setAddress(updatedEmployee.getAddress());

        return employeeRepository.save(existing);
    }

    @Override
    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully!";
    }
}
