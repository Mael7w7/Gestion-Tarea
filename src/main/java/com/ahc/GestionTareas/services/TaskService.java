package com.ahc.GestionTareas.services;

import com.ahc.GestionTareas.dto.TaskDTO;
import com.ahc.GestionTareas.entites.Task;
import com.ahc.GestionTareas.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class TaskService implements ITaskService{

    private final TaskRepository repository;

    @Override
    public List<TaskDTO> getTasks() {
        return repository.findAll()
                .stream()
                .map(r-> new TaskDTO(r.getTitle(),r.getDescription(),r.getCompleted(),r.getCreatedAt()))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTask(Long id) {
        return repository.findById(id)
                .map(r-> new TaskDTO(r.getTitle(),r.getDescription(),r.getCompleted(),r.getCreatedAt())).orElse(null);
    }

    @Override
    public Task createTask(Task dto) {
        return repository.save(dto);
    }


    @Override
    public TaskDTO updateTask(Long id, TaskDTO dto) {
        return repository.findById(id)
                .map(e->{
                    e.setTitle(dto.getTitle());
                    e.setDescription(dto.getDescription());
                    e.setCompleted(dto.getCompleted());
                    e.setCreatedAt(dto.getCreatedAt());
                    Task update = repository.save(e);
                    return new TaskDTO(update.getTitle(),update.getDescription(),update.getCompleted(),update.getCreatedAt());
                }).orElse(null);
    }

    @Override
    public void deleteTask(Long id) {
    repository.deleteById(id);
    }
}
