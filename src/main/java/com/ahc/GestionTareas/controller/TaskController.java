package com.ahc.GestionTareas.controller;

import com.ahc.GestionTareas.dto.TaskDTO;
import com.ahc.GestionTareas.entites.Task;
import com.ahc.GestionTareas.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskDTO> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task dto) {
        return taskService.createTask(dto);
    }

    @PutMapping("/{id}")
    public TaskDTO updateTask(@PathVariable Long id, @RequestBody TaskDTO dto) {
        return taskService.updateTask(id,dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
