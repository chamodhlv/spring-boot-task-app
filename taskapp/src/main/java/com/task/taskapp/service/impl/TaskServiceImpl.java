package com.task.taskapp.service.impl;

import com.task.taskapp.domain.CreateTaskRequest;
import com.task.taskapp.domain.entity.Task;
import com.task.taskapp.domain.entity.TaskStatus;
import com.task.taskapp.repository.TaskRepository;
import com.task.taskapp.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TaskServiceImpl implements TaskService {

    public final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now = Instant.now();

        Task task = new Task(
                null,
                request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now
        );
        taskRepository.save(task);
        return task;
    }
}
