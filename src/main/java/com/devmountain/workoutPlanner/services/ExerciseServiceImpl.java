package com.devmountain.workoutPlanner.services;

import com.devmountain.workoutPlanner.dtos.ExerciseDto;
import com.devmountain.workoutPlanner.entities.Exercise;
import com.devmountain.workoutPlanner.entities.User;
import com.devmountain.workoutPlanner.repositories.ExerciseRepository;
import com.devmountain.workoutPlanner.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    @Transactional
    public void addExercise(ExerciseDto exerciseDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Exercise exercise = new Exercise(exerciseDto);
        userOptional.ifPresent(exercise::setUser);
        exerciseRepository.saveAndFlush(exercise);
    }

    @Override
    @Transactional
    public void deleteExerciseById(Long exerciseId) {
        Optional<Exercise> exerciseOptional = exerciseRepository.findById(exerciseId);
        exerciseOptional.ifPresent(exercise -> exerciseRepository.delete(exercise));
    }

    @Override
    @Transactional
    public void updateExerciseById(ExerciseDto exerciseDto) {
        Optional<Exercise> exerciseOptional = exerciseRepository.findById(exerciseDto.getId());
        exerciseOptional.ifPresent(exercise -> {
            exercise.setName(exerciseDto.getName());
            exercise.setWorkout(exerciseDto.getWorkout());
            exercise.setSets(exerciseDto.getSets());
            exercise.setReps(exerciseDto.getReps());
            exercise.setWeight(exerciseDto.getWeight());
            exercise.setDistance(exerciseDto.getDistance());
            exercise.setDuration(exerciseDto.getDuration());
            exercise.setSpeed(exerciseDto.getSpeed());
            exerciseRepository.saveAndFlush(exercise);

        });
    }

    @Override
    public Optional<ExerciseDto> getExerciseById(Long exerciseId) {
        Optional<Exercise> exerciseOptional = exerciseRepository.findById(exerciseId);
        if (exerciseOptional.isPresent()){
            return Optional.of(new ExerciseDto(exerciseOptional.get()));
        }
        return Optional.empty();
    }

    public List<ExerciseDto> getAllExercisesByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<Exercise> exerciseList = exerciseRepository.findAllByUserEquals(userOptional.get());
            return exerciseList.stream().map(exercise -> new ExerciseDto(exercise)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
