package com.devmountain.workoutPlanner.entities;

import com.devmountain.workoutPlanner.dtos.ExerciseDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Exercises")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;


    @Column
    private Long sets;

    @Column
    private Long reps;

    @Column
    private double weight;

    @Column
    private double distance;

    @Column
    private double duration;

    @Column
    private double speed;

    @ManyToOne
    @JsonBackReference
    private Workout workout;



    public Exercise(ExerciseDto exerciseDto) {
        if (exerciseDto.getId() != null) {
            this.id = exerciseDto.getId();
        }
        if (exerciseDto.getName() != null) {
            this.name = exerciseDto.getName();
        }
        if (exerciseDto.getSets() != null) {
            this.sets = exerciseDto.getSets();
        }
        if (exerciseDto.getReps() != null) {
            this.reps = exerciseDto.getReps();
        }
        if (exerciseDto.getWeight() >= 0) {
            this.weight = exerciseDto.getWeight();
        }
        if (exerciseDto.getDuration() >= 0) {
            this.duration = exerciseDto.getDuration();
        }
        if (exerciseDto.getDistance() >= 0) {
            this.distance = exerciseDto.getDistance();
        }
        if(exerciseDto.getSpeed() >= 0) {
            this.speed = exerciseDto.getSpeed();
        }

    }
}
