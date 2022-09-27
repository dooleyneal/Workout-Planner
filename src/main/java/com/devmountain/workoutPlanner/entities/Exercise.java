package com.devmountain.workoutPlanner.entities;

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
    private String workout;

    @Column
    private int sets;

    @Column
    private int reps;

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
    private User user;

    @OneToMany(mappedBy = "exercise", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Exercises_Equipment> exercises_equipmentsSet = new HashSet<>();

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

    public String getWorkout() {
        return workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Exercises_Equipment> getExercises_equipmentsSet() {
        return exercises_equipmentsSet;
    }

    public void setExercises_equipmentsSet(Set<Exercises_Equipment> exercises_equipmentsSet) {
        this.exercises_equipmentsSet = exercises_equipmentsSet;
    }

    public Exercise(Long id, String name, String workout, int sets, int reps, double weight, double distance, double duration, double speed, User user, Set<Exercises_Equipment> exercises_equipmentsSet) {
        this.id = id;
        this.name = name;
        this.workout = workout;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.distance = distance;
        this.duration = duration;
        this.speed = speed;
        this.user = user;
        this.exercises_equipmentsSet = exercises_equipmentsSet;
    }



    public Exercise() {
    }
}
