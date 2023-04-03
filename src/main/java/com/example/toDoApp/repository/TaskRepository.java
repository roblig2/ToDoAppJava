package com.example.toDoApp.repository;

import com.example.toDoApp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query("select t from Task t where finished = ?1")
    List<Task> findAllByFinished(boolean finished);
}
