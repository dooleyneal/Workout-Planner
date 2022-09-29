package com.devmountain.workoutPlanner.dtos;

import com.devmountain.workoutPlanner.entities.Equipment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDto implements Serializable {
    private Long id;
    private String name;
    private Set<Exercises_EquipmentDto> exercises_equipmentDtoSet = new HashSet<>();

    public EquipmentDto(Equipment equipment) {
        if (equipment.getId() != null) {
            this.id = equipment.getId();
        }
        if (equipment.getName() != null) {
            this.name = equipment.getName();
        }
    }
}
