package com.example.gym.service;

import com.example.gym.entity.Trainer;
import com.example.gym.repository.TrainerDAO;
import com.example.gym.service.impl.TrainerServiceImpl;
import com.example.gym.utils.UsernameGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TrainerServiceImplTest {
    private TrainerServiceImpl trainerService;

    @Mock
    private TrainerDAO trainerDAO;

    @Mock
    private UsernameGenerator usernameGenerator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        trainerService = new TrainerServiceImpl(trainerDAO, usernameGenerator);
    }

    @Test
    public void testCreateTrainer() {

        Trainer trainer = new Trainer();
        trainer.setId(1);
        trainer.setFirstname("Jason");
        trainer.setLastname("Statham");
        trainer.setIsActive("true");

        when(usernameGenerator.generateUsername(trainer)).thenReturn("Jason.Statham");
        when(trainerDAO.create(trainer)).thenReturn(Optional.of(trainer));

        Optional<Trainer> createdTrainer = trainerService.createTrainer(trainer);
        assertEquals(Optional.of(trainer), createdTrainer);
        assertEquals("Jason.Statham", createdTrainer.get().getUsername());
        verify(trainerDAO, times(1)).create(trainer);
    }

    @Test
    public void testGetTrainerById() {
        Trainer trainer = new Trainer();
        trainer.setId(1);
        trainer.setFirstname("Jason");
        trainer.setLastname("Statham");
        trainer.setIsActive("true");

        when(trainerDAO.getById(1)).thenReturn(Optional.of(trainer));

        Optional<Trainer> retrievedTrainer = trainerService.getTrainerById(1);
        assertEquals(Optional.of(trainer), retrievedTrainer);
        verify(trainerDAO, times(1)).getById(1);
    }

    @Test
    public void testUpdateTrainer() {
        Trainer trainer = new Trainer();
        trainer.setId(1);
        trainer.setFirstname("Jason");
        trainer.setLastname("Statham");
        trainer.setIsActive("true");

        when(trainerDAO.update(trainer)).thenReturn(Optional.of(trainer));

        Optional<Trainer> updatedTrainer = trainerService.updateTrainer(trainer);
        assertEquals(Optional.of(trainer), updatedTrainer);
        verify(trainerDAO, times(1)).update(trainer);
    }
}
