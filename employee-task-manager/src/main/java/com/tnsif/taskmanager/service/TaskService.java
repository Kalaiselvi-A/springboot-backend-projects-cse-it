package com.tnsif.taskmanager.service;

import com.tnsif.taskmanager.entity.Task;
import java.util.List;

public interface TaskService {

    Task createTask(Task task, Long employeeId);

    Task updateTaskStatus(Long taskId, String status);

    List<Task> getAllTasks();

    List<Task> getTasksByStatus(String status);

    List<Task> getTasksByEmployee(Long employeeId);
}
