package com.task.taskapp.domain;

import java.time.LocalDate;
import com.task.taskapp.domain.entity.TaskPriority;

public record CreateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority
) {}