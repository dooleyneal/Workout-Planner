package com.devmountain.workoutPlanner.repositories;

import com.devmountain.workoutPlanner.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
