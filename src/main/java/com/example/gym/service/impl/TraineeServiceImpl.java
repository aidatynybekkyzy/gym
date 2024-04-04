package com.example.gym.service.impl;

import com.example.gym.entity.Trainee;
import com.example.gym.repository.TraineeDAO;
import com.example.gym.service.TraineeService;
import com.example.gym.utils.PasswordGenerator;
import com.example.gym.utils.UsernameGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class TraineeServiceImpl implements TraineeService {
    private final TraineeDAO traineeDAO;
    private final UsernameGenerator usernameGenerator;

    public TraineeServiceImpl(TraineeDAO traineeDAO,
                              UsernameGenerator usernameGenerator) {
        this.traineeDAO = traineeDAO;
        this.usernameGenerator = usernameGenerator;
    }

    @Override
    public Optional<Trainee> createTrainee(Trainee trainee) {
        trainee.setUsername(usernameGenerator.generateUsername(trainee));
        trainee.setPassword(PasswordGenerator.generatePassword());
        log.info("________Creating trainee: {}", trainee);
        return traineeDAO.create(trainee);
    }

    @Override
    public Optional<Trainee> getTraineeById(int id) {
        log.info("_________Getting trainee by id: {}", id);
        return traineeDAO.getById(id);
    }

    @Override
    public Optional<Trainee> updateTrainee(Trainee trainee) {
        log.info("________Updating trainee: {}", trainee);
        return traineeDAO.update(trainee);
    }

    @Override
    public boolean deleteTrainee(int id) {
        log.info("________Deleting trainee by id: {}", id);
        return traineeDAO.deleteTrainee(id);
    }
}
