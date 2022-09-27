package com.devmountain.workoutPlanner.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

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

    public Equipment(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Exercises_Equipment> getExercises_equipmentsSet() {
        return exercises_equipmentsSet;
    }

    public void setExercises_equipmentsSet(Set<Exercises_Equipment> exercises_equipmentsSet) {
        this.exercises_equipmentsSet = exercises_equipmentsSet;
    }

    public Equipment() {
    }

    public Equipment(Long id, String name, Set<Exercises_Equipment> exercises_equipmentsSet) {
        this.id = id;
        this.name = name;
        this.exercises_equipmentsSet = exercises_equipmentsSet;
    }
}
