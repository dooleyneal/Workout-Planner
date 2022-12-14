package com.devmountain.workoutPlanner.repositories;

import com.devmountain.workoutPlanner.entities.Exercise;
import com.devmountain.workoutPlanner.entities.User;
import com.devmountain.workoutPlanner.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findAllByWorkoutEquals(Workout workout);
}
