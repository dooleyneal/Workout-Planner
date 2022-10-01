package com.devmountain.workoutPlanner.Controllers;

import com.devmountain.workoutPlanner.dtos.ExerciseDto;
import com.devmountain.workoutPlanner.entities.Exercise;
import com.devmountain.workoutPlanner.services.ExerciseService;
import com.devmountain.workoutPlanner.services.ExerciseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/user/{userId}")
    public List<ExerciseDto> getExercisesByUser(@PathVariable Long userId) {
        return exerciseService.getAllExercisesByUserId(userId);
    }

    @PostMapping("/user/{userId}")
    public void addExercise(@RequestBody ExerciseDto exerciseDto, @PathVariable Long userId) {
        exerciseService.addExercise(exerciseDto, userId);
    }

    @DeleteMapping("/{exerciseId}")
    public void deleteExerciseById(@PathVariable Long exerciseId) {
        exerciseService.deleteExerciseById(exerciseId);
    }

    @PutMapping
    public void updateExercise(@RequestBody ExerciseDto exerciseDto) {
        exerciseService.updateExerciseById(exerciseDto);

    }

    @GetMapping("/{exerciseId}")
    public Optional<ExerciseDto> getExerciseById(@PathVariable Long exerciseId) {
        return exerciseService.getExerciseById(exerciseId);
    }
}
