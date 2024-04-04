package com.example.gym.service;

import com.example.gym.entity.Trainee;

import java.util.Optional;

public interface TraineeService {

    Optional<Trainee> getTraineeById(int id);

    Optional<Trainee> createTrainee(Trainee trainee);

    Optional<Trainee> updateTrainee(Trainee trainee);

    boolean deleteTrainee(int id);
}
