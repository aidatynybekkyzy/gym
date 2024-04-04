package com.example.gym.utils;

import com.example.gym.entity.User;
import com.example.gym.repository.TraineeDAO;
import com.example.gym.repository.TrainerDAO;
import org.springframework.stereotype.Component;

@Component
public class UsernameGenerator {
    private final TrainerDAO trainers;
    private final TraineeDAO trainees;

    public UsernameGenerator(TrainerDAO trainers,
                             TraineeDAO trainees) {
        this.trainers = trainers;
        this.trainees = trainees;
    }


    public  String generateUsername(User user) {
        String firstName = user.getFirstname();
        String lastName = user.getLastname();

        String username;
        int serialNumber;

        if (trainers.existsByFirstnameAndLastname(firstName, lastName)) {
            serialNumber = trainers.countByFirstnameAndLastname(firstName, lastName) + 1;
            username = firstName + lastName + serialNumber;
        } else if (trainees.existsByFirstnameAndLastname(firstName, lastName)) {
            serialNumber = trainees.countByFirstnameAndLastname(firstName, lastName) + 1;
            username = firstName + lastName + serialNumber;
        } else {
            username = firstName + lastName;
        }
        return username;
    }

}
