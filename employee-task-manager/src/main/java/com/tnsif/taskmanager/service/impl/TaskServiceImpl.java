package com.tnsif.taskmanager.service.impl;

import com.tnsif.taskmanager.entity.Employee;
import com.tnsif.taskmanager.entity.Task;
import com.tnsif.taskmanager.exception.ResourceNotFoundException;
import com.tnsif.taskmanager.repository.EmployeeRepository;
import com.tnsif.taskmanager.repository.TaskRepository;
import com.tnsif.taskmanager.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Task createTask(Task task, Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with ID: " + employeeId));

        task.setEmployee(employee);
        task.setStatus("Todo");

        return taskRepository.save(task);
    }

    @Override
    public Task updateTaskStatus(Long taskId, String status) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found with ID: " + taskId));

        task.setStatus(status);

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public List<Task> getTasksByEmployee(Long employeeId) {
        return taskRepository.findByEmployeeId(employeeId);
    }
}
