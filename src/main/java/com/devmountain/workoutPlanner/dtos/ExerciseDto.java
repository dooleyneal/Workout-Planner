package com.devmountain.workoutPlanner.dtos;

import com.devmountain.workoutPlanner.entities.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDto implements Serializable {
    private Long id;
    private String name;
    private String workout;
    private Long sets;
    private Long reps;
    private double weight;
    private double duration;
    private double distance;
    private double speed;
    private UserDto userDto;
    private Set<Exercises_EquipmentDto> exercises_equipmentDtoSet = new HashSet<>();

    public ExerciseDto(Exercise exercise) {
        if (exercise.getId() != null) {
            this.id = exercise.getId();
        }
        if (exercise.getName() != null) {
            this.name = exercise.getName();
        }
        if (exercise.getWorkout() != null) {
            this.workout = exercise.getWorkout();
        }
        if (exercise.getSets() != null) {
            this.sets = exercise.getSets();
        }
        if (exercise.getReps() != null) {
            this.reps = exercise.getReps();
        }
        if (exercise.getWeight() != 0) {
            this.weight = exercise.getWeight();
        }
        if (exercise.getDuration() != 0) {
            this.duration = exercise.getDuration();
        }
        if (exercise.getDistance() != 0) {
            this.distance = exercise.getDistance();
        }

    }


}