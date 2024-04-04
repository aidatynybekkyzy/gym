package com.example.gym.config;

import com.example.gym.service.TraineeService;
import com.example.gym.service.TrainerService;
import com.example.gym.service.TrainingService;
import org.springframework.context.ApplicationContext;

public class BeanProvider {
    private static final ApplicationContext context = ApplicationContextProvider.getContext();

    public static GymStorage getGymStorage() {
        return context.getBean(GymStorage.class);
    }

    public static TrainerService getTrainerService() {
        return context.getBean(TrainerService.class);
    }

    public static TraineeService getTraineeService() {
        return context.getBean(TraineeService.class);
    }

    public static TrainingService getTrainingService() {
        return context.getBean(TrainingService.class);
    }
}
