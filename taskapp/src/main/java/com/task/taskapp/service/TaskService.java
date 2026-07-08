package com.task.taskapp.service;

import com.task.taskapp.domain.CreateTaskRequest;
import com.task.taskapp.domain.entity.Task;

import java.util.List;

public interface TaskService {
    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();
}
