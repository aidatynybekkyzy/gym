package com.example.gym.repository.base;

import com.example.gym.entity.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface BaseDAO<T> {

    Optional<T> getById(int id);

    Optional<T> create(T user);

    Optional<T> update(T user);

    boolean existsByFirstnameAndLastname(String firstname, String lastname);

    int countByFirstnameAndLastname(String firstname, String lastname);
}
