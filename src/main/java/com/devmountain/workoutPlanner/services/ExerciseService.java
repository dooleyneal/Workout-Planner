package com.devmountain.workoutPlanner.services;

import com.devmountain.workoutPlanner.dtos.ExerciseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {
    @Transactional
    void addExercise(ExerciseDto exerciseDto, Long userId);

    @Transactional
    void deleteExerciseById(Long exerciseId);

    @Transactional
    void updateExerciseById(ExerciseDto exerciseDto);

    Optional<ExerciseDto> getExerciseById(Long exerciseId);

    List<ExerciseDto> getAllExercisesByUserId(Long userId);
}
