package com.devmountain.workoutPlanner.entities;

import com.devmountain.workoutPlanner.dtos.WorkoutDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Workouts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JsonBackReference
    private User user;

    @OneToMany
    @JsonManagedReference
    private Set<Exercise> exerciseSet = new HashSet<>();



    public Workout(WorkoutDto workoutDto) {
        if (workoutDto.getId() != null) {
            this.id = workoutDto.getId();
        }
        if (workoutDto.getName() != null) {
            this.name = workoutDto.getName();
        }
    }
}
