package com.task.taskapp.service;

import com.task.taskapp.domain.CreateTaskRequest;
import com.task.taskapp.domain.entity.Task;

public interface TaskService {
    Task createTask(CreateTaskRequest request);
}
