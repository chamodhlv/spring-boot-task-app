package com.task.taskapp.controller;

import com.task.taskapp.domain.CreateTaskRequest;
import com.task.taskapp.domain.dto.CreateTaskRequestDto;
import com.task.taskapp.domain.dto.TaskDto;
import com.task.taskapp.domain.entity.Task;
import com.task.taskapp.mapper.TaskMapper;
import com.task.taskapp.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;


    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<CreateTaskRequestDto> createTask(
            @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto
    ) {
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
        Task task = taskService.createTask(createTaskRequest);
        TaskDto taskDto = taskMapper.toDto(task);
        return new ResponseEntity<>(createTaskRequestDto, HttpStatus.CREATED);
    }

}
