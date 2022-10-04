package com.devmountain.workoutPlanner.services;

import com.devmountain.workoutPlanner.dtos.WorkoutDto;
import com.devmountain.workoutPlanner.entities.User;
import com.devmountain.workoutPlanner.entities.Workout;
import com.devmountain.workoutPlanner.repositories.UserRepository;
import com.devmountain.workoutPlanner.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    @Autowired private UserRepository userRepository;
    @Autowired private WorkoutRepository workoutRepository;

    @Override
    @Transactional
    public void addWorkout(WorkoutDto workoutDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Workout workout = new Workout(workoutDto);
        userOptional.ifPresent(workout::setUser);
        workoutRepository.saveAndFlush(workout);
    }

    @Override
    @Transactional
    public void deleteWorkoutById(Long workoutId) {
        Optional<Workout> workoutOptional = workoutRepository.findById(workoutId);
        workoutOptional.ifPresent(workout -> workoutRepository.delete(workout));
    }

    @Override
    public List<WorkoutDto> getAllWorkoutsByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()) {
            List<Workout> workoutList = workoutRepository.findAllByUserEquals(userOptional.get());
            return workoutList.stream().map(workout -> new WorkoutDto(workout)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<WorkoutDto> getWorkoutById(Long workoutId) {
        Optional<Workout> workoutOptional = workoutRepository.findById(workoutId);
        if(workoutOptional.isPresent()) {
            return Optional.of(new WorkoutDto(workoutOptional.get()));
        }
        return Optional.empty();
    }
}
