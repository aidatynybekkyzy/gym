package com.example.gym.service;

import com.example.gym.entity.Training;
import com.example.gym.entity.TrainingType;
import com.example.gym.repository.TrainingDAO;
import com.example.gym.service.impl.TrainingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TrainingServiceImplTest {
    private TrainingServiceImpl trainingService;

    @Mock
    private TrainingDAO trainingDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        trainingService = new TrainingServiceImpl(trainingDAO);
    }

    @Test
    public void testGetTrainingById() {
        trainingService.getTrainingById(1);
        verify(trainingDAO, times(1)).getById(1);
    }

    @Test
    public void testCreateTraining() {
        Training training = new Training();
        training.setId(1);
        training.setTrainingName("Test training name");
        training.setTrainingType(TrainingType.CARDIO);
        training.setDate(new Date());
        training.setDuration(60);
        training.setTraineeId(1);
        training.setTrainerId(1);

        when(trainingDAO.create(training)).thenReturn(Optional.of(training));

        Optional<Training> createdTraining = trainingService.createTraining(training);
        assertEquals(Optional.of(training), createdTraining);

    }
}
