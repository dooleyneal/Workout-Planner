package com.devmountain.workoutPlanner.entities;

import com.devmountain.workoutPlanner.dtos.ExerciseDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Exercises")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSets() {
        return sets;
    }

    public void setSets(Long sets) {
        this.sets = sets;
    }

    public Long getReps() {
        return reps;
    }

    public void setReps(Long reps) {
        this.reps = reps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Exercise(Long id, String name, Long sets, Long reps, double weight, double distance, double duration, double speed, Workout workout) {
        this.id = id;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.distance = distance;
        this.duration = duration;
        this.speed = speed;
        this.workout = workout;
    }



    public Exercise() {
    }

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
        if (exerciseDto.getWeight() != 0) {
            this.weight = exerciseDto.getWeight();
        }
        if (exerciseDto.getDuration() != 0) {
            this.duration = exerciseDto.getDuration();
        }
        if (exerciseDto.getDistance() != 0) {
            this.distance = exerciseDto.getDistance();
        }

    }
}
