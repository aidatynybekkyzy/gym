package com.example.gym.repository.impl;

import com.example.gym.entity.Trainer;
import com.example.gym.repository.TrainerDAO;
import com.example.gym.repository.base.BaseDAOImpl;
import org.springframework.stereotype.Repository;

@Repository
public class TrainerDAOImpl extends BaseDAOImpl <Trainer> implements TrainerDAO {
}
