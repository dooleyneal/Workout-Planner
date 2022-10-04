package com.devmountain.workoutPlanner.entities;

import com.devmountain.workoutPlanner.dtos.WorkoutDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Workouts")
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Exercise> getExerciseSet() {
        return exerciseSet;
    }

    public void setExerciseSet(Set<Exercise> exerciseSet) {
        this.exerciseSet = exerciseSet;
    }

    public Workout(Long id, String name, User user, Set<Exercise> exerciseSet) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.exerciseSet = exerciseSet;
    }

    public Workout(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Workout() {
    }

    public Workout(WorkoutDto workoutDto) {
        if (workoutDto.getId() != null) {
            this.id = workoutDto.getId();
        }
        if (workoutDto.getName() != null) {
            this.name = workoutDto.getName();
        }
    }
}
