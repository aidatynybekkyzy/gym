package com.example.gym.repository.impl;

import com.example.gym.entity.Training;
import com.example.gym.repository.TrainingDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class TrainingDAOImpl implements TrainingDAO {
    private final Map<Integer, Training> trainings = new HashMap<>();

    @Override
    public Optional<Training> getById(int id) {
        return Optional.of(trainings.get(id));
    }

    @Override
    public Optional<Training> create(Training training) {
        int id = training.getId();
        if (trainings.containsKey(id)) {
            log.error("_________Training with id {} already exists", id);
            return Optional.empty();
        }
        trainings.put(id, training);
        return Optional.of(trainings.get(id));
    }
}
