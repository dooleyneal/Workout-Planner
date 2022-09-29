package com.devmountain.workoutPlanner.repositories;

import com.devmountain.workoutPlanner.entities.Exercises_Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Exercises_EquipmentRepository extends JpaRepository<Exercises_Equipment, Long> {
}
