package com.example.gym.service;

import com.example.gym.entity.Trainee;
import com.example.gym.repository.TraineeDAO;
import com.example.gym.service.impl.TraineeServiceImpl;
import com.example.gym.utils.UsernameGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TraineeServiceImplTest {
    private TraineeServiceImpl traineeService;

    @Mock
    private TraineeDAO traineeDAO;

    @Mock
    private UsernameGenerator usernameGenerator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        traineeService = new TraineeServiceImpl(traineeDAO, usernameGenerator);
    }

    @Test
    public void testCreateTrainee() {
        Trainee trainee = new Trainee();
        trainee.setId(1);
        trainee.setFirstname("Jason");
        trainee.setLastname("Statham");
        trainee.setAddress("USA");
        trainee.setDateOfBirth("1967-07-26");
        trainee.setIsActive("true");

        when(usernameGenerator.generateUsername(trainee)).thenReturn("Jason.Statham");
        when(traineeDAO.create(trainee)).thenReturn(Optional.of(trainee));

        Optional<Trainee> createdTrainee = traineeService.createTrainee(trainee);
        assertEquals(Optional.of(trainee), createdTrainee);
        assertEquals("Jason.Statham", createdTrainee.get().getUsername());
        verify(traineeDAO, times(1)).create(trainee);
    }


    @Test
    public void testUpdateTrainee() {
        Trainee trainee = new Trainee();
        trainee.setId(1);
        trainee.setFirstname("Jason");
        trainee.setLastname("Statham");
        trainee.setAddress("USA");
        trainee.setDateOfBirth("1967-07-26");
        trainee.setIsActive("true");

        when(traineeDAO.update(trainee)).thenReturn(Optional.of(trainee));

        Optional<Trainee> updatedTrainee = traineeService.updateTrainee(trainee);
        assertEquals(Optional.of(trainee), updatedTrainee);
        verify(traineeDAO, times(1)).update(trainee);
    }

    @Test
    public void testGetTraineeById() {
        Trainee trainee = new Trainee();
        trainee.setId(1);
        trainee.setFirstname("Jason");
        trainee.setLastname("Statham");
        trainee.setAddress("USA");
        trainee.setDateOfBirth("1967-07-26");
        trainee.setIsActive("true");

        when(traineeDAO.getById(1)).thenReturn(Optional.of(trainee));

        Optional<Trainee> retrievedTrainee = traineeService.getTraineeById(1);
        assertEquals(Optional.of(trainee), retrievedTrainee);
        verify(traineeDAO, times(1)).getById(1);
    }

    @Test
    public void testDeleteTrainee() {
        traineeService.deleteTrainee(1);
        verify(traineeDAO, times(1)).deleteTrainee(1);
    }
}