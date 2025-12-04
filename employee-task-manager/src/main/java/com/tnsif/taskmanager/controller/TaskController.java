package com.tnsif.taskmanager.controller;

import com.tnsif.taskmanager.entity.Task;
import com.tnsif.taskmanager.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // CREATE Task & Assign to Employee
    @PostMapping("/assign/{employeeId}")
    public ResponseEntity<Task> createTask(
            @RequestBody Task task,
            @PathVariable Long employeeId) {
        return ResponseEntity.ok(taskService.createTask(task, employeeId));
    }

    // GET All Tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    // FILTER — by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable String status) {
        return ResponseEntity.ok(taskService.getTasksByStatus(status));
    }

    // FILTER — by employee
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Task>> getTasksByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(taskService.getTasksByEmployee(employeeId));
    }

    // UPDATE STATUS
    @PutMapping("/{taskId}/status/{status}")
    public ResponseEntity<Task> updateStatus(
            @PathVariable Long taskId,
            @PathVariable String status) {
        return ResponseEntity.ok(taskService.updateTaskStatus(taskId, status));
    }
}
