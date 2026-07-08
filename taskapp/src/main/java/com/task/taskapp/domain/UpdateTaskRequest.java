package com.task.taskapp.domain;

import com.task.taskapp.domain.entity.TaskPriority;
import com.task.taskapp.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
) {
}
