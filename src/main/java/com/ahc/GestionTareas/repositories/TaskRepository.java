package com.ahc.GestionTareas.repositories;

import com.ahc.GestionTareas.entites.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
