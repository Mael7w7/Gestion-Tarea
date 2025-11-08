package com.ahc.GestionTareas.services;

import com.ahc.GestionTareas.dto.TaskDTO;
import com.ahc.GestionTareas.entites.Task;

import java.util.List;

public interface ITaskService {
    List<TaskDTO> getTasks();
    TaskDTO getTask(Long id);
    Task createTask(Task dto);
    TaskDTO updateTask(Long id ,TaskDTO dto);
    void deleteTask(Long id);

}
