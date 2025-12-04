package com.tnsif.taskmanager.repository;

import com.tnsif.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // Filter tasks by status (Todo, Doing, Done)
    List<Task> findByStatus(String status);

    // Get all tasks assigned to a specific employee
    List<Task> findByEmployeeId(Long employeeId);
}
