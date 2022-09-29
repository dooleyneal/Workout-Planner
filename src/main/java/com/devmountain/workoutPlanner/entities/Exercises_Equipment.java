package com.devmountain.workoutPlanner.entities;

import com.devmountain.workoutPlanner.dtos.Exercises_EquipmentDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "Exercises_Equipment")
public class Exercises_Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Exercise exercise;

    @ManyToOne
    @JsonBackReference
    private Equipment equipment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Exercises_Equipment(Long id, Exercise exercise, Equipment equipment) {
        this.id = id;
        this.exercise = exercise;
        this.equipment = equipment;
    }

    public Exercises_Equipment() {
    }

    public Exercises_Equipment(Exercises_EquipmentDto exercises_equipmentDto) {
        if (exercises_equipmentDto.getId() != null) {
            this.id = exercises_equipmentDto.getId();
        }
    }
}
