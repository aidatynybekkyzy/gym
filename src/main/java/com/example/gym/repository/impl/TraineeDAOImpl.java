package com.example.gym.repository.impl;

import com.example.gym.config.GymStorage;
import com.example.gym.entity.Trainee;
import com.example.gym.repository.TraineeDAO;
import com.example.gym.repository.base.BaseDAOImpl;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class TraineeDAOImpl extends BaseDAOImpl <Trainee> implements TraineeDAO{
    private final Map<Integer, Trainee> trainees;

    public TraineeDAOImpl(GymStorage storage) {
        this.trainees = storage.getTrainees();
    }

    public boolean deleteTrainee(int id) {
        trainees.remove(id);
        return !trainees.containsKey(id);
    }
}
