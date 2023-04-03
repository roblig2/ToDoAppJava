package com.example.toDoApp.service;

import com.example.toDoApp.model.Task;
import com.example.toDoApp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getSingleTasks(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new NotFoundException("nie znaleziono"));
    }

    public Task changeTaskStatus(Task task) {
        return taskRepository.save(task);
    }

    public Task changeTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getFinishedTasks(boolean finished) {
        return taskRepository.findAllByFinished(finished);
    }
}
