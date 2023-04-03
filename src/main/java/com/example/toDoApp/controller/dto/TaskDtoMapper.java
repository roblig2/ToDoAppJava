package com.example.toDoApp.controller.dto;

import com.example.toDoApp.model.Task;

public class TaskDtoMapper {
    public static Task mapDtoToTask(TaskDto taskDto, Long id){
        return Task.builder()
                .name(taskDto.getName())
                .finished(false)
                .build();
    }
}
