package com.devmountain.workoutPlanner.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "Exercises_Equipment")
public class Exercises_Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonBackReference
    private Exercise exercise;

    @ManyToOne
    @JsonBackReference
    private Equipment equipment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Exercises_Equipment(int id, Exercise exercise, Equipment equipment) {
        this.id = id;
        this.exercise = exercise;
        this.equipment = equipment;
    }

    public Exercises_Equipment() {
    }
}
