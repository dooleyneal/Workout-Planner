package com.devmountain.workoutPlanner.services;

import com.devmountain.workoutPlanner.dtos.WorkoutDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface WorkoutService {
    @Transactional
    void addWorkout(WorkoutDto workoutDto, Long userId);

    @Transactional
    void deleteWorkoutById(Long workoutId);

    List<WorkoutDto> getAllWorkoutsByUserId(Long userId);

    Optional<WorkoutDto> getWorkoutById(Long workoutId);
}
