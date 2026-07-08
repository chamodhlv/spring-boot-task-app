package com.task.taskapp.mapper.impl;

import com.task.taskapp.domain.CreateTaskRequest;
import com.task.taskapp.domain.UpdateTaskRequest;
import com.task.taskapp.domain.dto.CreateTaskRequestDto;
import com.task.taskapp.domain.dto.TaskDto;
import com.task.taskapp.domain.dto.UpdateTaskRequestDto;
import com.task.taskapp.domain.entity.Task;
import com.task.taskapp.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskRequestDto dto) {
        return new UpdateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.status(),
                dto.priority()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
