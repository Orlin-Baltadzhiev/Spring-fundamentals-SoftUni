package com.example.repository;

import com.example.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

//    @Query(value = "",nativeQuery = true) => sql queries
    @Query("SELECT e.name FROM Exercise e " +
            "ORDER BY e.name")
    List<String>findAllExNames();

    Optional<Exercise> findByName(String name);
}
