package com.example.gym.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class Training {
    private int id;
    private int traineeId;
    private int trainerId;
    private String trainingName;
    private TrainingType trainingType;
    private Date date;
    private int duration;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Training training)) return false;
        return getId() == training.getId() && getTraineeId() == training.getTraineeId()
                && getTrainerId() == training.getTrainerId() && getDuration() == training.getDuration()
                && Objects.equals(getTrainingName(), training.getTrainingName())
                && getTrainingType() == training.getTrainingType() && Objects.equals(getDate(), training.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTraineeId(), getTrainerId(), getTrainingName(), getTrainingType(), getDate(), getDuration());
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", traineeId=" + traineeId +
                ", trainerId=" + trainerId +
                ", trainingName='" + trainingName + '\'' +
                ", trainingType=" + trainingType +
                ", date=" + date +
                ", duration=" + duration +
                '}';
    }
}
