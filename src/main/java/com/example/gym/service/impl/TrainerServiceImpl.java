package com.example.gym.service.impl;

import com.example.gym.entity.Trainer;
import com.example.gym.repository.TrainerDAO;
import com.example.gym.service.TrainerService;
import com.example.gym.utils.PasswordGenerator;
import com.example.gym.utils.UsernameGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class TrainerServiceImpl implements TrainerService {
    private final TrainerDAO trainerDAO;
    private final UsernameGenerator usernameGenerator;

    public TrainerServiceImpl(TrainerDAO trainerDAO,
                              UsernameGenerator usernameGenerator) {
        this.trainerDAO = trainerDAO;
        this.usernameGenerator = usernameGenerator;
    }

    @Override
    public Optional<Trainer> getTrainerById(int id) {
        return trainerDAO.getById(id);
    }

    @Override
    public Optional<Trainer> createTrainer(Trainer trainer) {
        trainer.setUsername(usernameGenerator.generateUsername(trainer));
        trainer.setPassword(PasswordGenerator.generatePassword());
        log.info("________Creating trainer: {}", trainer);
        return trainerDAO.create(trainer);
    }

    @Override
    public Optional<Trainer> updateTrainer(Trainer trainer) {
        log.info("________Updating trainer: {}", trainer);
        return trainerDAO.update(trainer);
    }
}
