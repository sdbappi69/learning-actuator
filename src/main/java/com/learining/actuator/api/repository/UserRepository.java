package com.learining.actuator.api.repository;

import com.learining.actuator.api.dto.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class UserRepository {
    public List<User> getAllUsers() {
        return Stream.of(
                new User(1, "John", "john@gmail.com", "Active"),
                new User(2, "Smith", "smith@gmail.com", "Inactive"),
                new User(3, "Peter", "perer@gmail.com", "Active")
        ).collect(Collectors.toList());
    }

    public Long getTotalUsersByStatus(String status) {
        return getAllUsers().stream().filter(user -> user.getStatus().equals(status)).count();
    }
}
