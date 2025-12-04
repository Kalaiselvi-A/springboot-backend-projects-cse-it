package com.tnsif.taskmanager.service;

import com.tnsif.taskmanager.entity.Employee;
import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee updatedEmployee);

    String deleteEmployee(Long id);
}
