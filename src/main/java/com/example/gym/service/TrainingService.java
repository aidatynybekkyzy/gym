package com.example.gym.service;

import com.example.gym.entity.Training;

import java.util.Optional;

public interface TrainingService {

    Optional<Training> getTrainingById(int id);

    Optional<Training> createTraining(Training training);
}
