package com.example.gym.repository;

import com.example.gym.entity.Training;

import java.util.Optional;

public interface TrainingDAO {
    public Optional<Training> getById(int id);

    public Optional<Training> create(Training training);

}
