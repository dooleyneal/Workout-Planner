package com.devmountain.workoutPlanner.services;

import com.devmountain.workoutPlanner.dtos.UserDto;
import com.devmountain.workoutPlanner.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public List<String> addUser (UserDto userDto) {

        return null;
    }
}
