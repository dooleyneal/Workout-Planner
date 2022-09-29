package com.devmountain.workoutPlanner.dtos;

import com.devmountain.workoutPlanner.entities.Exercises_Equipment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercises_EquipmentDto implements Serializable {
    private Long id;
    private ExerciseDto exerciseDto;
    private EquipmentDto equpmentDto;

    public Exercises_EquipmentDto(Exercises_Equipment exercises_equipment) {
        if (exercises_equipment.getId() != null) {
            this.id = exercises_equipment.getId();
        }
    }

}
