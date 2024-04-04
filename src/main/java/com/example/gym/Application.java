package com.example.gym;

import com.example.gym.config.BeanProvider;
import com.example.gym.config.GymStorage;
import com.example.gym.service.TraineeService;
import com.example.gym.service.TrainerService;
import com.example.gym.service.TrainingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        GymStorage gymStorage = BeanProvider.getGymStorage();
        TrainerService trainerService = BeanProvider.getTrainerService();
        TraineeService traineeService = BeanProvider.getTraineeService();
        TrainingService trainingService = BeanProvider.getTrainingService();

        log.info("\n\n>>>> START  ==============\n");
        gymStorage.getTrainees().values().stream().forEach(x -> log.info(x.toString()));
        log.info("^^^^ TRAINEES\n");
        gymStorage.getTrainers().values().stream().forEach(x -> log.info(x.toString()));
        log.info("^^^^ TRAINERS\n");
        gymStorage.getTrainings().values().stream().forEach(x -> log.info(x.toString()));
        log.info("^^^^ TRAININGS\n");

        log.info("\n\tSTART\n");
        log.info("list of TRAINEES:");
        gymStorage.getTrainees().values().stream().forEach(x -> log.info(x.toString()));
        log.info("list of TRAINERS:");
        gymStorage.getTrainers().values().stream().forEach(x -> log.info(x.toString()));
        log.info("list of TRAININGS:");
        gymStorage.getTrainings().values().stream().forEach(x -> log.info(x.toString()));


    }

}
