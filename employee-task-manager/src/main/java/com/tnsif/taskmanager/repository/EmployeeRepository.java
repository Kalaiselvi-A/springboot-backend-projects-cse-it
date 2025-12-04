package com.tnsif.taskmanager.repository;

import com.tnsif.taskmanager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
