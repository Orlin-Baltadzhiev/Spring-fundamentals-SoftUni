package com.gira.repositories;

import com.gira.model.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    @Query("SELECT t from Task t WHERE t.id = :id")
    Optional<Task> findById(String id);
}
