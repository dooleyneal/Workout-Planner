package com.devmountain.workoutPlanner.repositories;

import com.devmountain.workoutPlanner.entities.User;
import com.devmountain.workoutPlanner.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findAllByUserEquals(User user);
}
