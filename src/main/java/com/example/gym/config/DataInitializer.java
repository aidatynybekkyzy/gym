package com.example.gym.config;

import com.example.gym.entity.Trainee;
import com.example.gym.entity.Trainer;
import com.example.gym.entity.Training;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;

@Slf4j
@Component
public class DataInitializer {
    private final GymStorage gymStorage;
    private final ObjectMapper objectMapper;

    public DataInitializer(GymStorage gymStorage,
                           ObjectMapper objectMapper) {
        this.gymStorage = gymStorage;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void initialize() {
        log.info("________Initializing data");
        initializeTrainerData();
        initializeTraineeData();
        initializeTrainingData();
    }

    private void initializeTrainingData() {
        log.info("________Initializing training data");
        try {
            Training[] trainings = objectMapper.readValue(new File("src/main/resources/static/training.json"), Training[].class);
            for (Training training : trainings) {
                gymStorage.getTrainings().put(training.getId(), training);
            }
        } catch (Exception e) {
            log.error("________Failed to initialize training data", e);
        }
    }

    private void initializeTrainerData() {
        log.info("________Initializing trainer data");
        try {
            Trainer[] trainers = objectMapper.readValue(new File("src/main/resources/static/trainer.json"), Trainer[].class);
            for (Trainer trainer : trainers) {
                gymStorage.getTrainers().put(trainer.getId(), trainer);
            }
        } catch (Exception e) {
            log.error("________Failed to initialize trainer data", e);
        }
    }

    private void initializeTraineeData() {
        log.info("________Initializing trainee data");
        try {
            Trainee[] trainees = objectMapper.readValue(new File("src/main/resources/static/trainee.json"), Trainee[].class);
            for (Trainee trainee : trainees) {
                gymStorage.getTrainees().put(trainee.getId(), trainee);
            }
        } catch (Exception e) {
            log.error("________Failed to initialize trainee data", e);
        }
    }
}


