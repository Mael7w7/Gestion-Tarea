package com.ahc.GestionTareas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class TaskDTO {
    private String title;
    private String description;
    private Boolean completed;
    private LocalDate createdAt;

}
