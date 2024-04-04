package com.example.gym.config;

import com.example.gym.entity.Trainee;
import com.example.gym.entity.Trainer;
import com.example.gym.entity.Training;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Component
public class GymStorage {
    private Map<Integer, Trainee> trainees = new HashMap<>();
    private Map<Integer, Trainer> trainers = new HashMap<>();
    private Map<Integer, Training> trainings = new HashMap<>();

}
