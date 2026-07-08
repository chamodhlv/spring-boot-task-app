package com.task.taskapp.mapper;

import com.task.taskapp.domain.CreateTaskRequest;
import com.task.taskapp.domain.UpdateTaskRequest;
import com.task.taskapp.domain.dto.CreateTaskRequestDto;
import com.task.taskapp.domain.dto.TaskDto;
import com.task.taskapp.domain.dto.UpdateTaskRequestDto;
import com.task.taskapp.domain.entity.Task;

public interface TaskMapper {
    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);

    TaskDto toDto(Task task);
}
