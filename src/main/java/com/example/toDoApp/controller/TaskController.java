package com.example.toDoApp.controller;

import com.example.toDoApp.controller.dto.TaskDto;
import com.example.toDoApp.model.Task;
import com.example.toDoApp.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.toDoApp.controller.dto.TaskDtoMapper.mapDtoToTask;

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/task")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping("/task")
    public Task createTasks(@RequestBody @Valid TaskDto taskDto){
        return taskService.createTask(mapDtoToTask(taskDto,null)
                );
    }
    @PutMapping("/task/status/{id}")
    @Transactional
    public Task changeTaskStatus(@PathVariable Long id,@RequestBody Task task){
        Task singleTasks = taskService.getSingleTasks(id);

        return taskService.changeTaskStatus(Task.builder()
                        .id(singleTasks.getId())
                        .finished(task.getFinished())
                        .name(singleTasks.getName())
                .build());
    }

    @PutMapping("/task/{id}")
    @Transactional
    public Task changeTask(@RequestBody @Valid TaskDto taskDto, @PathVariable Long id){
        Task singleTasks = taskService.getSingleTasks(id);

        return taskService.changeTask(Task.builder()
                        .id(id)
                        .finished(singleTasks.getFinished())
                        .name(taskDto.getName())
                        .build());
    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable long id){
        this.taskService.deleteTask(id);
    }

    @GetMapping("/task/{finished}")
    public List<Task> getFinishedTasks(@PathVariable boolean finished){
        return this.taskService.getFinishedTasks(finished);
    }
}
