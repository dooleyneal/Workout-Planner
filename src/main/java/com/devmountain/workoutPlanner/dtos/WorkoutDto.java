package com.devmountain.workoutPlanner.dtos;

import com.devmountain.workoutPlanner.entities.User;
import com.devmountain.workoutPlanner.entities.Workout;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutDto {
    private Long id;
    private String name;
    private UserDto userDto;
    private Set<ExerciseDto> exerciseDtoSet = new HashSet<>();

    public WorkoutDto(Workout workout) {
        if (workout.getId() != null) {
            this.id = workout.getId();
        }
        if (workout.getName() != null) {
            this.name = workout.getName();
        }
     }


}
