package com.devmountain.workoutPlanner.Controllers;

import com.devmountain.workoutPlanner.dtos.WorkoutDto;
import com.devmountain.workoutPlanner.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @GetMapping("/user/{userId}")
    public List<WorkoutDto> getWorkoutsByUser(@PathVariable Long userId) {
        return workoutService.getAllWorkoutsByUserId(userId);
    }

    @PostMapping("/user/{userId}")
    public void addWorkout(@RequestBody WorkoutDto workoutDto, @PathVariable Long userId) {
        workoutService.addWorkout(workoutDto, userId);
    }

    @DeleteMapping("/{workoutId}")
    public void deleteWorkoutById(@PathVariable Long workoutId) {
        workoutService.deleteWorkoutById(workoutId);
    }

    @GetMapping("/{workoutId}")
    public Optional<WorkoutDto> getNoteById(@PathVariable Long workoutId) {
       return workoutService.getWorkoutById(workoutId);
    }

}
