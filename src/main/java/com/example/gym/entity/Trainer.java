package com.example.gym.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Trainer extends User {
    private List<TrainingType> specialization;
}
