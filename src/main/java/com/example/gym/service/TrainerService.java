package com.example.gym.service;

import com.example.gym.entity.Trainer;

import java.util.Optional;

public interface TrainerService {

    Optional<Trainer> getTrainerById(int id);

    Optional<Trainer> createTrainer(Trainer trainer);

    Optional<Trainer> updateTrainer(Trainer trainer);
}
