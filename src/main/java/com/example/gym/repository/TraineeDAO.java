package com.example.gym.repository;

import com.example.gym.entity.Trainee;
import com.example.gym.repository.base.BaseDAO;


public interface TraineeDAO extends BaseDAO<Trainee> {

    boolean deleteTrainee(int id);
}
