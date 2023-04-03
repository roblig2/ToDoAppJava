package com.example.toDoApp.controller.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
public class TaskDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Pole nie moze być puste")
    private String name;
    private boolean finished;
}
