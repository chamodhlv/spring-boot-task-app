package com.task.taskapp.domain.dto;

import com.task.taskapp.domain.entity.TaskPriority;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record CreateTaskRequestDto(
        @NotNull(message = "Title cannot be null")
        @Length(max = 255)
        String title,

        @NotNull(message = "Description cannot be null")
        @Length(max = 1000, message = "Description cannot be longer than 1000 characters")
        String description,

        @NotNull(message = "Due date cannot be null")
        @FutureOrPresent(message = "Due date must be in the future")
        LocalDateTime dueDate,

        @NotNull(message = "Priority cannot be null")
        TaskPriority priority
) {

}