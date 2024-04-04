package com.example.gym.repository.base;

import com.example.gym.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class BaseDAOImpl<T extends User> implements BaseDAO<T> {
    private final Map<Integer, T> users = new HashMap<>();

    @Override
    public Optional<T> getById(int id) {
        return Optional.of(users.get(id));
    }

    @Override
    public Optional<T> create(T user) {
        int id = user.getId();
        if (users.containsKey(id)) {
            log.error("________User with id {} already exists", id);
            return Optional.empty();
        }
        users.put(id, user);
        return Optional.of(users.get(id));
    }

    @Override
    public Optional<T> update(T user) {
        int id = user.getId();
        if (users.containsKey(id)) {
            users.put(id, user);
            return Optional.of(users.get(id));
        }
        log.error("_________User with id {} not found", id);
        return Optional.empty();
    }


    @Override
    public boolean existsByFirstnameAndLastname(String firstname, String lastname) {
        return users.values().stream().noneMatch(user -> user.getFirstname().equals(firstname) && user.getLastname().equals(lastname));
    }

    @Override
    public int countByFirstnameAndLastname(String firstname, String lastname) {
        int count = 0;
        for (User user : users.values()) {
            if (user.getFirstname().equals(firstname) && user.getLastname().equals(lastname)) {
                count++;
            }
        }
        return count;
    }
}
