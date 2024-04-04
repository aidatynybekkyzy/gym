package com.example.gym.service.impl;

import com.example.gym.entity.Training;
import com.example.gym.repository.TrainingDAO;
import com.example.gym.service.TrainingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class TrainingServiceImpl implements TrainingService {
    private final TrainingDAO trainingDAO;

    public TrainingServiceImpl(TrainingDAO trainingDAO) {
        this.trainingDAO = trainingDAO;
    }

    @Override
    public Optional<Training> getTrainingById(int id) {
        log.info("_________Getting training by id: {}", id);
        return trainingDAO.getById(id);
    }

    @Override
    public Optional<Training> createTraining(Training training) {
        log.info("_________Creating training: {}", training);
        return trainingDAO.create(training);
    }
}
